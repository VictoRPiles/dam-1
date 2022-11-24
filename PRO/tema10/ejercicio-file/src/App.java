import java.io.File;
import java.util.Scanner;

/**
 * @author Victor
 * @since 29/04/2022 - 8:39
 */
public class App {
	static int profundidadInicial;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file;

		System.out.print("Introduce la ruta del archivo -> "); file = new File(scanner.nextLine());

		if (file.exists()) {
			System.out.println("El fichero existe.");

			System.out.println("Nombre: " + file.getName());
			System.out.println("Ruta absoluta: " + file.getAbsolutePath());

			if (file.isDirectory()) {
				System.out.println("Es un directorio.");

				System.out.println("Lista de archivos: ");
				/* para dibujar el árbol de directorios correctamente, una tontería pero quería hacerlo */
				profundidadInicial = (
						file.getPath().length() - file.getPath().replace("\\", "").length()
				) + 1;

				listFilesRecursivo(file);

			} else {
				System.out.println("Tamanyo: " + file.length() + "B");

				renombrar(file, "copiaFichero");
			}
		} else {
			System.out.println("No existe el fichero " + file.getPath());
		}

	}

	/**
	 * Lista los archivos de los directorios de forma recursiva.
	 *
	 * @see #pintarArbol(File)
	 */
	private static void listFilesRecursivo(File file) {
		for (int i = 0; i < file.listFiles().length; i++) {
			File thisArchivo = file.listFiles()[i];

			pintarArbol(thisArchivo);

			System.out.println(thisArchivo);

			if (thisArchivo.isDirectory()) {
				listFilesRecursivo(thisArchivo);
			}
		}
	}

	/**
	 * Dibuja una estructura de directorios en árbol.
	 * <p>
	 * Los directorios se marcan con '+' y los ficheros con '-'.
	 */
	private static void pintarArbol(File thisArchivo) {
		int profundidad = (
				thisArchivo.getPath().length() - thisArchivo.getPath().replace("\\", "").length()
		) - profundidadInicial;

		for (int j = 0; j < profundidad; j++) {
			System.out.print("  ");

			if (j == profundidad - 1 && thisArchivo.isDirectory()) {
				System.out.print("+");
			} else if (j == profundidad - 1) {
				System.out.print("-");
			}
		}

		if (profundidad > 0) {
			System.out.print(" ");
		} else if (thisArchivo.isDirectory()) {
			System.out.print("+ ");
		} else {
			System.out.print("- ");
		}
	}

	/** Cambia el nombre al archivo por el String pasado por parámetro, se mantiene la ruta y la extensión. */
	private static void renombrar(File file, String nuevoNombre) {
		String[] splitPorPuntos;
		String rutaSinNombre, extension;
		int extensionIndex;

		if (!file.getName().equals(nuevoNombre)) {
			return;
		}

		/* separa por delimitador '.' */
		splitPorPuntos = file.getName().split("\\.");
		/* indice del último elemento */
		extensionIndex = splitPorPuntos.length - 1;
		/* la extensión es el texto después del último '.' */
		extension = splitPorPuntos[extensionIndex];

		rutaSinNombre = file.getParent() + "/";

		if (file.renameTo(new File(rutaSinNombre + nuevoNombre + "." + extension))) {
			System.out.println("Cambiando de nombre a " + nuevoNombre + "." + extension + " ...");
		}
	}
}