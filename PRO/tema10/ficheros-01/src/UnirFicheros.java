import java.io.*;
import java.util.Scanner;

/**
 * @author Victor
 * @since 02/05/2022 - 12:56
 */
public class UnirFicheros {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file1, file2;
		String path1, path2, separador;

		System.out.print("Introduce la ruta del primer fichero -> "); path1 = scanner.nextLine();
		System.out.print("Introduce la ruta del segundo fichero -> "); path2 = scanner.nextLine();

		file1 = new File(path1);
		file2 = new File(path2);

		if (file1.exists() && file2.exists()) {
			File resultado;

			System.out.print("Introduce el separador -> "); separador = scanner.nextLine();
			resultado = unir(file1, file2, separador);

			System.out.printf("El resultado se encuentra en %s\n", resultado.getPath());
		} else {
			System.out.println("Ruta a los ficheros incorrecta");
		}
	}

	/**
	 * @return Cantidad de líneas en un {@link File}.
	 */
	private static long contarLineas(File file) {
		long lineas = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while (reader.readLine() != null) lineas++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lineas;
	}

	/**
	 * Lee una línea de cada {@link File} y la une con la del otro {@link File}, entre estas introduce un separador.
	 * <p>
	 * Escribe el resultado de la unión en otro {@link File}.
	 * <p>
	 * Si uno de los dos {@link File} no tiene más líneas, escribirá lo que quede en el otro, sin el separador.
	 *
	 * @return {@link File} con la información de dos archivos.
	 * @see #contarLineas(File)
	 */
	private static File unir(File file1, File file2, String separador) {
		File resultado = new File("resultado.txt");
		String lineaFile1, lineaFile2;
		StringBuilder nuevoTexto = new StringBuilder();
		boolean hayLineaFile1 = false;

		/* La cantidad de líneas del archivo con más líneas */
		final long MAX_LINEAS = Math.max(contarLineas(file1), contarLineas(file2));

		try {
			BufferedReader brFile1 = new BufferedReader(new FileReader(file1));
			BufferedReader brFile2 = new BufferedReader(new FileReader(file2));
			BufferedWriter bw = new BufferedWriter(new FileWriter(resultado));

			for (int i = 0; i < MAX_LINEAS; i++) {
				if ((lineaFile1 = brFile1.readLine()) != null) {
					hayLineaFile1 = true;
					nuevoTexto.append(lineaFile1);
				}
				if ((lineaFile2 = brFile2.readLine()) != null) {
					/* Si hay algo antes de la lineaFile2, añade el separador */
					if (hayLineaFile1) {
						nuevoTexto.append(separador);
					}

					nuevoTexto.append(lineaFile2);
				}

				nuevoTexto.append("\n");
				hayLineaFile1 = false;
			}

			/* Escribir en el fichero */
			bw.write(nuevoTexto.toString());

			/* Cerrar buffers */
			brFile1.close();
			brFile2.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultado;
	}
}