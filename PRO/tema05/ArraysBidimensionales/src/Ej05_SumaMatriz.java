import java.util.Scanner;

/**
 * 5.- Diseñar un programa que muestre la suma de dos matrices bidimensionales
 * de 5 filas x 4 columnas, rellenadas con valores dados por el usuario. (La matriz
 * resultante contiene la suma de los elementos respectivos)
 */
public class Ej05_SumaMatriz {
	static Scanner scanner = new Scanner(System.in);

	/**
	 * Rellena la matriz con números introducidos por el usuario
	 *
	 * @param matriz
	 * @return
	 */
	public static int[][] setMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = scanner.nextInt();
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

	public static int[][] sumarMatriz(int[][] m1, int[][] m2, int[][] destino) {

		for (int i = 0; i < destino.length; i++) {
			for (int j = 0; j < destino[i].length; j++) {
				destino[i][j] += (m1[i][j] + m2[i][j]);
			}
		}

		return destino;
	}

	public static void main(String[] args) {
		int[][] matriz1 = new int[5][4], matriz2 = new int[5][4], suma = new int[5][4];

		setMatriz(matriz1);
		setMatriz(matriz2);

		sumarMatriz(matriz1, matriz2, suma);
		getMatriz(suma);
	}
}
