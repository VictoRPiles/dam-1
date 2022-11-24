import java.io.*;
import java.util.Scanner;

/**
 * @author Victor
 * @since 02/05/2022 - 14:03
 */
public class AnyadirFicheros {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File origen, destino;
		String path1, path2;

		System.out.print("Introduce la ruta del fichero origen -> "); path1 = scanner.nextLine();
		System.out.print("Introduce la ruta del fichero destino -> "); path2 = scanner.nextLine();

		origen = new File(path1);
		destino = new File(path2);

		if (origen.exists() && destino.exists()) {
			File resultado;

			resultado = anyadir(origen, destino);

			System.out.printf("El resultado se encuentra en %s\n", resultado.getPath());
		} else {
			System.out.println("Ruta a los ficheros incorrecta");
		}
	}

	private static File anyadir(File origen, File destino) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(origen));
			BufferedWriter out = new BufferedWriter(new FileWriter(destino, true));
			String texto;

			while ((texto = in.readLine()) != null) {
				out.write(texto + "\n");
			}

			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destino;
	}
}