import java.util.Scanner;

public class Factorial {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n;

		n = scanner.nextInt();

		System.out.print(factorial(n));
	}

	public static int factorial(int n) {
		int factorial = 1;

		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}

		return factorial;
	}
}