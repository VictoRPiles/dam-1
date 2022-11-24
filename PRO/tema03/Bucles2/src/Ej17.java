import java.util.Scanner;

public class Ej17 {
	/**
	 * 17.- Escribir un algoritmo que escribe la suma de una secuencia de números enteros
	 * leídos del teclado finalizando la entrada de datos al evaluar la respuesta dada a
	 * un mensaje que diga “continuar S/N”, mostrado después de realizar las
	 * operaciones del bucle
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int suma = 0, numero = 0;
		char respuesta;

		do {
			System.out.print("Introduce un numero -> "); numero = scanner.nextInt();

			suma += numero;
			System.out.printf("Suma total -> %d\n", suma);

			System.out.print("Continuar S/N -> "); respuesta = Character.toUpperCase(scanner.next().charAt(0));
		} while (respuesta != 'N');
	}
}
