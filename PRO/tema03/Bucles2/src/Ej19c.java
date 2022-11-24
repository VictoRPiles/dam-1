import java.util.Scanner;

public class Ej19c {
	/**
	 * 19c.- Diseña un algoritmo que calcule y muestre el factorial de un número
	 * entero positivo dado por teclado
	 *
	 * RESPUESTA
	 * Este programa tendría el mismo funcionamiento utilizando el bucle while
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero, numeroInicial, factorial = 1;

		System.out.print("Introduce el numero -> "); numero = scanner.nextInt();

		numeroInicial = numero;
		if (numero > 0) {
			do {
				factorial = factorial * numero;
				numero--;
			} while (numero != 0);
			System.out.printf("!%d -> %d", numeroInicial, factorial);
		} else {
			System.out.println("ERROR: El numero debe ser positivo");
		}
	}
}
