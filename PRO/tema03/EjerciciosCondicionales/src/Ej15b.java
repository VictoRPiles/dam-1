import java.util.ArrayList;
import java.util.Scanner;

public class Ej15b {
	/**
	 * 15.- Media. Un programa que lea 4 números y calcule la media.
	 * a. Utiliza sólo 1 variable
	 * b. ¿y si fueran 10 números?
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int entrada = 0;
		double media = 0;
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		System.out.print("Introduce numeros -> ");
		while (entrada >= 0) { // al introducir un numero menor que 0 se asume que no se van a introducir más
			entrada = scanner.nextInt();
			numeros.add(entrada);
		}

		for (int i = 0; i < numeros.size() - 1; i++) { // -1 porque el último número introducido no se cuenta, es solo para salir
			media += numeros.get(i);
		}
		media /= numeros.size() - 1; // -1 porque el último número introducido no se cuenta, es solo para salir

		System.out.println("La media es -> " + media);
	}
}
