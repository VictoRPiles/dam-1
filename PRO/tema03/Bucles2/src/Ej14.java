import java.util.Scanner;

public class Ej14 {
	/**
	 * 14.- Escribir un algoritmo que lea un número y escriba todos los números
	 * comprendidos entre dicho número y la unidad en orden decreciente. (utilizando
	 * el bucle repetir-hasta)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero;

		System.out.print("Introduce el numero ->"); numero = scanner.nextInt();

		do {
			System.out.println(numero);
			numero--;
		} while (numero >= 1);
	}
}
