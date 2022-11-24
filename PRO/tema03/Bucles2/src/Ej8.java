import java.util.Scanner;

public class Ej8 {
	/**
	 * 8.- Diseña un algoritmo que lea 10 números y cuente los positivos, negativos y nulos
	 * y muestre los totales
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num, positivos = 0, negativos = 0, nulos = 0;       // nulos son ceros
		byte i = 0;

		while (i < 10) {
			System.out.printf("Introduce el %dº numero -> ", i + 1); num = scanner.nextInt();

			if (num != 0) {
				if (num > 0) {
					positivos++;
				} else {
					negativos++;
				}
			} else {
				nulos++;
			}
			i++;
		}
		System.out.printf("Positivos -> %d\nNegativos -> %d\nNulos -> %d", positivos, negativos, nulos);
	}
}
