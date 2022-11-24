import java.util.Scanner;

public class Ej1 {
	/**
	 * 1.- Programa que lea 10 números y cuente cuantos de ellos son positivos.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numeros = new int[10];
		int negativo = 0;

		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Introduce el " + (i + 1) + " numero -> "); numeros[i] = scanner.nextInt();
			if (numeros[i] < 0) {
				System.out.println("Es negativo");
				negativo++;
			} else {
				System.out.println("Es positivo");
			}
		}
		System.out.println("Has introducido " + negativo + " números negativos");
	}
}
