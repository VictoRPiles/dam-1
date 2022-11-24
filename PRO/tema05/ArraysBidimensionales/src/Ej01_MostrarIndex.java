/**
 * 1.- Introduce una matriz de 5 filas y 7 columnas y a continuación visualiza:
 * <p>
 * • Toda la matriz (Crea un método que visualice la matriz, ya que lo gastarás más veces)
 * <p>
 * • La fila cinco completa
 * <p>
 * • El elemento de la cuarta fila tercera columna y el elemento de la quinta fila tercera columna. Intercambiarlos
 * el contenido de estos dos elementos y visualiza la matriz de nuevo
 * <p>
 * • La primera columna y la cuarta. Intercambiar el contenido de estas columnas y visualiza la matriz de nuevo
 */

public class Ej01_MostrarIndex {
	/**
	 * Llena la matriz de números aleatorios entre el 1 y el 10
	 *
	 * @param matriz
	 * @return
	 */
	public static int[][] setMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) ((Math.random() * 10) + 1);
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
		System.out.println("TODA LA MATRIZ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%2d ", matriz[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Devuelve la fila indicada en el parámetro fila
	 *
	 * @param fila
	 * @param matriz
	 */
	public static void getFila(int fila, int[][] matriz) {
		System.out.printf("FILA %d\n", fila);
		for (int i = 0; i < matriz[fila - 1].length; i++) {
			System.out.printf("%2d ", matriz[fila - 1][i]);
		}
		System.out.println();
	}

	/**
	 * Devuelve un índice concreto de la matriz
	 *
	 * @param fila
	 * @param columna
	 * @param matriz
	 */
	public static int getIndice(int fila, int columna, int[][] matriz) {
		System.out.printf("ELEMENTO %d.%d\n", fila, columna);
		return matriz[fila - 1][columna - 1];
	}

	/**
	 * Intercambia el valor de dos índices
	 *
	 * @param fila1
	 * @param col1
	 * @param fila2
	 * @param col2
	 * @param matriz
	 * @return
	 */
	public static int[][] intercambioIndices(int fila1, int col1, int fila2, int col2, int[][] matriz) {
		int aux;
		fila1--; col1--; fila2--; col2--;
		aux = matriz[fila1][col1];

		matriz[fila1][col1] = matriz[fila2][col2];
		matriz[fila2][col2] = aux;

		return matriz;
	}

	/**
	 * Intercambia los valores de dos filas
	 *
	 * @param fila1
	 * @param fila2
	 * @param matriz
	 * @return
	 */
	public static int[][] intercambioFilas(int fila1, int fila2, int[][] matriz) {
		int[] aux;
		fila1--; fila2--;
		aux = matriz[fila1];

		matriz[fila1] = matriz[fila2];
		matriz[fila2] = aux;

		return matriz;
	}

	public static void main(String[] args) {
		int[][] matriz = new int[5][7];
		setMatriz(matriz);

		getMatriz(matriz);

		getFila(5, matriz);

		System.out.println(getIndice(4, 3, matriz));
		System.out.println(getIndice(5, 3, matriz));

		intercambioIndices(4, 3, 5, 3, matriz);
		getMatriz(matriz);

		getFila(1, matriz);
		getFila(4, matriz);
		intercambioFilas(1, 4, matriz);
		getMatriz(matriz);
	}
}
