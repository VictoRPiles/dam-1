import java.util.Scanner;

public class SumaDosNumeros {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce el primer numero -> ");
		int num1 = scanner.nextInt();
		System.out.print("Introduce el segundo numero -> ");
		int num2 = scanner.nextInt();

		int suma = num1 + num2;

		System.out.println("La suma " + num1 + " + " + num2 + " = " + suma);
	}
}
