import java.util.Scanner;

/**
 * 9.- Inventarios para una red de almacenes. Tenemos un inventario de M piezas
 * distribuidas por N almacenes, expresado mediante una matriz de M x N, y un
 * vector de costes de M elementos con los precios de las piezas. Diseñar un
 * programa que halle:
 * <p>
 * a. El valor total general
 * <p>
 * b. El valor total de una pieza en todos los almacenes
 * <p>
 * c. Valor total de todas las piezas por almacén
 * <p>
 * d. Valor de cada pieza por almacén.
 */
public class Ej09_Almacenes {
	static Scanner scanner = new Scanner(System.in);

	/**
	 * Permite al usuario rellenar la matriz
	 *
	 * @param almacenes
	 * @return
	 */
	public static int[][] llenarAlmacenes(int[][] almacenes, double[] costes) {
		for (int i = 0; i < almacenes.length; i++) {
			System.out.printf("Pieza %d\n", i + 1);
			llenarCostes(costes, i);
			for (int j = 0; j < almacenes[i].length; j++) {
				System.out.printf("\tAlmacén %d -> ", j + 1);
				almacenes[i][j] = scanner.nextInt();
			}
		}

		return almacenes;
	}

	/**
	 * Permite al usuario introducir el precio de cada pieza
	 *
	 * @param costes
	 * @return
	 */
	public static double[] llenarCostes(double[] costes, int i) {
		System.out.print("Precio -> "); costes[i] = scanner.nextDouble();
		return costes;
	}

	/**
	 * Muestra el valor total de las piezas almacenadas
	 *
	 * @param almacenes
	 * @param costes
	 */
	public static void valorTotal(int[][] almacenes, double[] costes) {
		double total = 0;

		for (int i = 0; i < almacenes.length; i++) {
			for (int j = 0; j < almacenes[i].length; j++) {
				total += costes[i] * almacenes[i][j];
			}
		}
		System.out.printf("TOTAL -> %.2f€\n", total);
	}

	/**
	 * Muestra el valor total de una pieza en todos los almacenes
	 *
	 * @param almacenes
	 * @param costes
	 */
	public static void valorPieza(int[][] almacenes, double[] costes) {
		int pieza;
		double total = 0;

		System.out.print("¿Qué pieza? -> "); pieza = scanner.nextInt() - 1;

		for (int i = 0; i < almacenes.length; i++) {
			for (int j = 0; j < almacenes[i].length; j++) {
				if (i == pieza) {
					total += costes[i] * almacenes[i][j];
				}
			}
		}
		System.out.printf("TOTAL PIEZA %d -> %.2f€\n", pieza, total);
	}

	/**
	 * Valor de las piezas en cada almacén
	 *
	 * @param almacenes
	 * @param costes
	 */
	public static void valorAlmacen(int[][] almacenes, double[] costes) {
		double[] totales = new double[almacenes[0].length];

		for (int i = 0; i < almacenes.length; i++) {
			for (int j = 0; j < almacenes[i].length; j++) {
				totales[j] += costes[i] * almacenes[i][j];
			}
		}
		for (int i = 0; i < totales.length; i++) {
			System.out.printf("Almacén %d -> %.2f\n", i + 1, totales[i]);
		}
	}

	/**
	 * Valor de cada pieza en cada almacén
	 *
	 * @param almacenes
	 * @param costes
	 */
	public static void valorPiezaAlmacen(int[][] almacenes, double[] costes) {
		double[][] totales = new double[almacenes.length][almacenes[0].length];

		for (int i = 0; i < almacenes.length; i++) {
			for (int j = 0; j < almacenes[i].length; j++) {
				totales[i][j] += costes[i] * almacenes[i][j];
			}
		}
		for (int i = 0; i < totales.length; i++) {
			for (int j = 0; j < totales[i].length; j++) {
				System.out.printf("TOTAL PIEZA %d ALMACÉN %d -> %.2f€\n", i + 1, j + 1, totales[i][j]);

			}
		}
	}

	/**
	 * Muestra la información almacenada en la matriz
	 *
	 * @param almacenes
	 */
	public static void getAlmacenes(int[][] almacenes) {
		for (int i = 0; i < almacenes.length; i++) {
			System.out.printf("Almacén %2d -> ", i + 1);
			for (int j = 0; j < almacenes[i].length; j++) {
				System.out.printf("%3d ", almacenes[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Muestra la información almacenada en la matriz
	 *
	 * @param costes
	 */
	public static void getCostes(double[] costes) {
		for (int i = 0; i < costes.length; i++) {
			System.out.printf("Pieza %2d -> %2.2f€\n", i + 1, costes[i]);
		}
	}

	public static void main(String[] args) {
		byte m, n;
		int[][] almacenes;
		double[] costes;

		System.out.print("Piezas -> "); m = scanner.nextByte();
		System.out.print("Almacenes -> "); n = scanner.nextByte();
		almacenes = new int[m][n];
		costes = new double[m];

		llenarAlmacenes(almacenes, costes);
		getAlmacenes(almacenes);
		getCostes(costes);
		valorTotal(almacenes, costes);
		valorPieza(almacenes, costes);
		valorAlmacen(almacenes, costes);
		valorPiezaAlmacen(almacenes, costes);
	}
}
