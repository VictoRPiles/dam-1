import java.util.Scanner;

public class Ej3 {
	/**
	 * 3.- Diseña un algoritmo que muestre los números comprendidos entre dos números
	 * introducidos desde el teclado en orden ascendente
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1, num2, resultado;

		System.out.print("Primer numero -> "); num1 = scanner.nextInt();
		System.out.print("Segundo numero -> "); num2 = scanner.nextInt();

		if (num2 < num1) {
			System.out.printf("ERROR: El número 2 (%d) debe ser mayor que el número 1 (%d)", num2, num1);
			System.exit(0);
		}

		System.out.printf("Entre el %d y el %d, existen los números -> ", num1, num2);

		resultado = num1;
		while (resultado < num2 - 1) {
			resultado++;
			System.out.printf("%d, ", resultado);
		}
	}
}
