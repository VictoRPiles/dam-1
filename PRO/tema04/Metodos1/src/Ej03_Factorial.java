import java.util.Scanner;

public class Ej03_Factorial {
	/**
	 * 3.- Programa que pida un entero no negativo (el programa insistirá pidiendo un número mientras el número
	 * introducido sea negativo) y escriba en pantalla su factorial (El factorial de 0 es 1).
	 * N! = 1*2*3*...*N
	 * para el cálculo de n! crea una función no recursiva de prototipo
	 * double factorial (int n);
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;

		do {
			System.out.print("Introduce un numero -> "); n = scanner.nextInt();
		} while (n < 0);

		System.out.printf("%d! = ", n);
		for (int i = 1; i <= n; i++) {
			if (i != n) {
				System.out.printf("%d * ", i);
			} else {
				System.out.printf("%d = %.2f", i, factorial(n));
			}
		}
	}

	public static double factorial(int n) {
		double fact = 1;

		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}

		return fact;
	}
}
