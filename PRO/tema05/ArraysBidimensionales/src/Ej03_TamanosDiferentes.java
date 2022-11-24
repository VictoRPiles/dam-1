/**
 * 3.- Introduce una matriz de 7 x 5 y visualízala. A continuación:
 * <p>
 * • Crea una nueva matriz de 7 x 7 en donde las cinco primeras columnas
 * sean las de la matriz origen
 * <p>
 * • Guarda en la columna sexta la suma de las cinco anteriores
 * <p>
 * • Guarda en la columna séptima la media de las cinco primeras
 */

public class Ej03_TamanosDiferentes {
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
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%2d ", matriz[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Llena el array destino con el array origen, quedan 2 columnas vacías
	 * La sexta la llena con la suma de las 5 anteriores
	 * La séptima la llena con la media de las 5 anteriores
	 *
	 * @param origen
	 * @param destino
	 * @return
	 */
	public static int[][] llenarArrayDestino(int[][] origen, int[][] destino) {
		int suma = 0;

		for (int i = 0; i < origen.length; i++) {
			for (int j = 0; j < origen[i].length; j++) {
				destino[i][j] = origen[i][j];
			}
		}

		for (int i = 0; i < destino.length; i++) {
			for (int j = 0; j < destino[i].length; j++) {
				if (j < 5) {
					suma += destino[i][j];
				} else if (j == 5) {
					destino[i][j] = suma;
				} else {
					destino[i][j] = suma / 5;
				}
			}
			suma = 0;
		}

		return destino;
	}

	public static void main(String[] args) {
		int[][] sietePorCinco = new int[7][5];
		int[][] sietePorSiete = new int[7][7];

		System.out.println("MATRIZ 7 x 5");
		setMatriz(sietePorCinco);
		getMatriz(sietePorCinco);

		System.out.println("MATRIZ 7 x 7");
		llenarArrayDestino(sietePorCinco, sietePorSiete);
		getMatriz(sietePorSiete);
	}
}
