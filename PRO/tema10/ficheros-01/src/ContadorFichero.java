import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Victor
 * @since 02/05/2022 - 13:54
 */
public class ContadorFichero {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String path;
		File file;

		System.out.print("Ruta del archivo -> "); path = scanner.nextLine();
		file = new File(path);

		if (file.exists()) {
			contarLineasLetras(file);
		} else {
			System.out.println("El archivo no existe");
		}
	}

	private static void contarLineasLetras(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			long lineas = 0;
			String linea;

			while ((linea = reader.readLine()) != null) {
				lineas++;
				System.out.printf("Linea: %3d\tLetras: %3d\n", lineas, linea.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}