package garaje;

/**
 * @author Victor Piles
 * @since 31/01/2022 13:41
 */
public class Garaje {

	private static Coche coche;
	private static String averiaAsociada;
	private static int cochesAtendidos;

	public Garaje() {}

	/**
	 * Evalua si ya hay un {@link Coche} en el garaje
	 * <p>
	 * Si el garaje está inicializa el coche y llama a la funcion {@link Garaje#checkAveriaAsociada(String)}
	 *
	 * @return True si acepta el coche o false si lo rechaza
	 */
	public static boolean aceptarCoche(Coche coche, String averiaAsociada) {
		if (Garaje.coche == null) {
			Garaje.coche = coche;
			Garaje.averiaAsociada = averiaAsociada;
			checkAveriaAsociada(averiaAsociada);
			return true;
		} else return false;
	}

	/**
	 * Llamado por {@link Garaje#aceptarCoche(Coche, String)}
	 * <p>
	 * Comprueba si la avería se trata de un problema de aceite, si es así llama a {@link Motor#setLitrosAceite(int)} e
	 * incrementa su valor
	 * <p>
	 * Independientemente de esta condición llama a {@link Coche#acumularAveria(double)} y cobra un precio random
	 */
	public static void checkAveriaAsociada(String averiaAsociada) {
		if (averiaAsociada.equalsIgnoreCase("aceite")) coche.getMotor().setLitrosAceite(10);
		coche.acumularAveria((Math.random() + 1) * 100);
	}

	/**
	 * Saca el {@link Coche} del Garaje y le asigna un valor nulo
	 */
	public static void devolverCoche() {
		System.out.print("Devolviendo coche\n");
		coche = null;
	}
}
