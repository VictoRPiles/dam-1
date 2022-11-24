import java.util.Scanner;

public class Ej7 {
	/**
	 * 7.- Diseñar un algoritmo correspondiente a un programa que lee un número entero positivo y determina el número
	 * de dígitos decimales necesarios para la representación de dicho valor
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long num;
		int digitos = 0;

		System.out.print("Introduce el numero -> "); num = scanner.nextLong();

		if (num < 0) {
			System.out.println("ERROR: El numero debe ser positivo");
		} else {
			// Calculamos la cantidad de veces que se puede dividir entre 10, sin llegar a ser 0
			while (num != 0) {
				num /= 10;
				digitos++;
			}
			System.out.println(digitos);
		}
	}
}
