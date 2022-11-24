import java.util.Scanner;

public class Ej19d {
	/**
	 * 19d.- Diseño de un algoritmo correspondiente a un programa que lee un
	 * número entero positivo y determina el número de dígitos decimales
	 * necesarios para la representación de dicho valor
	 *
	 * RESPUESTA
	 * Este programa tendría el mismo funcionamiento utilizando el bucle while
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero, numeroInicial;
		byte digitos = 0;

		System.out.print("Introduce el numero -> "); numero = scanner.nextInt();

		numeroInicial = numero;
		if (numero > 0) {
			do {
				numero /= 10;
				digitos++;
			} while (numero != 0);
			System.out.printf("El numero %d tiene %d digitos", numeroInicial, digitos);
		} else {
			System.out.println("ERROR: Introduce un numero positivo");
		}
	}
}
