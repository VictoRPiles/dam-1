import java.util.Scanner;

public class Ej13 {
	/**
	 * 13.- Diseñar un algoritmo que verifique que la entrada de un dato es correcta. Un
	 * dato es correcto si está entre 1 y 5 (ambos inclusive).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		short dato;

		System.out.print("Introduce un numero entre 1 y 5 -> "); dato = scanner.nextShort();

		if (dato >= 1 && dato <= 5) {
			System.out.println("Dato correcto");
		} else {
			System.out.println("Dato incorrecto");
		}
	}
}
