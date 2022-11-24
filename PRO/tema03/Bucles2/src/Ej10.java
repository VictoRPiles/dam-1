import java.util.Scanner;

public class Ej10 {
	/**
	 * 10.- Diseñar un algoritmo que calcule y muestre la suma de números introducidos por
	 * teclado hasta que dicha suma sea mayor que 1000
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int suma = 0;

		do {
			if (suma != 0) {
				System.out.printf("Suma total -> %d\n", suma);
			}
			System.out.print("Introduce un numero -> ");
			suma += scanner.nextInt();
		} while (suma < 1000);
		System.out.println("La suma excede de 1000");
	}
}
