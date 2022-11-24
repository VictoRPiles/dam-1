import java.util.Random;

public class Temperaturas {
	private static double[][] llenarArray(double[][] dias) {

		Random random = new Random();
		double valMax = 40, valMin = -20;

		for (int i = 0; i < dias.length; i++) {
			for (int j = 0; j < dias[i].length; j++) {
				dias[i][j] = random.nextDouble(valMax + Math.abs(valMin)) + valMin;
			}
		}

		return dias;
	}

	public static void minimaAnual(double[][] dias) {

		double minima = Double.MAX_VALUE;

		for (int f = 0; f < dias.length; f++) {
			for (int c = 0; c < dias[f].length; c++) {
				if (dias[f][c] < minima) {
					minima = dias[f][c];
				}
			}
		}
		System.out.println(String.format("Minima anual -> %05.2f", minima));
	}

	public static void mediaMensual(double[][] dias) {

		double medias[] = new double[dias.length];

		for (int f = 0; f < dias.length; f++) {
			for (int c = 0; c < dias[f].length; c++) {
				medias[f] += dias[f][c];
			}
		}

		for (int i = 0; i < medias.length; i++) {
			medias[i] /= dias[i].length;
			System.out.println(String.format("Media mes %2d -> %05.2f", i + 1, medias[i]));
		}
	}

	public static void mediaVeinteDias(double[][] dias) {

		double medias[] = new double[20];

		for (int f = 0; f < dias.length; f++) {
			for (int c = 0; c < 20; c++) {
				medias[c] += dias[f][c];
			}
		}

		for (int i = 0; i < medias.length; i++) {
			medias[i] /= 12;
			System.out.println(String.format("Media dia %2d -> %05.2f", i + 1, medias[i]));
		}
	}

	public static void main(String[] args) {

		double[][] dias = new double[12][];
		for (int i = 0; i < dias.length; i++) {
			switch (i + 1) {
				case 1, 3, 5, 7, 8, 10, 12:
					dias[i] = new double[31];
					break;
				case 4, 6, 9, 11:
					dias[i] = new double[30];
					break;
				case 2:
					dias[i] = new double[28];
					break;
			}
		}

		llenarArray(dias);

		minimaAnual(dias);
		mediaMensual(dias);
		mediaVeinteDias(dias);
	}
}
