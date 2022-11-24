/**
 * 2.- Hacer un programa que defina una matriz llamada TB de 10 x 10, inicialice
 * mediante un bucle las filas pares a 1 y las impares a 0 y muestre el contenido
 * de la matriz.
 */
public class Ej02_ParesImpares {
	/**
	 * Llena la matriz con 0 si la fila és par o 1 si és impar
	 *
	 * @param matriz
	 * @return
	 */
	public static int[][] setMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i % 2 == 0) {
					matriz[i][j] = 0;
				} else {
					matriz[i][j] = 1;
				}
			}
		}
		return matriz;
	}

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

	public static void main(String[] args) {
		int[][] tb = new int[10][10];

		setMatriz(tb); // NOTA: INTERPRETO QUE LA PRIMERA FILA DE LA MATRIZ DE CONSIDERA "FILA 0", Y POR TANTO ES PAR
		getMatriz(tb);
	}
}
