import java.util.Scanner;

public class Repaso01 {
	private static final Scanner scanner = new Scanner(System.in);

	private static int[] escribirArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("ARRAY[%d] -> ", i);
			array[i] = scanner.nextInt();
		}

		return array;
	}

	private static int[] escribirArray(int[] array, int desde, int hasta) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() * hasta) + desde);
		}

		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[50];
		boolean esCero = false;
		int index = 0;

		escribirArray(array, 0, 10);

		for (int i = 0; i < array.length; i++) {
			System.out.printf("Posicion %2d = %d\n", i, array[i]);

			if ((array[i] == 0) && !esCero) {
				esCero = true;
				index = i;
			}
		}

		if (esCero) {
			System.out.printf("En la posicion %d esta el primer cero", index);
		} else {
			System.out.println("No hay ceros");
		}
	}
}
