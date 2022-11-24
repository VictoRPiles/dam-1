import java.util.Scanner;

public class Ej05_Almacen {
	/**
	 * 5.- Un almacén de muebles nos ha pedido un programa para controlar la carga de los camiones
	 * que usa para distribuir sus productos. Sabiendo que todos los camiones son iguales, y que
	 * pueden cargar como máximo 27800 kg. o hasta un volumen ocupado de 26,75 m3 (puede
	 * que no se llegue al peso máximo, pero que el camión se encuentre lleno). El programa
	 * deberá leer repetidamente dos cantidades, que corresponden al peso y volumen de cada
	 * uno de los muebles que van a ser cargados en el camión, de manera que el programa irá
	 * acumulando las cantidades anteriores hasta que se iguale o sobrepase el valor del peso o
	 * volumen máximo. Momento en que mostrará como resultado el valor 1 o 2 según sea el
	 * caso:
	 * 1) La diferencia que hay entre el peso máximo y el cargado, si el programa ha terminado
	 * por esta condición.
	 * 2) La diferencia que hay entre el volumen máximo y el volumen cargado, si el programa
	 * ha terminado por esta condición.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double peso = 0, volumen = 0;
		final double PESO_MAXIMO = 27800.00, VOLUMEN_MAXIMO = 26.75;

		while (peso <= 27800 && volumen <= 26.75) {
			System.out.print("Introduce nuevo peso -> "); peso += scanner.nextDouble();
			System.out.print("Introduce nuevo volumen -> "); volumen += scanner.nextDouble();

			System.out.printf("Peso cargado -> %.02fKg | Peso maximo -> %.02fKg\n", peso, PESO_MAXIMO);
			System.out.printf("Volumen ocupado -> %.02fm3 | Peso maximo -> %.02fm3\n", volumen, VOLUMEN_MAXIMO);
		}
		System.out.println("===============");
		if (!(peso < PESO_MAXIMO)) {
			System.out.printf("Peso excedido en %.02fKg\n", peso - PESO_MAXIMO);
		}
		if (!(volumen < VOLUMEN_MAXIMO)) {
			System.out.printf("Volumen excedido en %.02fm3\n", volumen - VOLUMEN_MAXIMO);
		}
	}
}
