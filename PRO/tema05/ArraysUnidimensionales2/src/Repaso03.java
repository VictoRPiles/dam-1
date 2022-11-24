import java.util.Scanner;

public class Repaso03 {
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

	private static void leerArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("ARRAY[%d] -> ", i);
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int[] p = new int[10];
		int[] v = new int[10];

		escribirArray(p, 0, 20);
		System.out.println("ARRAY P");
		leerArray(p);

		for (int i = 0; i < p.length; i++) {
			if (p[i] > 10) {
				v[i] = p[i];
			}
		}

		System.out.println("\n\nARRAY V");
		for (int i = 0; i < v.length; i++) {
			if (v[i] != 0) {
				System.out.printf("ARRAY[%d] -> %d\n", i, v[i]);
			}
		}
	}
}
