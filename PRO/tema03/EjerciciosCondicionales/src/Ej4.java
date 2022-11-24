import java.util.Scanner;

public class Ej4 {
	/**
	 * 4.- Calculadora. Leer dos números y una operación (+ * /) y mostrar el resultado
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num1, num2, resultado = 0;
		char operacion;

		System.out.print("Introduce el primer numero -> "); num1 = scanner.nextDouble();
		System.out.print("Introduce el segundo numero -> "); num2 = scanner.nextDouble();
		System.out.print("Introduce la operacion ( + - * / )"); operacion = scanner.next().charAt(0);

		if (operacion == '+') {
			resultado = num1 + num2;
		} else if (operacion == '-') {
			resultado = num1 - num2;
		} else if (operacion == '*') {
			resultado = num1 * num2;
		} else if (operacion == '/') {
			resultado = num1 / num2;
		} else {
			System.out.println("ERROR: Operación -> " + operacion + " no válida");
			System.exit(0);
		}

		System.out.println(num1 + " " + operacion + " " + num2 + " = " + resultado);
	}
}
