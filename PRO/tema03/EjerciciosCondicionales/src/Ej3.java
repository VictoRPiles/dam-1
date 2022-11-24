import java.util.Scanner;

public class Ej3 {
	/**
	 * 3.- Escribe un programa que solicite la edad de una persona y muestre un mensaje por
	 * pantalla indicando si es mayor de edad o no
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int edad;

		System.out.print("Introduce la edad -> "); edad = scanner.nextInt();

		if (edad >= 18){
			System.out.println("Mayor de edad");
		}
		else {
			System.out.println("Menor de edad");
		}
	}
}
