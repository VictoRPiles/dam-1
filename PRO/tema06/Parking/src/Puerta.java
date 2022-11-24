import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Victor Piles
 * @since 28/01/2022 9:46
 */
public class Puerta {

	Aparcamiento aparcamiento;
	private static ArrayList<Puerta> instancias = new ArrayList<>();

	public Puerta(Aparcamiento aparcamiento) {
		this.aparcamiento = aparcamiento;
		instancias.add(this);
	}

	public static ArrayList<Puerta> getInstancias() {
		return instancias;
	}

	public void aparcarCoche() {
		if (aparcamiento.hayHuecos()) {
			System.out.println("PUERTA ABIERTA...");
			aparcamiento.aparcarCoche();
		} else System.out.println("ERROR: PARKING LLENO...");
	}

	public void sacarCoche() {
		if (aparcamiento.hayCoches()) {
			System.out.println("PUERTA ABIERTA...");
			aparcamiento.sacarCoche();
		} else System.out.println("ERROR: PARKING VACÍO...");
	}

	/**
	 * Visualiza todas las instancias de {@link Puerta}
	 */
	public static void verPuertas() {
		System.out.println("Elige una de las siguientes puertas");
		for (Puerta instancia : instancias) {
			System.out.println(instancia);
		}
	}

	/**
	 * Devuelve la instancia de la {@link Puerta} elegida
	 */
	public static Puerta elegirPuerta(int puertaElegida) {
		System.out.printf("HAS ELEGIDO LA PUERTA %d\n", puertaElegida);
		return instancias.get(puertaElegida);
	}

	public char entrarSalir() {
		Scanner scanner = new Scanner(System.in);
		char op;

		System.out.println("Elige una opción");
		System.out.println("Aparcar (A)");
		System.out.println("Salir   (S)");

		op = scanner.next().toUpperCase().charAt(0);
		switch (op) {
			case 'A', 'S':
				return op;
			default:
				System.out.println("ERROR: OPCIÓN NO VÁLIDA");
				return 'X';
		}
	}

	@Override
	public String toString() {
		return String.format("Puerta %d", instancias.indexOf(this));
	}
}
