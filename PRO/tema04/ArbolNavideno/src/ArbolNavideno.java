import java.util.Scanner;

public class ArbolNavideno {
	// char 27 = '\' , algunos terminales no interpretan este carácter como 'Escape'
	public static final String ANSI_RESET  = (char) 27 + "[0m";
	public static final String ANSI_BLACK  = (char) 27 + "[30m";
	public static final String ANSI_RED    = (char) 27 + "[31m";
	public static final String ANSI_GREEN  = (char) 27 + "[32m";
	public static final String ANSI_YELLOW = (char) 27 + "[33m";
	public static final String ANSI_BLUE   = (char) 27 + "[34m";
	public static final String ANSI_PURPLE = (char) 27 + "[35m";
	public static final String ANSI_CYAN   = (char) 27 + "[36m";
	public static final String ANSI_WHITE  = (char) 27 + "[37m";

	/**
	 * Por cada vuelta de bucle en el método main, llama a los métodos que imprimen partes del árbol, dependiendo de
	 * la configuración elegida por el usuario. Crea la ilusión de que el árbol está animado.
	 *
	 * @param ramas      Se utiliza como argumento para el método dibujaRamas y dibujaTronco
	 * @param decoracion Se utiliza como argumento para el método dibujaRamas
	 * @param tronco     Se utiliza como argumento para el método dibujaTronco
	 * @param regalos    Se utiliza como argumento para el método dibujaTronco
	 * @throws InterruptedException Requisito para utilizar Thread.sleep()
	 */
	private static void dibujaFrame(byte ramas, boolean decoracion, boolean tronco, boolean regalos) throws InterruptedException {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if (ramas > 0) {
			dibujaRamas(ramas, decoracion);
		}
		if (tronco) {
			dibujaTronco(ramas, regalos);
		}
		Thread.sleep(1000);
	}

	/**
	 * Cuenta con 3 bucles anidados, for rama → for fila → for hoja.
	 * Calcula la cantidad de espacios y de hojas a imprimir, basándose en la cantidad de ramas introducidas por el
	 * usuario.
	 * <p>
	 * Si la decoración está activada, remplaza algunas de las hojas de manera aleatoria por una de las decoraciones,
	 * también de manera aleatoria.
	 *
	 * @param ramas      determina la altura y el ancho del árbol
	 * @param decoracion activa o desactiva la decoración
	 */
	public static void dibujaRamas(byte ramas, boolean decoracion) {
		int hojas    = 1;
		int espacios = (ramas * 2) + 1; // espacios = (((ramas * filasPorRama) / 2) + hojaCentro)

		for (int i = 0; i < ramas; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < espacios - j; k++) {
					System.out.print(" ");
				}
				/* SI LA DECORACIÓN ESTÁ ACTIVADA */
				if (decoracion) {
					/* SI ES LA PRIMERA HOJA */
					if (i == 0 && j == 0) {
						for (int k = 0; k < hojas; k++) {
							System.out.print(ANSI_YELLOW + "&");
						}
					}
					else {
						for (int k = 0; k < hojas; k++) {
							/* NUMERO ALEATORIO, PROBABILIDAD DE CADA ADORNO */
							switch (((int) ((Math.random() * 30) + 1))) {
								case 1:
									System.out.print(ANSI_RED + "@");
									break;
								case 2:
									System.out.print(ANSI_YELLOW + "$");
									break;
								case 3:
									System.out.print(ANSI_BLUE + "+");
									break;
								case 4:
									System.out.print(ANSI_PURPLE + "O");
									break;
								case 5:
									System.out.print(ANSI_CYAN + "%");
									break;
								case 6:
									System.out.print(ANSI_WHITE + "{");
									break;
								default:
									System.out.print(ANSI_GREEN + "*");
									break;
							}
						}
					}
				}
				else {
					for (int k = 0; k < hojas; k++) {
						System.out.print(ANSI_GREEN + "*");
					}
				}
				/* SI NO ÉS LA ÚLTIMA FILA */
				if (j < 3) {
					hojas += 2;
				}
				System.out.println();
			}
			/* AL CAMBIAR DE RAMA */
			hojas -= 2;
			espacios -= 2;
		}
	}

	/**
	 * Imprime el tronco debajo del árbol, calcula la cantidad adecuada de espacios, teniendo en cuenta las ramas.
	 * <p>
	 * Si los regalos están activados, los imprime a la derecha del tronco.
	 *
	 * @param ramas   Utilizado para determinar la cantidad de espacios a la izquierda del tronco
	 * @param regalos Si és true, imprime unos regalos a la derecha del tronco
	 */
	public static void dibujaTronco(byte ramas, boolean regalos) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 0; j < (ramas * 2); j++) {
				System.out.print(" ");
			}
			if (regalos) {
				switch (i) {
					case 1:
						System.out.println(ANSI_YELLOW + "|||\t\t" + ANSI_RED + "#" + ANSI_WHITE + "\\V/" + ANSI_RED + "#");
						break;
					case 2:
						System.out.println(ANSI_YELLOW + "|||\t\t" + ANSI_RED + "##" + ANSI_WHITE + "#" + ANSI_RED +
						                   "##\t" + ANSI_PURPLE + "#" + ANSI_WHITE + "V" + ANSI_PURPLE + "#");
						break;
					case 3:
						System.out.println(ANSI_YELLOW + "|||\t\t" + ANSI_RED + "#####\t" + ANSI_PURPLE + "###");
						break;
				}
			}
			else {
				System.out.println(ANSI_YELLOW + "|||");
			}
		}
	}

	/**
	 * Muestra el menú donde el usuario puede configurar el árbol. Contiene el bucle principal, que llama al método
	 * dibujaFrame.
	 *
	 * @throws InterruptedException Requisito para utilizar Thread.sleep()
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		byte    ramas;
		boolean tronco  = false, decoracion = false, regalos = false;

		System.out.print("Número de ramas -> ");
		ramas = scanner.nextByte();

		scanner.nextLine(); // limpia el buffer

		System.out.print("Tronco (S/N) -> ");
		if (scanner.nextLine().equalsIgnoreCase("S")) {
			tronco = true;
		}

		if (tronco) {
			System.out.print("Regalos (S/N) -> ");
			if (scanner.nextLine().equalsIgnoreCase("S")) {
				regalos = true;
			}
		}

		System.out.print("Decoración (S/N) -> ");
		if (scanner.nextLine().equalsIgnoreCase("S")) {
			decoracion = true;
		}

		if (decoracion) {
			while (true) {
				dibujaFrame(ramas, true, tronco, regalos);
			}
		}
		else {
			dibujaFrame(ramas, false, tronco, regalos);
		}
	}
}
