import java.util.Arrays;
import java.util.Scanner;

public class Primitiva {

	static Scanner scanner = new Scanner(System.in);

	/**
	 * Muestra el menu y permite seleccionar las opciones
	 */
	private static void menu() {

		boolean salir = false;

		do {
			System.out.println("1)\tJUEGO\n2)\tSALIR");
			if (scanner.nextInt() == 1) {
				juego();
			} else {
				System.out.println("SALIENDO...");
				salir = true;
			}
		} while (!salir);
	}

	/**
	 * Genera la combinación de números que no se repiten
	 *
	 * @return seis números aleatorios entre 1 y 49
	 */
	private static int[] getCombinacion() {

		int[] combinacion = new int[6];

		for (int i = 0; i < combinacion.length; i++) {
			combinacion[i] = (int) ((Math.random() * 49) + 1);
		}

		if (combinacionCorrecta(combinacion)) {
			return combinacion;
		}
		return getCombinacion();
	}

	/**
	 * Genera el reintegro
	 *
	 * @return un número aleatorio entre 0 y 9
	 */
	private static int getReintegro() {

		return (int) (Math.random() * 9);
	}

	/**
	 * Genera el número complementario
	 *
	 * @return un número aleatorio entre 1 y 49
	 */
	private static int getComplementario() {

		return (int) ((Math.random() * 49) + 1);
	}

	/**
	 * Comprueba si se repite algun número en el array
	 *
	 * @param combinacion
	 * @return
	 */
	private static boolean combinacionCorrecta(int[] combinacion) {

		for (int i = 0; i < combinacion.length; i++) {
			for (int j = i + 1; j < combinacion.length; j++) {
				if (combinacion[j] == combinacion[i]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Comprueba si los números están dentro del rango permitido y si no se repiten
	 *
	 * @param combUsuario
	 * @param complementarioUsuario
	 * @param reintegroUsuario
	 * @return
	 */
	private static boolean datosCorrectos(int[] combUsuario, int complementarioUsuario, int reintegroUsuario) {

		if (!(complementarioUsuario > 0 && complementarioUsuario <= 49) && (reintegroUsuario >= 0 && reintegroUsuario <= 9)) {
			return false;
		} else {
			return combinacionCorrecta(combUsuario);
		}
	}

	/**
	 * Asigna los valores a las variables del juego, comprueba si son correctos y los envía al método aciertos
	 */
	private static void juego() {

		int[] combGanadora = getCombinacion(), combUsuario = new int[6];
		int complementario = getComplementario(), complementarioUsuario, reintegro = getReintegro(), reintegroUsuario;

		System.out.print("Introduce tu combinación -> ");
		for (int i = 0; i < combUsuario.length; i++) {
			combUsuario[i] = scanner.nextInt();
		}
		System.out.print("Introduce tu complementario -> "); complementarioUsuario = scanner.nextInt();
		System.out.print("Introduce tu reintegro -> "); reintegroUsuario = scanner.nextInt();

		if (datosCorrectos(combUsuario, complementarioUsuario, reintegroUsuario)) {
			System.out.printf("Combinación ganadora: %s\tComplementario: %d\tReintegro: %d\n",
					Arrays.toString(combGanadora), complementario, reintegro);
			System.out.printf("Combinación  usuario: %s\tComplementario: %d\tReintegro: %d\n",
					Arrays.toString(combUsuario), complementarioUsuario, reintegroUsuario);

			aciertos(combGanadora, combUsuario, complementario, complementarioUsuario, reintegro, reintegroUsuario);
		} else {
			System.out.println("ERROR: Datos incorrectos");
		}
	}

	/**
	 * Comprueba la cantidad de aciertos y determina los premios
	 *
	 * @param combGanadora
	 * @param combUsuario
	 * @param complementario
	 * @param complementarioUsuario
	 * @param reintegro
	 * @param reintegroUsuario
	 */
	private static void aciertos(int[] combGanadora, int[] combUsuario, int complementario, int complementarioUsuario,
	                             int reintegro, int reintegroUsuario) {

		int aciertos = 0;
		boolean aciertoReintegro = false, aciertoComplementario = false;

		for (int i = 0; i < combGanadora.length; i++) {
			for (int j = 0; j < combUsuario.length; j++) {
				if (combGanadora[i] == combUsuario[j]) {
					aciertos++;
					break;
				}
			}
		}
		if (complementario == complementarioUsuario) {
			aciertoComplementario = true;
		}
		if (reintegro == reintegroUsuario) {
			aciertoReintegro = true;
		}

		switch (aciertos) {
			case 6:
				if (aciertoReintegro) {
					System.out.println("Premio especial");
					break;
				}
				System.out.println("Primer premio");
				break;
			case 5:
				if (aciertoComplementario) {
					System.out.println("Segundo premio");
					break;
				}
				System.out.println("Tercer premio");
				break;
			case 4:
				System.out.println("Cuarto premio");
				break;
			case 3:
				System.out.println("Quinto premio");
				break;
			default:
				if (aciertoReintegro) {
					System.out.println("Reintegro");
					break;
				}
				System.out.println("No premiado");
				break;
		}
	}

	public static void main(String[] args) {

		menu();
	}
}
