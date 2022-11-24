import java.util.Scanner;

public class Ej04_Combinatorio {
	/**
	 * 4.- Programa que calcule y escriba el número combinatorio de dos enteros no negativos introducidos por
	 * teclado
	 * Para el cálculo de este utilizará la función 'combinatorio'.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, m;

		System.out.print("N -> "); n = scanner.nextInt();
		System.out.print("M -> "); m = scanner.nextInt();

		if (n < 0 || m < 0) {
			System.out.println("ERROR: Introduce valores positivos");
		} else if (n < m) {
			System.out.printf("ERROR: 'n' tiene que ser igual o mayor a 'm'");
		} else {
			System.out.printf("Combinatorio de (n -> %d m -> %d) = %.2f", n, m, combinatorio(n, m));
		}
	}

	public static double combinatorio(int n, int m) {
		double comb = (factorial(n) / (factorial(m) * (factorial(n - m))));

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
