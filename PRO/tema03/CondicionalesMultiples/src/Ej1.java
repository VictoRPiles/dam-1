import java.util.Scanner;

public class Ej1 {
	/**
	 * 1.- Realiza el problema 4 de la actividad de condicionales (calculadora)
	 * utilizando la estructura condicional múltiple
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1, num2, resultado = 0;
		char operacion;

		System.out.print("Introduce el primer numero -> "); num1 = scanner.nextDouble();
		System.out.print("Introduce el segundo numero -> "); num2 = scanner.nextDouble();
		System.out.print("Introduce la operacion ( + - * / )"); operacion = scanner.next().charAt(0);

		switch (operacion) {
			case '+':
				resultado = num1 + num2;
				break;
			case '-':
				resultado = num1 - num2;
				break;
			case '*':
				resultado = num1 * num2;
				break;
			case '/':
				resultado = num1 / num2;
				break;
			default:
				System.out.println("ERROR: Operación -> " + operacion + " no válida");
				System.exit(0);
				break;
		}

		System.out.println(num1 + " " + operacion + " " + num2 + " = " + resultado);
	}
}
