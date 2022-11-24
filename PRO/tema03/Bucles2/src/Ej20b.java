import java.util.Scanner;

public class Ej20b {
	/**
	 * 20b.- Diseña un algoritmo que lee cinco valores numéricos y calcula su producto
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero;
		long producto = 1L;

		for (int i = 0; i < 5; i++) {
			System.out.printf("Introduce el %dº numero -> ", i + 1); numero = scanner.nextInt();
			producto *= numero;
		}
		System.out.printf("El resultado de la multiplicación es %d", producto);
	}
}