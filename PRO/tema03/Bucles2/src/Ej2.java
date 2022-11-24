import java.util.Scanner;

public class Ej2 {
	/**
	 * 2.- Diseña un algoritmo que sume los números comprendidos entre el 1 y un número
	 * introducido por el usuario a través del teclado. Si el número introducido es <1 la
	 * suma será 0.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero = 0, i;

		i = scanner.nextInt();

		do {
			if (i < 0) {
				numero = 0;
			} else {
				numero += i;
			}
			i--;
		} while (i > 0);
		System.out.println(numero);
	}
}
