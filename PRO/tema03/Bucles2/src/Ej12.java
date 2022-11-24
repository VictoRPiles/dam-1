import java.util.Scanner;

public class Ej12 {
	/**
	 * 12.- Diseñar un algoritmo que realice la división de dos números enteros
	 * positivos introducidos a través del teclado mediante restas sucesivas, mostrando
	 * el cociente y el resto.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dividendo, divisor, cociente = 0, resto = 0;

		System.out.print("Introduce el dividendo -> "); dividendo = scanner.nextInt();
		System.out.print("Introduce el divisor -> "); divisor = scanner.nextInt();

		if (dividendo >= 0 && divisor > 0) {
			System.out.printf("%d / %d = ", dividendo, divisor);
			while (dividendo >= divisor) {
				dividendo -= divisor;
				cociente++;
			}
			if (dividendo != 0) {
				resto = dividendo;
			}
			System.out.printf("%d r=%d", cociente, resto);
		} else if (divisor == 0) {
			System.out.println("ERROR: No se puede dividir entre 0");
		} else {
			System.out.println("ERROR: Introduce valores válidos");
		}
	}
}
