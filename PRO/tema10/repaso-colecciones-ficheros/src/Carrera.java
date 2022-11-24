import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Victor
 * @since 13/05/2022 - 9:44
 */
public class Carrera {
	private static TreeSet<Corredor> corredores = new TreeSet<>();

	public boolean add(Corredor c) {
		return corredores.add(c);
	}

	public boolean remove(Corredor c) {
		return corredores.remove(c);
	}

	public void exportar(File f) throws Exception {
		Scanner scanner = new Scanner(System.in);

		if (f.exists()) {
			System.out.printf("El fichero %s ya existe, ¿quieres sobreescribirlo? (s/n) -> ", f);
			/* Si no se quiere sobreescribir, salir del método */
			if (!scanner.nextLine().equalsIgnoreCase("s")) throw new Exception("No se sobreescribe el fichero.");
		} else if (f.createNewFile()) {
			System.out.printf("Creando fichero %s ...\n", f);
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		System.out.printf("Escribiendo el en fichero %s ...\n", f);

		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		writer.write(this.toString());

		writer.close();
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (Corredor c : corredores) {
			string.append(c);
		}

		return String.format("""
				<carrera>
				%s</carrera>""", string);
	}
}