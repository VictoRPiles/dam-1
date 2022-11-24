import java.util.Arrays;

/**
 * 7.- Diseñar un programa que decida si una matriz de dimensión 4 x 4 de números
 * enteros es simétrica. Al doblarla por la diagonal izquierda coinciden los valores.
 */
public class Ej07_Simetrica {

	public static boolean esSimetrica(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (!(matriz[i][j] == matriz[j][i])) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matriz = {
				{1, 4, 4, 4},
				{4, 1, 4, 4},
				{4, 4, 1, 4},
				{4, 4, 4, 1}
		};

		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}

		if (esSimetrica(matriz)) {
			System.out.println("ES SIMÉTRICA");
		} else {
			System.out.println("NO ES SIMÉTRICA");
		}
	}
}
