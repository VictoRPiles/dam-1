import java.util.Scanner;

public class Ej6 {
	/**
	 * 6.- Escribe un programa que solicite tres números reales y los escriba ordenados de
	 * menor a mayor
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1, num2, num3;

		System.out.print("Introduce el primero numero -> "); num1 = scanner.nextDouble();
		System.out.print("Introduce el segundo numero -> "); num2 = scanner.nextDouble();
		System.out.print("Introduce el tercer numero -> "); num3 = scanner.nextDouble();

		if (num1 > num2 && num1 > num3) {
			if (num2 > num3) {
				System.out.println(num1 + " > " + num2 + " > " + num3);
			} else {
				System.out.println(num1 + " > " + num3 + " > " + num2);
			}
		} else if (num2 > num1 && num2 > num3) {
			if (num1 > num3) {
				System.out.println(num2 + " > " + num1 + " > " + num3);
			} else {
				System.out.println(num2 + " > " + num3 + " > " + num1);
			}
		} else {
			if (num1 > num2) {
				System.out.println(num3 + " > " + num1 + " > " + num2);
			} else {
				System.out.println(num3 + " > " + num2 + " > " + num1);
			}
		}
	}
}
