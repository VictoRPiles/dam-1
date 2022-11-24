import java.util.Scanner;

/**
 * 6.- Sobre una matriz de 3 filas por 6 columnas con valores introducidos por el
 * usuario, mostrar la matriz con los datos introducidos así como:
 * <p>
 * a. El menor número de la matriz y su posición
 * <p>
 * b. El mayor número de la matriz y su posición
 * <p>
 * c. El menor nº de cada fila y su posición
 * <p>
 * d. El menor nº de cada columna y su posición
 * <p>
 * e. La media de todos los números
 * <p>
 * f. La suma de todos ellos
 */
public class Ej06_MenorMayor {
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

	/**
	 * Devuelve el valor más pequeño de la matriz
	 *
	 * @param matriz
	 */
	public static void menorValor(int[][] matriz) {
		int menor, fila = 0, columna = 0;

		menor = matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (!(menor < matriz[i][j])) {
					menor = matriz[i][j];
					fila = i;
					columna = j;
				}
			}
		}

		System.out.printf("El menor es %d con indice %d.%d\n", menor, fila, columna);
	}

	/**
	 * Devuelve el valor más grande de la matriz
	 *
	 * @param matriz
	 */
	public static void mayorValor(int[][] matriz) {
		int mayor, fila = 0, columna = 0;

		mayor = matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (!(mayor > matriz[i][j])) {
					mayor = matriz[i][j];
					fila = i;
					columna = j;
				}
			}
		}

		System.out.printf("El mayor es %d con indice %d.%d\n", mayor, fila, columna);
	}

	/**
	 * Devuelve el valor más pequeño de cada fila
	 *
	 * @param matriz
	 */
	public static void menorValorFila(int[][] matriz) {
		int menor;

		for (int i = 0; i < matriz.length; i++) {
			menor = matriz[i][0];
			for (int j = 0; j < matriz[i].length; j++) {
				if (!(menor < matriz[i][j])) {
					menor = matriz[i][j];
				}
			}
			System.out.printf("Menor fila %d -> %d\n", i, menor);
		}
	}

	/**
	 * Devuelve el valor más pequeño de cada columna
	 *
	 * @param matriz
	 */
	public static void menorValorColumna(int[][] matriz) {
		int[] resultados = matriz[0];

		for (int i = 1; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (!(resultados[j] < matriz[i][j])) {
					resultados[j] = matriz[i][j];
				}
			}
		}
		for (int i = 0; i < resultados.length; i++) {
			System.out.printf("Menor columna %d -> %d\n", i, resultados[i]);
		}
	}

	/**
	 * Devuelve la media de todos los valores de la matriz
	 *
	 * @param matriz
	 */
	public static void mediaMatriz(int[][] matriz) {
		double media = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				media += matriz[i][j];
			}
		}

		media /= (matriz.length * matriz[0].length);

		System.out.printf("Media -> %.2f\n", media);
	}

	/**
	 * Devuelve la suma de todos los valores de la matriz
	 *
	 * @param matriz
	 */
	public static void sumaMatriz(int[][] matriz) {
		int suma = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				suma += matriz[i][j];
			}
		}
		System.out.printf("Suma -> %d\n", suma);
	}

	public static void main(String[] args) {
		int[][] matriz = new int[3][6];
		setMatriz(matriz);

		menorValor(matriz);
		mayorValor(matriz);
		menorValorFila(matriz);
		menorValorColumna(matriz);
		mediaMatriz(matriz);
		sumaMatriz(matriz);
		getMatriz(matriz);
	}
}