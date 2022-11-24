import java.io.IOException;
import java.util.Scanner;

public class Ej01_Menu {
	/**
	 * 1.- Programa que muestre el siguiente menu
	 * <p>
	 * 1.- Opción 1
	 * 2.- Opción 2
	 * 3.- Opción 3
	 * 4.- Finalizar
	 * <p>
	 * El programa mostrará la opción seleccionada (utilizar un switch) y esperará a que se pulse una tecla para
	 * continuar.
	 * Cuando se pulse la tecla volverá a mostrar el menú.
	 * El programa finalizará cuando se seleccione la opción 4.
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		byte opcion;

		do {
			System.out.print("1) Opción 1\n2) Opción 2\n3) Opción 3\n4) Finalizar\n");

			System.out.print("Introduce la opción -> "); opcion = scanner.nextByte();

			switch (opcion) {
				case 1 -> System.out.println("Opcion 1");
				case 2 -> System.out.println("Opcion 2");
				case 3 -> System.out.println("Opcion 3");
				case 4 -> System.out.println("Vas a salir del programa");
				default -> System.out.println("ERROR: Opción incorrecta");
			}

			System.out.print("Pulsa ENTER para continuar...");
			System.in.read(); // System.in.read() obliga a crear la excepción IOException
		} while (opcion != 4);
	}
}
