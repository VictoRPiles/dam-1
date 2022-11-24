import java.util.Scanner;

public class Ej6 {
	/**
	 * 6.- Diseña un algoritmo que calcule y muestre el factorial de un número entero positivo
	 * dado por teclado
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num, numInicial, factorial = 1;

		System.out.print("Introduce el numero -> "); num = scanner.nextInt();
		numInicial = num;

		if (num < 0) {
			System.out.println("ERROR: El numero debe ser positivo");
		} else {
			while (num != 0) {
				factorial = factorial * num;
				num--;
			}
			System.out.printf("!%d -> %d", numInicial, factorial);
		}
	}
}
