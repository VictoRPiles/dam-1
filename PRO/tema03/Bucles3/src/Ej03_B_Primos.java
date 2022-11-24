import java.util.Scanner;

public class Ej03_B_Primos {
	/**
	 * 3-B.- Números primos:
	 * <p>
	 * 1) Programa que lea un número y diga si es primo o no (Un número primo es divisible
	 * únicamente por 1 y por si mismo)
	 * <p>
	 * 2) Amplía el programa anterior para  que muestre todos los números primos menores es que un número introducido
	 * por teclado. Este número debe ser mayor que 4, si no, se volverá a pedir otro número.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero = 0, objetivo;
		boolean esPrimo;

		System.out.print("Introduce un numero objetivo -> ");
		objetivo = scanner.nextInt();

		do {
			numero++;
			esPrimo = true;

			if (numero == 0 || numero == 1 || numero == 4) {
				esPrimo = false;
			} else {
				for (int i = 2; i < numero; i++) {
					if (numero % i == 0) {
						esPrimo = false;
					}
				}
			}
			if (esPrimo) {
				System.out.printf("%02d Es primo\n", numero);
			} else {
				System.out.printf("%02d No es primo\n", numero);
			}
		} while (numero != objetivo);
	}
}
