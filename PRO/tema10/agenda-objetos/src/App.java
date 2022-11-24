import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Victor
 * @since 06/05/2022 - 9:41
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		File exp = new File("exportaciones/agenda.dat");

		importarDatos(agenda, leerBinario(exp));
		menu(agenda);
	}

	private static void menu(Agenda agenda) {
		int op;
		boolean salir = false;

		System.out.println("==== Menu Opciones ====");
		System.out.println("1) Anyadir contacto");
		System.out.println("2) Borrar contacto");
		System.out.println("3) Buscar contacto");
		System.out.println("4) Exportar agenda a 'agenda.txt'");
		System.out.println("5) Salir");
		System.out.print("> ");

		op = scanner.nextInt();
		scanner.nextLine(); /* limpiar buffer */

		switch (op) {
			case 1 -> addContacto(agenda);
			case 2 -> removeContacto(agenda);
			case 3 -> getContacto(agenda);
			case 4 -> exportarAgenda(agenda);
			case 5 -> salir = true;
			default -> menu(agenda);
		}

		if (salir) {
			guardarBinario(agenda);
			System.out.println("Saliendo del programa...");
		} else menu(agenda);
	}

	/** @see Agenda#add(Contacto) */
	private static void addContacto(Agenda agenda) {
		String nombre;
		String telefono;
		boolean otroContacto = true;

		while (otroContacto) {
			System.out.println("==== Nuevo contacto ====");
			System.out.print("Nombre -> ");
			nombre = scanner.nextLine();
			System.out.print("Telefono -> ");
			telefono = scanner.nextLine();

			if (agenda.add(new Contacto(nombre, telefono)))
				System.out.println("Anyadiendo el contacto a la agenda...");
			else
				System.out.println("No se puede anyadir el contacto.");

			System.out.print("Anyadir un nuevo contacto (S\\n) -> ");
			if (scanner.nextLine().equalsIgnoreCase("n")) {
				otroContacto = false;
			}
		}
	}

	/** @see Agenda#remove(String) */
	private static void removeContacto(Agenda agenda) {
		String nombre;
		boolean otroContacto = true;

		while (otroContacto) {
			System.out.println("==== Borrar contacto ====");
			System.out.print("Nombre -> ");
			nombre = scanner.nextLine();

			if (agenda.remove(nombre))
				System.out.println("Borrando los contactos de la agenda....");
			else
				System.out.println("No se puede borrar el contacto.");

			System.out.print("Borrar otro contacto (S\\n) -> ");
			if (scanner.nextLine().equalsIgnoreCase("n")) {
				otroContacto = false;
			}
		}
	}

	/** @see Agenda#get(String) */
	private static void getContacto(Agenda agenda) {
		String nombre;
		Contacto[] contactosEncontrados;
		boolean otroContacto = true;

		while (otroContacto) {
			System.out.println("==== Buscar contacto ====");
			System.out.print("Nombre -> ");
			nombre = scanner.nextLine();

			System.out.println("Buscando contacto en la agenda...");
			contactosEncontrados = agenda.get(nombre);

			if (contactosEncontrados.length == 0) System.out.println("Contacto no encontrado");
			else System.out.println(Arrays.toString(contactosEncontrados));

			System.out.print("Buscar otro contacto (S\\n) -> ");
			if (scanner.nextLine().equalsIgnoreCase("n")) {
				otroContacto = false;
			}
		}
	}

	/** Exporta la agenda a u archivo de texto. */
	private static void exportarAgenda(Agenda agenda) {
		File exp = new File("exportaciones/agenda.txt");
		BufferedWriter writer = null;

		if (!new File("exportaciones").exists()) {
			if (new File("exportaciones").mkdir()) System.out.println("Creando la carpeta exportaciones...");
		}

		try {
			writer = new BufferedWriter(new FileWriter(exp));

			writer.write(agenda.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Guarda el {@link Contacto#getNombre()} y {@link Contacto#getTelefono()} en un archivo binario.
	 * <p>
	 * Si se han importado los datos se sobreescribe el archivo, si no se hace append.
	 */
	private static void guardarBinario(Agenda agenda) {
		File exp = new File("exportaciones/agenda.dat");
		ObjectOutputStream objectOutputStream = null;

		if (!new File("exportaciones").exists()) {
			if (new File("exportaciones").mkdir()) System.out.println("Creando la carpeta exportaciones...");
		}

		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(exp));

			for (Contacto contacto : agenda.getContactos()) {
				objectOutputStream.writeObject(contacto);
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

	/** Lee los datos del archivo binario pasado por parámetro y los devuelve como un {@link String}. */
	private static Contacto[] leerBinario(File exp) {
		ObjectInputStream objectInputStream = null;
		Contacto thisContacto;
		ArrayList<Contacto> contactos = new ArrayList<>();

		if (!exp.exists()) {
			System.out.println("No se puede leer el archivo " + exp + ", no existe.");
		} else {
			try {
				objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(exp)));

				while ((thisContacto = (Contacto) objectInputStream.readObject()) != null) {
					contactos.add(thisContacto);
				}
			} catch (EOFException ignored) {
				System.out.println("Importando contactos desde " + exp + "...");
				return contactos.toArray(new Contacto[0]);
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
		return null;
	}

	/** Separa el {@link String} en líneas, lee las líneas de dos en dos y crea {@link Contacto} con los datos. */
	private static void importarDatos(Agenda agenda, Contacto[] contactos) {
		if (contactos != null) {
			for (Contacto contacto : contactos) {
				agenda.add(contacto);
			}
		}
	}
}