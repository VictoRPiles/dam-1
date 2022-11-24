import java.util.Scanner;

public class Ej18 {
	/**
	 * 18.- Diseñar un algoritmo que verifique que la entrada de un dato es correcta. Un
	 * dato es correcto si la edad introducida de una persona está entre 5 y 25 años
	 * ambos inclusive y no es una edad par.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		byte edad;

		System.out.print("Introduce la edad -> "); edad = scanner.nextByte();

		if ((edad >= 5 && edad <= 25) && (edad % 2) != 0) {
			System.out.println("Edad correcta");
		} else {
			System.out.print("Edad incorrecta");
		}
	}
}
