/**
 * @author Victor Piles
 * @since 07/02/2022 14:25
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class E01_Division {

	private static void dividir() throws Exception {
		Scanner scanner = new Scanner(System.in);
		int num1, num2;

		try {
			System.out.print("Primer numero -> ");
			num1 = scanner.nextInt();
			System.out.print("Segundo numero -> ");
			num2 = scanner.nextInt();

			if (num2 == 0) throw new ArithmeticException();

			System.out.printf("%d : %d = %.2f\n", num1, num2, (double) num1 / (double) num2);
		} catch (InputMismatchException e) {
			System.out.println("ERROR: No has introducido dos enteros ");
			throw new Exception();
		} catch (ArithmeticException e) {
			System.out.println("ERROR: No se puede dividir entre 0");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido realizar la division ");
			throw new Exception();
		}
	}

	public static void main(String[] args) {

		while (true) {
			try {
				dividir();
				break;
			} catch (Exception e) {
				System.out.println("Vuelve a introducir los valores");
			}
		}
	}
}
