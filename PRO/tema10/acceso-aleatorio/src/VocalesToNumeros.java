import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Victor
 * @since 12/05/2022 - 10:00
 */
public class VocalesToNumeros {
	public static void main(String[] args) {
		char c;
		boolean finDeFichero = false;
		RandomAccessFile fichero;

		try {
			fichero = new RandomAccessFile("resources/ficheroVocales.txt", "rw");

			do {
				try {
					c = (char) fichero.readByte();

					if (isVocal(c) != -1) {
						fichero.seek(fichero.getFilePointer() - 1);
						fichero.writeByte(isVocal(c));
					}
				} catch (EOFException e) {
					fichero.close();
					finDeFichero = true;
					System.out.println("Convirtiendo las vocales a números...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (!finDeFichero);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int isVocal(char c) {

		return switch (c) {
			case 'A', 'a' -> 1;
			case 'E', 'e' -> 2;
			case 'I', 'i' -> 3;
			case 'O', 'o' -> 4;
			case 'U', 'u' -> 5;
			default -> -1;
		};
	}
}