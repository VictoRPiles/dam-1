import java.util.Scanner;

public class Ej20c {
	/**
	 * 20c.- Diseña un algoritmo que calcule y muestre la suma de una serie de números
	 * introducidos por teclado, siendo introducido por teclado el número de valores
	 * que hay que leer.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int suma = 0, numero;
		byte cantidad;

		System.out.print("Cantidad de numeros -> "); cantidad = scanner.nextByte();

		if (cantidad > 0) {
			for (int i = 0; i < cantidad; i++) {
				System.out.printf("Introduce el %dº numero -> ", i + 1); numero = scanner.nextInt();
				suma += numero;
			}
		} else {
			System.out.println("ERROR: Cantidad de numeros invalida");
		}
		System.out.printf("La suma total es %d", suma);
	}
}
