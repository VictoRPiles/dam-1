package factorial;

public class Factorial {
	public static int calculo(int n) {
		int fact = 1;

		if (n < 0) throw new IllegalArgumentException("Número " + n + " no puede ser menor que 0");

		for (int i = 2; i <= n; i++) {
			fact *= i;
		}

		return fact;
	}
}