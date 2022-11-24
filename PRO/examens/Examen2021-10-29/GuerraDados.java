import java.io.IOException;
import java.util.Scanner;

public class GuerraDados {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		byte opcion;
		long puntosMaximos = 1000;

		do {
			opcion = menu();

			switch (opcion) {
				case 1 -> puntosMaximos = configurar();
				case 2 -> {
					System.out.println("Introducir los nombres");
					jugar(scanner.nextLine(), scanner.nextLine(), puntosMaximos);
				}
				case 3 -> System.out.println("Cerrando programa");
			}
		} while (opcion != 3);
	}

	/**
	 * Imprime el menú y evalúa si la opción introducida por el usuario es válida, si no lo es, vuelve a imprimir el
	 * menú.
	 * <p>
	 * En el caso de que la opción sea la 1 (configurar puntos), vuelve a mostrar el menú, para que el usuario pueda
	 * seleccionar si quiere jugar o si quiere volver a configurar los puntos.
	 *
	 * @return La opción del menú elegida por el usuario.
	 */
	public static byte menu() {
		Scanner scanner = new Scanner(System.in);
		boolean opcionValida = false;
		byte opcion;

		System.out.print("1-Configurar\n2-Jugar\n3-Salir\n");

		do {
			opcion = scanner.nextByte();
			switch (opcion) {
				case 1, 2, 3 -> opcionValida = true;
				default -> System.out.println("ERROR: Opcion no valida");
			}
		} while (!opcionValida);

		return opcion;
	}

	/**
	 * Permite configurar la cantidad de puntos con los que el jugador gana la partida.
	 *
	 * @return La nueva cantidad de puntos máximos.
	 */
	public static long configurar() {
		Scanner scanner = new Scanner(System.in);
		long puntosMaximos;

		System.out.print("Nuevo maximo de puntos -> ");
		puntosMaximos = scanner.nextLong();

		return puntosMaximos;
	}

	/**
	 * Lee el nombre de los jugadores y el máximo de puntos, llama a la función lanzarDados(), que genera dos numeros
	 * aleatorios para cada jugador, llama a la función jugarTurno(), que devuelve la cantidad de puntos que ha
	 * conseguido cada jugador en la jugada actual.
	 * <p>
	 * Compara los puntos ganados en la jugada actual de los jugadores, suma los puntos ganados en la jugada actual de
	 * los dos jugadores al jugador ganador, el jugador perdedor no suma puntos en dicha jugada.
	 *
	 * @param nomJ1         Nombre para el jugador 1.
	 * @param nomJ2         Nombre para el jugador 2.
	 * @param puntosMaximos Puntos con los que se gana el juego, se configura en la funcion configurar(), por defecto
	 *                      1000.
	 * @throws IOException Necesario para utilizar el método System.in.read().
	 */
	public static void jugar(String nomJ1, String nomJ2, long puntosMaximos) throws IOException {
		int puntosJ1 = 0, puntosJ1Anterior, puntosJ1Jugada;
		int puntosJ2 = 0, puntosJ2Anterior, puntosJ2Jugada;
		int[] dadosJ1 = new int[2];
		int[] dadosJ2 = new int[2];

		do {
			// ===== GUARDADO DE PUNTOS =====
			puntosJ1Anterior = puntosJ1;

			puntosJ2Anterior = puntosJ2;

			// ===== TIRADA DE DADOS =====
			dadosJ1[0] = tirarDados();
			dadosJ1[1] = tirarDados();

			dadosJ2[0] = tirarDados();
			dadosJ2[1] = tirarDados();

			// ===== PUNTOS DE LA JUGADA =====
			puntosJ1 += jugarTurno(dadosJ1[0], dadosJ1[1]);
			puntosJ1Jugada = puntosJ1 - puntosJ1Anterior;

			puntosJ2 += jugarTurno(dadosJ2[0], dadosJ2[1]);
			puntosJ2Jugada = puntosJ2 - puntosJ2Anterior;

			// ===== GANADOR DE LA RONDA =====
			if (puntosJ1Jugada > puntosJ2Jugada) {
				puntosJ1 += puntosJ1Jugada + puntosJ2Jugada;
				puntosJ2 = puntosJ2Anterior;
				System.out.printf("%s GANA LA RONDA\n", nomJ1);
			} else if (puntosJ2Jugada > puntosJ1Jugada) {
				puntosJ2 += puntosJ1Jugada + puntosJ2Jugada;
				puntosJ1 = puntosJ1Anterior;
				System.out.printf("%s GANA LA RONDA\n", nomJ2);
			} else {
				puntosJ1 = puntosJ1Anterior;
				puntosJ2 = puntosJ2Anterior;
				System.out.println("RONDA EMPATADA");
			}

			System.out.printf("PUNTOS %s -> %d\nPUNTOS %s -> %d\n\n", nomJ1, puntosJ1, nomJ2, puntosJ2);
			System.out.println("PULSA <ENTER> PARA CONTINUAR...");
			System.in.read();

		} while ((puntosJ1 < puntosMaximos) && (puntosJ2 < puntosMaximos));

		if (puntosJ1 > puntosJ2) {
			System.out.printf("%s ES EL GANADOR\n\n", nomJ1);
		} else if (puntosJ2 > puntosJ1) {
			System.out.printf("%s ES EL GANADOR\n\n", nomJ2);
		} else {
			System.out.println("PARTIDA EMPATADA");
		}
	}

	/**
	 * Es el juego correspondiente al numero 1 del dado1.
	 * <p>
	 * Calcula el factorial del valor obtenido en el dado2.
	 *
	 * @param n Valor obtenido en el dado2.
	 * @return El resultado del factorial.
	 */
	public static int j1Factorial(int n) {
		int factorial = 1;

		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}

		return factorial;
	}

	/**
	 * Es el juego correspondiente al numero 2 del dado1.
	 * <p>
	 * Calcula el factorial del valor obtenido en el dado2.
	 *
	 * @param n Valor obtenido en el dado2
	 * @return El resultado del sumatorio.
	 */
	public static int j2Sumatorio(int n) {
		int sumatorio = 0;

		for (int i = 0; i < n; i++) {
			sumatorio = sumatorio + i;
		}

		return sumatorio;
	}

	/**
	 * @return Numero aleatorio del 1 al 6.
	 */
	public static int tirarDados() {
		return (int) (Math.random() * 6 + 1);
	}

	/**
	 * Contiene los cálculos para los distintos juegos.
	 *
	 * @param dado1 Valor obtenido en el dado1.
	 * @param dado2 Valor obtenido en el dado2.
	 * @return Los puntos que obtiene el jugador en esta tirada.
	 */
	public static int jugarTurno(int dado1, int dado2) {
		return switch (dado2) {
			case 1 -> j1Factorial(dado1);
			case 2 -> j2Sumatorio(dado1);
			case 3 -> (int) Math.pow(dado1, 2);
			case 4 -> 1;
			case 5 -> (dado1 * dado1);
			default -> 0;
		};
	}
}