import java.util.Scanner;

public class Repaso02 {
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
		int[] array = new int[10];
		int mayorQueDiez = 0;

		escribirArray(array, 0, 20);

		for (int i = 0; i < array.length; i++) {
			if (array[i] > 10) {
				System.out.printf("Array[%d] = %d\n", i, array[i]);
				mayorQueDiez++;
			}
		}

		System.out.printf("Hay %d números mayores que 10", mayorQueDiez);
	}
}
