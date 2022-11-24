import java.util.Scanner;

public class Ej9 {
	/**
	 * 9.- Diseña un algoritmo que calcule la potencia de un número por productos sucesivos
	 * dada la base y el exponente.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int base, exponente, i = 1;
		long resultado;

		System.out.print("Introduce la base -> "); base = scanner.nextInt();
		System.out.print("Introduce el exponente -> "); exponente = scanner.nextInt();

		resultado = base;
		while (i < exponente) {
			resultado = (resultado * base);
			i++;
		}
		System.out.printf("%d^%d = %d", base, exponente, resultado);
	}
}
