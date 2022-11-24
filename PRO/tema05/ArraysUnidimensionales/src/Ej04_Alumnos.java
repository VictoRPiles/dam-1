import java.util.Scanner;

public class Ej04_Alumnos {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		String[] nombres = new String[15];
		double[] notas   = new double[15];

		for (int i = 0; i < notas.length; i++) {
			System.out.print("Nombre del alumno " + (i + 1) + " -> ");
			nombres[i] = scanner.nextLine();
			notas[i]   = (Math.random() * 10);
		}

		estaAprovado(notas, nombres);
	}

	public static void estaAprovado(double[] notas, String[] nombres) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= 5) {
				System.out.printf("%s, Nota -> %.2f\tAPROVADO\n", nombres[i], notas[i]);
			}
			else {
				System.out.printf("%s, Nota -> %.2f\n", nombres[i], notas[i]);
			}
		}
	}
}
