import java.io.*;
import java.util.Scanner;

/**
 * @author Victor
 * @since 28/04/2022 - 12:32
 */
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file = new File("resources/fichero.txt");

		if (!file.exists()) {
			try {
				if (file.createNewFile()) {
					System.out.println("Archivo " + file.getPath() + " creado.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.print("Introduce un mensaje -> ");
		escribir(file, scanner.nextLine());
		System.out.println("Escribiendo el contenido...");

		System.out.println("Contenido:");
		leer(file);

		if (file.delete()) {
			System.out.println("Archivo " + file.getName() + " borrado.");
		}
	}

	private static void escribir(File file, String contenido) {
		FileWriter fileWriter;
		try {
			if (file.canWrite()) {
				fileWriter = new FileWriter(file, true);

				fileWriter.write(contenido);

				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void leer(File file) {
		Scanner scanner;

		try {
			if (file.canRead()) {
				scanner = new Scanner(file);

				while (scanner.hasNextLine()) {
					String data = scanner.nextLine();
					System.out.println(data);
				}

				scanner.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}