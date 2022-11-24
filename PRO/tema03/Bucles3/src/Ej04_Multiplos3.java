import java.util.Scanner;

public class Ej04_Multiplos3 {
	/**
	 * 4.- Programa que dado un número N positivo leído por teclado, calcule los múltiplos de 3 que hay entre 3 y N y
	 * para cada múltiplo calcule sus divisores. Por ejemplo, la salida del programa para N=10 sería:
	 * Múltiplo=3 divisores: del 3=(1,3)
	 * Múltiplo=6 divisores del 6=(1,2,3)
	 * Múltiplo=9 divisores del 9=(1,3,9)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int objetivo;

		System.out.print("Introduce un numero objetivo -> "); objetivo = scanner.nextInt();

		for (int i = 3; i < objetivo; i += 3) {
			if (i % 3 == 0) {
				System.out.printf("Múltiplo = %d Divisores = ( ", i);

				// Si i (múltiplo actual) entre j (divisor actual) residuo 0 -> divisor actual es un divisor
				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						System.out.printf("%d ", j);
					}
				}

				System.out.printf(")\n");
			}
		}
	}
}
