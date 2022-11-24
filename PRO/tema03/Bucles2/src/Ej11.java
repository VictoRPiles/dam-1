import java.util.Scanner;

public class Ej11 {
	/**
	 * 11.- Diseñar un algoritmo que realice y muestre el producto de dos números
	 * enteros positivos introducidos por teclado utilizando sumas sucesivas.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num, numInicial, multiplicar, i = 1;

		System.out.print("Introduce el numero -> "); num = scanner.nextInt();
		System.out.print("Multiplicado por -> "); multiplicar = scanner.nextInt();

		numInicial = num;
		if (num >= 0 && multiplicar > 0) {
			System.out.printf("%d x %d = ", num, multiplicar);
			while (i < multiplicar) {
				i++;
				num += numInicial;
			}
			System.out.printf("%d", num);
		} else if (multiplicar == 0) {
			System.out.printf("%d x %d = 0", num, multiplicar);
		} else {
			System.out.println("ERROR: Introduce un numero positivo");
		}
	}
}
