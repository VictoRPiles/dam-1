import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa que presente un menú con las siguientes opciones:
 * <p>
 * 1. Capicua
 * <p>
 * 2. Números amigos
 * <p>
 * 3. Dibujar rectángulo de *
 * <p>
 * 4. Salir
 * <p>
 * Para ello crearás una clase con los siguientes métodos:
 * <p>
 * A) Un método que escriba el menú y devuelva la opción elegida. Si la opción no es válida, mostrará un mensaje
 * de error y continuará esperando que se teclee una opción válida.
 * <p>
 * B) Método que devuelva si un número que se le pasa como parámetro es o no capicúa (un número capicúa representa
 * la misma cantidad tanto si se lee de izquierda a derecha como si se lee de derecha a izquierda, ej.: 34543)
 * <p>
 * C) Método que reciba como parámetro un número 'n' y devuelva la suma de sus divisores (sin contar con n)
 * <p>
 * D) Método que reciba un número de filas y de columnas a dibujar y dibuje un rectángulo de asteriscos con tantas
 * filas y columnas como se le indique en sus parámetros.
 * Este método utilizará a su vez otro método definido como static escribeLinea(int n) que escribe tantos
 * asteriscos como se le indica en el parámetro y finaliza con un salto de línea.
 * <p>
 * Método principal (utilizando los métodos anteriores) mostrará el menú y dependiendo de la opción seleccionada:
 * <p>
 * 1. Pedirá un número y dirá si es o no capicúa
 * <p>
 * 2. Pedirá 2 números y dirá si son o no amigos. 2 números son amigos si la suma de los divisores de uno (sin
 * contarlo al mismo) es igual a la suma de los divisores del otro y viceversa.
 * <p>
 * 3. Pedirá el número de filas y de columnas y dibujará un rectángulo de asteriscos
 * Finalizará cuando la opción seleccionada sea 4-
 */
public class MenuOpciones {
	/**
	 * Muestra el menu principal del programa, evalúa la opción introducida por teclado, si es una opción válida
	 * devuelve el número de opción, si no lo es vuelve a pedir una opción por teclado
	 *
	 * @return opcion
	 */
	static byte menu() {
		Scanner scanner = new Scanner(System.in);
		byte opcion;
		boolean opcionValida;

		System.out.println("1) CAPICUA\n2) NÚMEROS AMIGOS\n3) DIBUJAR RECTÁNGULO DE *\n4) SALIR");

		do {
			opcion = scanner.nextByte();
			switch (opcion) {
				case 1, 2, 3, 4 -> {
					System.out.printf("OPCIÓN %d SELECCIONADA\n", opcion);
					opcionValida = true;
				}
				default -> {
					System.out.printf("OPCIÓN %d NO VÁLIDA\n", opcion);
					opcionValida = false;
				}
			}
		} while (!opcionValida);

		return opcion;
	}

	/**
	 * Descompone el número en digitos y los introduce en el ArrayList, primero lee de izquierda a derecha, luego
	 * de derecha a izquierda, finalmente compara si los ArrayList son iguales
	 *
	 * @param numero
	 */
	static void capicua(long numero) {
		boolean esCapicua;
		ArrayList<Integer> digitosIzquierdaDerecha = new ArrayList<>();
		ArrayList<Integer> digitosDerechaIzquierda = new ArrayList<>();

		for (int i = 0; i < String.valueOf(numero).length(); i++) {
			digitosIzquierdaDerecha.add((int) String.valueOf(numero).charAt(i));
		}
		for (int i = String.valueOf(numero).length(); i > 0; i--) {
			/*
			-1 porque String.valueOf(numero).length() devuelve la longitud del número, pero String cuenta los
			caracteres a partir de 0
			Ejemplo:
			numero = 1221
			String.valueOf(numero).length()  = 4, pero:
			String.valueOf(numero).charAt(0) = 1,
			String.valueOf(numero).charAt(1) = 2,
			String.valueOf(numero).charAt(2) = 2,
			String.valueOf(numero).charAt(3) = 1
			 */
			digitosDerechaIzquierda.add((int) String.valueOf(numero).charAt(i - 1));
		}

		esCapicua = digitosIzquierdaDerecha.equals(digitosDerechaIzquierda);
		if (esCapicua) {
			System.out.printf("%d -> SI es capicua\n", numero);
		} else {
			System.out.printf("%d -> NO es capicua\n", numero);
		}
	}

	/**
	 * Realiza el módulo de todos los numeros desde el 1 hasta n, si es módulo es 0 significa que el número es
	 * divisor, después los suma
	 *
	 * @param n
	 */
	static void numerosAmigos(int n) {
		int resultado = 0;

		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				System.out.printf("%d es divisor\n", i);
				resultado += i;
			}
		}

		System.out.printf("La suma de los divisores es -> %d\n", resultado);
	}

	/**
	 * Por cada línea, llama al método escribeLinea, pasando como argumento columnas
	 *
	 * @param filas
	 * @param columnas
	 */
	static void dibujarRectangulo(short filas, short columnas) {
		for (int i = 0; i < filas; i++) {
			escribeLinea(columnas);
		}
	}

	/**
	 * Escribe n asteriscos '*', al terminar salta de línea
	 *
	 * @param n
	 */
	static void escribeLinea(short n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		byte opcion;

		do {
			opcion = menu();

			if (opcion == 1) {
				System.out.print("Introduce un numero -> ");
				capicua(scanner.nextLong());
			} else if (opcion == 2) {
				System.out.print("Introduce un numero -> ");
				numerosAmigos(scanner.nextInt());
			} else if (opcion == 3) {
				System.out.print("Introduce nº filas y nº columnas -> ");
				dibujarRectangulo(scanner.nextShort(), scanner.nextShort());
			} else if (opcion == 4) {
				System.out.println("CERRANDO PROGRAMA");
			}

			if (opcion != 4) {
				System.out.println("Pulsa ENTER para continuar");
				scanner.nextLine(); // Este limpia el buffer
				scanner.nextLine(); // Este recoge el ENTER
			}
		} while (opcion != 4);
	}
}