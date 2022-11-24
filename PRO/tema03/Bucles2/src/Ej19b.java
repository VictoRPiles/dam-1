import java.util.Scanner;

public class Ej19b {
	/**
	 * 19b.- Diseña un algoritmo que muestre los números comprendidos entre el 1 y
	 * un número introducido por teclado en orden descendente.
	 *
	 * RESPUESTA
	 * Este programa tendría el mismo funcionamiento utilizando el bucle while
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero, i;

		System.out.print("Introduce un numero -> "); numero = scanner.nextInt();

		i = numero;
		do {
			System.out.println(i);
			i--;
		} while (i > 0);
	}
}
