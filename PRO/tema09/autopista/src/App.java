import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
	static Ventanilla efectivo = new Ventanilla(Ventanillas.EFECTIVO);
	static Ventanilla importe = new Ventanilla(Ventanillas.IMPORTE_EXACTO);
	static Ventanilla tarjeta = new Ventanilla(Ventanillas.TARJETA);

	/**
	 * @return La ventanilla que se va a utilizar.
	 */
	private static Ventanilla getVentanilla() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Seleccionar cola");
		System.out.println("1) Efectivo");
		System.out.println("2) Importe exacto");
		System.out.println("3) Tarjeta");
		System.out.print("> ");

		return switch (scanner.nextInt()) {
			case 1 -> efectivo;
			case 2 -> importe;
			case 3 -> tarjeta;
			default -> getVentanilla();
		};
	}

	/**
	 * @return Si e vehículo va a entrar o a salir.
	 */
	private static boolean getEntrarSalir() {
		Scanner scanner = new Scanner(System.in);
		int entrada;

		System.out.println("¿Entrar o salir?");
		System.out.println("1) Entrar");
		System.out.println("2) Salir");
		System.out.print("> ");

		entrada = scanner.nextInt();
		if (entrada == 1 || entrada == 2) return entrada == 1;
		return getEntrarSalir();
	}

	/**
	 * @return Si el vehículo es coche o moto.
	 */
	private static Vehiculo getCocheMoto() {
		Scanner scanner = new Scanner(System.in);
		int entrada;
		String matricula, modelo, color;

		System.out.println("¿Coche o moto?");
		System.out.println("1) Coche");
		System.out.println("2) Moto");
		System.out.print("> ");

		entrada = scanner.nextInt();
		scanner.nextLine(); // limpiar buffer
		System.out.println("Introduce la matrícula");
		System.out.print("> "); matricula = scanner.nextLine();
		System.out.println("Introduce el modelo");
		System.out.print("> "); modelo = scanner.nextLine();
		System.out.println("Introduce el color");
		System.out.print("> "); color = scanner.nextLine();

		if (entrada == 1) return new Coche(matricula, modelo, color);
		if (entrada == 2) return new Moto(matricula, modelo, color);
		return getCocheMoto();
	}

	/**
	 * Añade el vehículo a la ventanilla correspondiente.
	 * Muestra un mensaje con información sobre la operación.
	 */
	private static void entrar(Ventanilla ventanilla) {
		Vehiculo vehiculo = getCocheMoto();

		System.out.println("Entra -> " + vehiculo + " Por la ventanilla " + ventanilla);
		ventanilla.add(vehiculo);
	}

	/**
	 * Borra el vehículo de la ventanilla correspondiente.
	 * Muestra un mensaje con información sobre la operación.
	 */
	private static void salir(Ventanilla ventanilla) {
		try {
			System.out.println("Sale -> " + ventanilla.getFirst() + " Por la ventanilla " + ventanilla);
			ventanilla.remove();
		} catch (NoSuchElementException e) {
			System.out.println("No hay vehículos en esta ventanilla");
		}
	}

	/**
	 * Imprime la cantidad de Coches que han pasado por la autopista.
	 */
	private static void printContadorCoches() {
		if (Ventanilla.getContadorCoches() != 1)
			System.out.println("Han pasado " + Ventanilla.getContadorCoches() + " coches por la autopista");
		else System.out.println("Ha pasado " + Ventanilla.getContadorCoches() + " coche por la autopista");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;
		Ventanilla thisVentanilla;
		boolean entrar;

		while (!salir) {
			thisVentanilla = getVentanilla();
			entrar = getEntrarSalir();

			if (entrar) entrar(thisVentanilla);
			else salir(thisVentanilla);

			System.out.println("Salir del programa? (s/N)");
			System.out.print("> ");
			if (scanner.nextLine().equalsIgnoreCase("s")) salir = true;

		}

		System.out.println("Lista de vehículos ordenada: ");
		System.out.println(Ventanilla.ordenarVehiculos());

		printContadorCoches();
	}
}