import java.util.Scanner;

/**
 * @author VictoRPiles
 */
public class Ahorcado {
	// PISTA: PALABRAS QUE SOLO SE USAN EN ESPAÑOL DE ESPAÑA
	static final String[] diccionario = {
			"hortera", "tabarra", "postureo", "guay", "achuchar", "rebote", "acojonante", "barbas", "pijo", "bocas",
			"patear", "botellon", "notas", "caballito", "mileurista", "callo", "maruja", "canguro", "lorza", "choni",
			"gorrilla", "chuleta", "empollon", "flipar", "loco"
	};
	static final String palabra = elegirPalabra();
	static boolean[] aciertos = new boolean[palabra.length()];
	static int fallos = 0;

	/**
	 * Se elige una palabra aleatoria del diccionario
	 */
	private static String elegirPalabra() {

		return diccionario[(int) (Math.random() * diccionario.length)];
	}

	/**
	 * Comprueba si la letra introducida coincide con algún carácter de la palabra.
	 * En aciertos[] se marca como true los índices que coinciden con la letra.
	 */
	private static boolean[] comprobarLetra() {

		Scanner scanner = new Scanner(System.in);

		char letra;
		boolean incrementoFallo = true;

		System.out.print("Introduce una letra -> "); letra = scanner.next().toLowerCase().charAt(0);

		for (int i = 0; i < palabra.length(); i++) {
			if (letra == palabra.charAt(i)) {
				aciertos[i] = true;
				incrementoFallo = false;
			}
		}
		if (incrementoFallo) {
			fallos++;
		}

		return aciertos;
	}

	/**
	 * Determina si el juego termina y si se gana o no
	 */
	private static boolean victoria() {

		if (fallos > 6) {
			System.out.printf("GAME OVER!, LA PALABRA ERA -> %s", palabra.toUpperCase());
			return true;
		}

		for (boolean b : aciertos) {
			if (!b) {
				return false;
			}
		}

		System.out.printf("CORRECTO!, LA PALABRA ERA -> %s", palabra.toUpperCase());
		return true;
	}

	/**
	 * Dibuja el tablero de juego y el ahorcado
	 */
	private static void dibujar() {

		if (fallos == 0) {
			System.out.println(" ________  ");
			System.out.println("I        | ");
			System.out.println("I        | ");
			System.out.println("I          ");
			System.out.println("I          ");
			System.out.println("I         ");
			System.out.println();
		}
		if (fallos == 1) {
			System.out.println(" ________  ");
			System.out.println("I        | ");
			System.out.println("I        | ");
			System.out.println("I        0 ");
			System.out.println("I          ");
			System.out.println("I          ");
			System.out.println();
		}
		if (fallos == 2) {
			System.out.println(" ________  ");
			System.out.println("I        | ");
			System.out.println("I        | ");
			System.out.println("I        0 ");
			System.out.println("I        ¡ ");
			System.out.println("I          ");
			System.out.println();
		}
		if (fallos == 3) {
			System.out.println(" ________  ");
			System.out.println("I        | ");
			System.out.println("I        | ");
			System.out.println("I        0 ");
			System.out.println("I       /¡ ");
			System.out.println("I          ");
			System.out.println();
		}
		if (fallos == 4) {
			System.out.println(" ________  ");
			System.out.println("I        | ");
			System.out.println("I        | ");
			System.out.println("I        0 ");
			System.out.println("I       /¡\\ ");
			System.out.println("I          ");
			System.out.println();
		}
		if (fallos == 5) {
			System.out.println(" ________  ");
			System.out.println("I        | ");
			System.out.println("I        | ");
			System.out.println("I        0 ");
			System.out.println("I       /¡\\ ");
			System.out.println("I       /  ");
			System.out.println();
		}
		if (fallos == 6) {
			System.out.println(" ________  ");
			System.out.println("I        | ");
			System.out.println("I        | ");
			System.out.println("I        0 ");
			System.out.println("I       /¡\\ ");
			System.out.println("I       / \\ ");
			System.out.println();
		}

		for (int i = 0; i < palabra.length(); i++) {
			if (aciertos[i]) {
				System.out.print(palabra.charAt(i) + " ");
			} else {
				System.out.print("_ ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		while (!victoria()) {
			dibujar();
			comprobarLetra();
		}
	}
}

