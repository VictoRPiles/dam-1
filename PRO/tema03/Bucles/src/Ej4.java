import java.util.Scanner;

public class Ej4 {
	/**
	 * 4.- Diseña un algoritmo que introduzca por teclado un número y permita la introducción
	 * de otros números hasta adivinar el número tecleado en primer lugar. Cada vez que se
	 * introduzca un número se visualizará si es mayor o menor que el número a adivinar.
	 * Utiliza un interruptor para determinar cuando se adivina el número.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numeroSecreto, numeroIntroducido;

		System.out.print("Introduce el numero secreto -> "); numeroSecreto = scanner.nextInt();

		do {
			System.out.print("Introduce un numero -> "); numeroIntroducido = scanner.nextInt();
		} while (numeroSecreto != numeroIntroducido);

		System.out.println("CORRECTO! el numero secreto era el " + numeroSecreto);
	}
}