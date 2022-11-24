import java.util.Scanner;

public class Ej2 {
	/**
	 * 2.- Leer tres números e indicar cuál es el mayor y cuál el menor
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1, num2, num3;

		System.out.print("Introduce el numero 1 -> "); num1 = scanner.nextInt();
		System.out.print("Introduce el numero 2 -> "); num2 = scanner.nextInt();
		System.out.print("Introduce el numero 3 -> "); num3 = scanner.nextInt();

		if (num1 > num2 && num1 > num3) {
			System.out.println(num1 + " es el numero mas grande");
		} else if (num2 > num1 && num2 > num3) {
			System.out.println(num2 + " es el numero mas grande");
		} else {
			System.out.println(num3 + " es el numero mas grande");
		}
		if (num1 < num2 && num1 < num3) {
			System.out.println(num1 + " es el numero mas pequeño");
		} else if (num2 < num1 && num2 < num3) {
			System.out.println(num2 + " es el numero mas pequeño");
		} else {
			System.out.println(num3 + " es el numero mas pequeño");
		}
	}
}
