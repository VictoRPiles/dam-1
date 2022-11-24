import java.util.Scanner;

public class EntradaDatosEj2 {

	public static void main(String[] args) {

		/**
		 * 2.- Escribe un programa que defina dos variables enteras para describir las longitudes de
		 * los lados de un rectángulo. El programa debe pedir el valor de cada lado y a continuación
		 * escribir en la pantalla las longitudes de los lados y calcular y escribir el perímetro y el área
		 * del rectángulo.
		 */

		Scanner scanner = new Scanner(System.in);
		int base, altura, perimetro, area;

		System.out.print("Escribe el valor de la base -> ");base = scanner.nextInt();
		System.out.print("Escribe el valor de la altura -> ");altura = scanner.nextInt();

		perimetro = 2 * (base + altura);
		area = (base * altura);

		System.out.println("Base -> " + base + "\nAltura -> " + altura);
		System.out.println("Perímetro -> " + perimetro);
		System.out.println("Área -> " + area);
	}
}
