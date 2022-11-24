public class Ej01_Clase {
	public static void main(String[] args) {
		double[] notas = new double[15];

		for (int i = 0; i < notas.length; i++) {
			notas[i] = (Math.random() * 10);
		}

		System.out.printf("La media es -> %.2f\n", calculaMedia(notas));

		estaPorEncima(notas);
	}

	public static double calculaMedia(double[] notas) {
		double media = 0;

		for (int i = 0; i < notas.length; i++) {
			media += notas[i];
		}
		media /= 15;

		return media;
	}

	public static void estaPorEncima(double[] notas) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] > calculaMedia(notas)) {
				System.out.printf("Nota %02d -> %.2f\tPOR ENCIMA\n", i + 1, notas[i]);
			}
			else {
				System.out.printf("Nota %02d -> %.2f\n", i + 1, notas[i]);
			}
		}
	}
}
