/**
 * 4.- Hacer un programa que defina una matriz de 5 x 5, que inicialice mediante
 * bucles las diagonales a 1, y el resto de celdas a 0.
 */
public class Ej04_Diagonales {
	/**
	 * Devuelve toda la matriz
	 *
	 * @param matriz
	 */
	public static void getMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%2d ", matriz[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Rellena las diagonales con 1
	 *
	 * @param matriz
	 * @return
	 */
	public static int[][] llenarDiagonales(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i == j) {
					matriz[i][j] = 1;
				} else if (i == ((matriz.length - j) - 1)) {
					matriz[i][j] = 1;
				}
			}
		}

		return matriz;
	}

	public static void main(String[] args) {
		int[][] matriz = new int[5][5];

		llenarDiagonales(matriz);
		getMatriz(matriz);
	}
}
