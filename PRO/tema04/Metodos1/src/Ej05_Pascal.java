import java.util.Scanner;

public class Ej05_Pascal {
	/**
	 * 5.- Utilizando las funciones ya implementadas (factorial, combinatorio) construir el triángulo de Pascal para
	 * un número de filas indicado por el usuario:
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		byte filas;

		System.out.print("Numero de filas -> "); filas = scanner.nextByte();

		pascal(filas);
	}

	public static void pascal(byte filas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < (filas - i); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.printf("%d ", combinatorio(i, j));
			}
			System.out.println();
		}
	}

	public static int combinatorio(int n, int m) {
		int comb = (int) (factorial(n) / (factorial(m) * (factorial(n - m))));

		return comb;
	}

	public static double factorial(double n) {
		double fact = 1;

		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}

		return fact;
	}
}
