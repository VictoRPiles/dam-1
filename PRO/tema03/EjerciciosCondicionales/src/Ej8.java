import java.util.Scanner;

public class Ej8 {
	/**
	 * 8.- Diseñar un algoritmo que dado el nº de pasos determine la cantidad total a pagar por
	 * una llamada telefónica, teniendo en cuenta los siguiente:
	 * a. Toda llamada que sea menor o igual de 5 pasos tiene un coste de 0,10 Є
	 * b. Cada paso adicional a partir de los 5 primeros cuesta 0,05 Є
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int pasos;
		double importe = 0.10;

		System.out.print("Introduce la cantidad de pasos -> "); pasos = scanner.nextInt();

		for (int i = 5; i < pasos; i++) {
			importe += 0.05;
		}

		System.out.println("Pasos -> " + pasos + "\nImporte -> " + importe);
	}
}
