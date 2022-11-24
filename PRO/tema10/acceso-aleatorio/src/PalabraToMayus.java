import java.io.*;
import java.util.Scanner;

/**
 * @author Victor
 * @since 12/05/2022 - 10:19
 */
public class PalabraToMayus {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final String RUTA = "resources/ficheroMayus.txt";

		System.out.print("Introduce la palabra -> ");
		palabraToMayus(scanner.nextLine(), new File(RUTA));
	}

	private static void palabraToMayus(String palabra, File f) {
		RandomAccessFile fichero = null;

		boolean finPalabra = false;
		boolean EOF = false;
		boolean palabraIgual;

		long puntero = 0;
		int indice = 0;

		char c;
		char[] letras = new char[palabra.length()];

		try {
			fichero = new RandomAccessFile(f, "rw");

			do {
				try {
					/* Se lee un caracter */
					c = (char) fichero.readByte();
					/* Si el puntero no está definido */
					if (puntero == 0) {
						puntero = fichero.getFilePointer() - 1;
					}
					/* Se añaden las letras de la palabra al array, una por vuelta de bucle */
					if (indice < letras.length) {
						letras[indice] = c;
						indice++;
					}
					/* Si se encuentra un espacio */
					if (c == ' ') {
						finPalabra = true;
					}

					/* Si ha terminado la palabra */
					if (finPalabra) {
						palabraIgual = isPalabraIgual(palabra, letras);
						if (palabraIgual) {
							remplazarPalabra(fichero, puntero, letras);
						}

						/* Reinicio de variables */
						finPalabra = false;
						puntero = 0;
						indice = 0;
					}
				} catch (EOFException e) {
					EOF = true;

					/* Para la última palabra del fichero */
					palabraIgual = isPalabraIgual(palabra, letras);
					if (palabraIgual) {
						remplazarPalabra(fichero, puntero, letras);
					}
				}
			} while (!EOF);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/** Comprueba si un char[] contiene las mismas letras que un String. */
	private static boolean isPalabraIgual(String palabra, char[] letras) {
		for (int i = 0; i < letras.length; i++) {
			/* Comprueba si cada letra es igual a las de la palabra */
			if (letras[i] != palabra.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	/** Se situa en la posición del puntero dentro de un {@link RandomAccessFile} y escribe un char[]. */
	private static void remplazarPalabra(RandomAccessFile fichero, long puntero, char[] letras) throws IOException {
		/* Apuntamos al principio de la palabra */
		fichero.seek(puntero);
		for (char letra : letras) {
			/* Escribimos las letras en mayúsculas */
			fichero.writeByte(Character.toUpperCase(letra));
		}
	}
}