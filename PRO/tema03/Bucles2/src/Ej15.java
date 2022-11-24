import java.util.Scanner;

public class Ej15 {
	/**
	 * 15.- Diseñar un algoritmo que lee “N” caracteres y contabiliza el número de veces
	 * que se repiten las vocales a, e, i, o, y u
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		byte n, vocales = 0;
		char[] caracteres;

		System.out.print("Numero de caracteres -> "); n = scanner.nextByte();
		caracteres = new char[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Introduce un caracter -> "); caracteres[i] = scanner.next().charAt(0);

			caracteres[i] = Character.toUpperCase(caracteres[i]);
			switch (caracteres[i]) {
				case 'A', 'E', 'I', 'O', 'U':
					vocales++;
					break;
			}
		}
		System.out.printf("Has introducido %d vocales", vocales);
	}
}
