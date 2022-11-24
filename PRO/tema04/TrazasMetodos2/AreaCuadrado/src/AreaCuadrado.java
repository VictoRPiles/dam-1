import java.util.Scanner;

/**
 * Leer lado
 * a=areaCuadrado(lado);
 * Escribir a;
 * Pásalo a una clase de java con los
 * métodos necesarios
 */
public class AreaCuadrado {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a, lado;

		System.out.print("Introduce el lado -> ");
		lado = scanner.nextDouble();

		a = areaCuadrado(lado);

		System.out.printf("El area del cuadrado con lado %.2f es -> %.2f^2", lado, a);
	}

	public static double areaCuadrado(double lado) {
		double a;

		a = lado * lado;

		return a;
	}
}