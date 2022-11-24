import java.util.Scanner;

public class Ej15a {
	/**
	 * 15.- Media. Un programa que lea 4 números y calcule la media.
	 * a. Utiliza sólo 1 variable
	 * b. ¿y si fueran 10 números?
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double media = 0;
		int[] numeros = new int[4];

		System.out.print("Introduce numeros -> ");
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = scanner.nextInt();
			media += numeros[i];
		}
		media /= numeros.length;

		System.out.println("La media es -> "+ media);
	}
}
