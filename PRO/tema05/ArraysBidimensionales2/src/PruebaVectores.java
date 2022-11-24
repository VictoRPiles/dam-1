import java.util.Arrays;
import java.util.Scanner;

public class PruebaVectores {
	static Scanner scanner = new Scanner(System.in);

	private static int[][] llenarMatriz(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = scanner.nextInt();
			}
		}

		return matriz;
	}

	private static int[][] multiplicarMatriz(int[][] m1, int[][] m2, int[][] resultado) {

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado.length; j++) {
				for (int k = 0; k < resultado.length; k++) {
					resultado[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}

		return resultado;
	}

	private static void getMatriz(int[][] matriz) {

		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}
	}

	public static void main(String[] args) {

		int[][] cuadrada1 = new int[3][3], cuadrada2 = new int[3][3], resultado = new int[3][3];

		llenarMatriz(cuadrada1);

		llenarMatriz(cuadrada2);

		multiplicarMatriz(cuadrada1, cuadrada2, resultado);
		getMatriz(resultado);
	}
}
