import java.util.Scanner;

public class Ej16 {
	/**
	 * 16.- Escribir un algoritmo que lee un número entero positivo y seguidamente escribe
	 * el carácter “*”, un número de veces igual al valor numérico leído. En aquellos
	 * casos en que el valor leído no sea positivo se deberá escribir un único asterisco.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		short numero;

		System.out.print("¿Quantos '*' quieres? "); numero = scanner.nextShort();

		if (numero > 0) {
			for (int i = 0; i < numero; i++) {
				System.out.print("* ");
			}
		} else {
			System.out.print("*");
		}
	}
}
