import java.util.Scanner;

public class Ej5 {
	/**
	 * 5.- Escribe un programa que solicite dos números reales y los escriba ordenados de
	 * menor a mayor
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1, num2;

		System.out.print("Introduce el primero numero -> "); num1 = scanner.nextDouble();
		System.out.print("Introduce el segundo numero -> "); num2 = scanner.nextDouble();

		System.out.println(num1 > num2 ? num1 + " > " + num2 : num2 + " > " + num1);
	}
}
