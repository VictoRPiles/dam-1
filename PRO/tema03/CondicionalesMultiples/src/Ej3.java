import java.util.Scanner;

public class Ej3 {
	/**
	 * 3.- Programa que lea un número del 0 al 9 y lo devuelva escrito en letras
	 */
	public static void main(String[] args) {
		int numero;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce un numero del 0 al 9 -> "); numero = scanner.nextInt();

		switch (numero) {
			case 0:
				System.out.println("Número cero");
				break;
			case 1:
				System.out.println("Número uno");
				break;
			case 2:
				System.out.println("Número dos");
				break;
			case 3:
				System.out.println("Número tres");
				break;
			case 4:
				System.out.println("Número cuatro");
				break;
			case 5:
				System.out.println("Número cinco");
				break;
			case 6:
				System.out.println("Número seis");
				break;
			case 7:
				System.out.println("Número siete");
				break;
			case 8:
				System.out.println("Número ocho");
				break;
			case 9:
				System.out.println("Número nueve");
				break;
			default:
				System.out.println("ERROR: El número " + numero + " no está entre el 0 y el 9");
				break;
		}
	}
}
