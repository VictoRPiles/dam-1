import java.util.Scanner;

public class Ej02_Digitos {
	/**
	 * 2.- Escribir un programa que lea una frase desde teclado y diga cuantos dígitos aparecen en
	 * ella. Para saber si un carácter es dígito o no utilizará una función con el siguiente
	 * prototipo:
	 * int esdigito(char c)
	 * Esta función devuelve un 1 si el parámetro c es un dígito y 0 si no lo es.
	 */
	public static void main(String[] args) {
		String frase;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Frase -> "); frase = scanner.nextLine();

		for (int i = 0; i < frase.length(); i++) {
			if (esDigito(frase.charAt(i)) == 1) {
				System.out.printf("%c SI es digito\n", frase.charAt(i));
			} else if (esDigito(frase.charAt(i)) == 0) {
				System.out.printf("%c NO es digito\n", frase.charAt(i));
			} else {
				// si es un espacio, deja un salto de línea
				System.out.println();
			}
		}
	}

	public static int esDigito(char c) {
		if (Character.isDigit(c)) {
			return 1;
		} else {
			if (c == ' ') {
				return 2;
			} else {
				return 0;
			}
		}
	}
}
