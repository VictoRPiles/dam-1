import java.util.Scanner;

public class ArraysUnidimensionales2 {
	private static final Scanner scanner = new Scanner(System.in);

	private static void ejercicio01() {
		int[] vector = new int[10];
		byte n;
		int suma = 0;

		System.out.println("===== EJERCICIO 01 =====");

		escribirArray(vector);

		System.out.print("VALOR PARA N -> "); n = scanner.nextByte();

		for (int i = 0; i < n; i++) {
			suma += vector[i];
		}

		System.out.printf("SUMA TOTAL -> %d\n", suma);
		leerArray(vector);
	}

	private static void ejercicio02() {
		int[] origen = {10, 25, 26, 40, 37, 45, 90, 76, 78, 81, 58, 32};
		int[] destino = new int[12];

		System.out.println("===== EJERCICIO 02 =====");

		for (int i = 0; i < origen.length; i++) {
			if (origen[i] % 2 == 0) {
				System.out.printf("ARRAY[%d] ES PAR\n", i);

				if (origen[i] > 25) {
					destino[i] = origen[i];
				}
			}
		}
		System.out.println("ARRAY ORIGEN");
		leerArray(origen);
		System.out.println("ARRAY DESTINO");
		leerArray(destino);
	}

	private static void ejercicio03() {
		int[] array = new int[10];

		System.out.println("===== EJERCICIO 03 =====");

		escribirArray(array);

		System.out.println("INVIRTIENDO...");
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.printf("ARRAY[%d] -> ", i);
			System.out.println(array[i]);
		}
	}

	private static void ejercicio04() {
		int[] arrayAleatorio = new int[10];
		int index = 0, numMasGrande;

		System.out.println("===== EJERCICIO 04 =====");

		escribirArray(arrayAleatorio, 1, 100);
		numMasGrande = arrayAleatorio[0]; // ALMACENAMOS EL PRIMER VALOR DEL ARRAY PARA COMPARAR

		for (int i = 0; i < arrayAleatorio.length; i++) {
			if (arrayAleatorio[i] > numMasGrande) {
				index = i;
				numMasGrande = arrayAleatorio[i];
			}
		}

		leerArray(arrayAleatorio);
		System.out.printf("El numero más grande es %d almacenado en la posicion %d\n", numMasGrande, index);
	}

	private static void ejercicio05() {
		int[] arrayCapicua = {1, 2, 3, 2, 1};
		boolean esCapicua = true;

		System.out.println("===== EJERCICIO 05 =====");

		for (int i = 0; i < (arrayCapicua.length / 2); i++) {
			if ((arrayCapicua[i] == arrayCapicua[(arrayCapicua.length - i) - 1]) && esCapicua) {
				esCapicua = true;
			} else {
				esCapicua = false;
			}
		}

		for (int i = 0; i < arrayCapicua.length; i++) {
			System.out.print(arrayCapicua[i]);
		}
		System.out.printf(" es capicua? -> %b", esCapicua);
	}

	private static void ejercicio06() {
		int[] dorsales = new int[100];
		int[] equipos = new int[10];
		byte acabadoEn;

		System.out.println("===== EJERCICIO 06 =====");

		escribirArray(dorsales, 100, 200); // RELLENA LOS DORSALES CON MARCAS ALEATORIAS

		for (int i = 0; i < dorsales.length; i++) {
			acabadoEn = (byte) (i % 10);

			equipos[acabadoEn] += dorsales[i];
		}

		leerArray(equipos);
	}

	private static void leerArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("ARRAY[%d] -> ", i);
			System.out.println(array[i]);
		}
	}

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
		ejercicio01();
		ejercicio02();
		ejercicio03();
		ejercicio04();
		ejercicio05();
		ejercicio06();
	}
}