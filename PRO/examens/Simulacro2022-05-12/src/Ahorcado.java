import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Victor
 * @since 12/05/2022 - 11:57
 */
public abstract class Ahorcado {
	private static final int FALLOS_PERMITIDOS = 10;
	private static String palabraElegida = null;
	private static boolean[] letrasAcertadas;
	private static int fallos = 0;
	private static boolean terminar = false;
	private static TreeSet<Character> letrasIntroducidas = new TreeSet<>();

	public static void jugar() {
		Scanner scanner = new Scanner(System.in);

		if (!elegirPalabra()) {
			System.out.println("No hay palabras en el diccionario.");
		}
		if (palabraElegida == null) {
			System.out.println("No se ha elegido una palabra.");
		}

		do {
			printTablero();

			checkLetra(scanner.nextLine().charAt(0));

			if (checkGanador()) {
				System.out.println("Felicidades has acertado la palabra.");
				terminar = true;
			} else if (!checkFallos()) {
				System.out.println("Has alcanzado el máximo de fallos.");
				terminar = true;
			}
		} while (!terminar);
		System.out.printf("La palabra correcta era %s\n", palabraElegida);
		reset();
	}

	private static boolean elegirPalabra() {
		int cantidadPalabras = GestionPalabras.getPalabras().size();
		int indexRandom;

		if (cantidadPalabras <= 0) return false;

		indexRandom = (int) (Math.random() * cantidadPalabras);

		palabraElegida = GestionPalabras.getPalabraConIndex(indexRandom);

		if (palabraElegida == null) return false;

		/* Inicialización del array de letras, se llena con false */
		letrasAcertadas = new boolean[palabraElegida.length()];
		Arrays.fill(letrasAcertadas, false);

		return true;
	}

	private static void printTablero() {
		System.out.println();
		System.out.println("Fallos -> " + fallos);
		System.out.println();
		for (int i = 0; i < palabraElegida.length(); i++) {
			if (!letrasAcertadas[i]) {
				System.out.print("_ ");
			} else {
				System.out.print(palabraElegida.charAt(i) + " ");
			}
		}
		System.out.println();
		System.out.print("Introduce una letra -> ");
	}

	private static void checkLetra(char letra) {
		boolean acierto = false;

		System.out.println();

		letra = Character.toUpperCase(letra);
		if (!letrasIntroducidas.add(letra)) {
			System.out.println("No introduzcas letras repetidas.");
		}

		for (int i = 0; i < palabraElegida.length(); i++) {
			if (letra == palabraElegida.charAt(i)) {
				letrasAcertadas[i] = true;
				acierto = true;
			}
		}

		if (acierto) {
			System.out.println("Letra correcta.");
		} else {
			System.out.println("Letra incorrecta");
			fallos++;
		}
	}

	private static boolean checkGanador() {
		int contadorAciertos = 0;
		for (boolean letrasAcertada : letrasAcertadas) {
			if (letrasAcertada) contadorAciertos++;
		}
		return contadorAciertos >= palabraElegida.length();
	}

	private static Boolean checkFallos() {
		return fallos < FALLOS_PERMITIDOS;
	}

	private static void reset() {
		palabraElegida = null;
		letrasAcertadas = null;
		fallos = 0;
		terminar = false;
		letrasIntroducidas = new TreeSet<>();
	}
}