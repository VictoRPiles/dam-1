import java.util.Scanner;

public class Ej4 {
	/**
	 * 4.- Diseña un algoritmo que al introducir una calificación entre 0 y 10
	 * (enteros) nos devuelva la calificación numérica según la siguiente tabla
	 * 0 <= nota < 3: MD
	 * 3 <= nota < 5: INS
	 * 5 <= nota < 7: BIEN
	 * 7 <= nota < 9: NOT
	 * 9 <= nota  <= 10: SOB
	 * Default: mensaje error
	 */
	public static void main(String[] args) {
		int nota;
		String notaLetras = null;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce la nota -> "); nota = scanner.nextInt();

		switch (nota) {
			case 0, 1, 2:
				notaLetras = "MD";
				break;
			case 3, 4:
				notaLetras = "INS";
				break;
			case 5, 6:
				notaLetras = "BIEN";
				break;
			case 7, 8:
				notaLetras = "NOT";
				break;
			case 9, 10:
				notaLetras = "SOB";
				break;
			default:
				System.out.println("ERROR: Nota -> " + nota + " no valida");
				System.exit(0);
				break;
		}
		System.out.println("Nota: " + nota + " = " + notaLetras);
	}
}
