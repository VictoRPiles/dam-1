import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Victor
 * @since 06/05/2022 - 10:32
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		importarInfoClientes(new File("exportaciones/clientes.dat"));
		menu();
	}

	private static void menu() {
		int op;

		System.out.println("===== VETERINARIO =====");
		System.out.println("1) Anyadir un cliente a la clínica.");
		System.out.println("2) Anyadir mascota a un cliente.");
		System.out.println("3) Vacunar perro.");
		System.out.println("4) Exportar perros vacunados.");
		System.out.println("5) Salir.");
		System.out.print("> ");
		op = scanner.nextInt();
		scanner.nextLine(); /* limpiar buffer */

		switch (op) {
			case 1 -> {
				addCliente();
				menu();
			}
			case 2 -> {
				addMascota();
				menu();
			}
			case 3 -> {
				vacunarPerro();
				menu();
			}
			case 4 -> {
				Clinica.exportarPerrosVacunados();
				menu();
			}
			case 5 -> salir();
			default -> menu();
		}
	}

	/**
	 * Pide los datos para crear un {@link Cliente}.
	 *
	 * @see Clinica#addCliente(Cliente)
	 */
	private static void addCliente() {
		String dni;
		String nombre;

		System.out.println("===== AÑADIR CLIENTE =====");
		System.out.print("DNI -> ");
		dni = scanner.nextLine();
		System.out.print("Nombre -> ");
		nombre = scanner.nextLine();

		if (Clinica.addCliente(new Cliente(dni, nombre))) {
			System.out.println("Añadiendo cliente a la clínica...");
		} else {
			System.out.println("Este cliente ya existe en la clínica.");
		}
	}

	/**
	 * Pide los datos para crear una {@link Mascota} y la añade a un {@link Cliente}.
	 *
	 * @see Cliente#addMascota(Mascota)
	 */
	private static void addMascota() {
		String id, dni;
		String nombre;
		Cliente thisCliente;
		boolean esPerro = false;

		System.out.println("===== AÑADIR MASCOTA =====");
		System.out.print("DNI del cliente -> ");
		dni = scanner.nextLine();

		if ((thisCliente = Clinica.getCliente(dni)) == null) {
			System.out.println("No existe este cliente en la clínica.");
			return;
		}

		System.out.print("ID -> ");
		id = scanner.nextLine();
		System.out.print("Nombre -> ");
		nombre = scanner.nextLine();
		System.out.print("¿Es un perro? (S/n) -> ");
		if (scanner.nextLine().equalsIgnoreCase("s")) {
			esPerro = true;
		}

		if (esPerro) {
			if (thisCliente.addMascota(new Perro(id, nombre))) {
				System.out.println("Añadiendo perro al cliente...");
			} else {
				System.out.println("Este cliente ya tiene una mascota con este ID.");
			}
		} else {
			if (thisCliente.addMascota(new Mascota(id, nombre))) {
				System.out.println("Añadiendo mascota al cliente...");
			} else {
				System.out.println("Este cliente ya tiene esta mascota.");
			}
		}
	}

	/**
	 * Pide los datos para vacunar a un {@link Perro}.
	 *
	 * @see Clinica#vacunarPerro(Perro)
	 * @see Perro#vacunar()
	 */
	private static void vacunarPerro() {
		String id, dni;
		Perro thisPerro;

		System.out.println("===== VACUNAR PERRO =====");
		System.out.print("DNI del cliente -> ");
		dni = scanner.nextLine();

		if (Clinica.getCliente(dni) == null) {
			System.out.println("No existe este cliente en la clínica.");
			return;
		}

		System.out.print("ID del perro -> ");
		id = scanner.nextLine();

		if ((thisPerro = Clinica.getPerro(dni, id)) == null) {
			System.out.println("No existe este perro en la clínica.");
			return;
		}

		System.out.println("Vacunando perro...");
		Clinica.vacunarPerro(thisPerro);
	}

	/**
	 * Guarda los datos de los {@link Cliente} de la {@link Clinica} en un archivo binario.
	 */
	private static void salir() {
		ObjectOutputStream objectOutputStream = null;

		if (!new File("exportaciones").exists()) {
			if (new File("exportaciones").mkdir()) System.out.println("Creando la carpeta exportaciones...");
		}

		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("exportaciones/clientes.dat"));

			for (Cliente cliente : Clinica.getClientes()) {
				objectOutputStream.writeObject(cliente);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (objectOutputStream != null) objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Importa los datos de los {@link Cliente} desde un archivo binario.
	 *
	 * @param exp Archivo binario con los datos.
	 */
	private static void importarInfoClientes(File exp) {
		ObjectInputStream objectInputStream = null;
		Cliente thisCliente;
		ArrayList<Cliente> clientes = new ArrayList<>();

		if (!exp.exists()) {
			System.out.println("No se puede leer el archivo " + exp + ", no existe.");
		} else {
			try {
				objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(exp)));

				while ((thisCliente = (Cliente) objectInputStream.readObject()) != null) {
					clientes.add(thisCliente);
				}
			} catch (EOFException ignored) {
				System.out.println("Importando clientes desde " + exp + "...");
			} catch (IOException | ClassNotFoundException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (objectInputStream != null) objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/* Añadiendo los perros anteriormente vacunados a la lista de vacunados en la clínica */
		if (!clientes.isEmpty()) {
			for (Cliente cliente : clientes) {
				Clinica.addCliente(cliente);

				for (Mascota mascota : cliente.getMascotas()) {
					if (mascota instanceof Perro && ((Perro) mascota).isVacunado()) {
						Clinica.addPerroVacunado((Perro) mascota);
					}
				}
			}
		}
	}
}