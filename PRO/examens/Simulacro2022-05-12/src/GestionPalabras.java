import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Victor
 * @since 12/05/2022 - 11:25
 */
public abstract class GestionPalabras {
	static final String RUTA = "resources/palabras.txt";
	static TreeSet<String> palabras = new TreeSet<>();

	/** 1) Añadir palabra */
	public static boolean add(String palabra) {
		return palabras.add(palabra.toUpperCase());
	}

	/** 2) Listar palabra */
	public static void print() {
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
	}

	/** 3) Buscar palabra */
	public static boolean get(String palabra) {

		for (String s : palabras) {
			if (s.equalsIgnoreCase(palabra)) {
				return true;
			}
		}

		return false;
	}

	/** @return La palabra de la lista con el índice pasado por parámetro. */
	public static String getPalabraConIndex(int index) {
		Iterator<String> palabrasIte = palabras.iterator();

		if (index > palabras.size()) return null;

		for (int i = 0; i <= index; i++) {
			if (i == index) {
				return palabrasIte.next();
			}
			palabrasIte.next();
		}

		return null;
	}

	/** 4) Eliminar palabra */
	public static boolean remove(String palabra) {
		return palabras.remove(palabra.toUpperCase());
	}

	/** Carga los datos desde el fichero {@link #RUTA} */
	public static Boolean load() {
		BufferedReader br = null;
		String palabra;
		try {
			br = new BufferedReader(new FileReader(RUTA));

			while ((palabra = br.readLine()) != null) {
				add(palabra);
			}

			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	/** Guarda las palabras en el fichero {@link #RUTA} */
	public static void save() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(RUTA));

			for (String palabra : palabras) {
				bw.write(palabra + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
					System.out.printf("Guardando las palabras al fichero %s...\n", RUTA);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Permite escoger entre las opciones
	 *
	 * @return <ul>
	 * <li>true si la opción es válida y no se quiere salir.</li>
	 * <li>false si se quiere salir.</li>
	 * <li>menu() si la opción no es válida.</li>
	 * </ul>
	 */
	public static Boolean menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== GESTION DE PALABRAS =====");
		System.out.println("1) Añadir palabra");
		System.out.println("2) Listar palabras");
		System.out.println("3) Buscar palabra");
		System.out.println("4) Eliminar palabra");
		System.out.println("5) Guardar y salir");
		System.out.print("> ");
		switch (scanner.nextInt()) {
			case 1 -> {
				scanner.nextLine(); /* limpiar buffer */
				System.out.print("Introduce la palabra -> ");
				if (add(scanner.nextLine())) {
					System.out.println("Palabra añadida.");
				} else {
					System.out.println("Palabra repetida, no se añade.");
				}
			}
			case 2 -> print();
			case 3 -> {
				scanner.nextLine(); /* limpiar buffer */
				System.out.print("Introduce la palabra -> ");
				if (get(scanner.nextLine())) {
					System.out.println("La palabra existe en la lista");
				} else {
					System.out.println("La palabra no existe en la lista");
				}
			}
			case 4 -> {
				scanner.nextLine(); /* limpiar buffer */
				System.out.print("Introduce la palabra -> ");
				if (remove(scanner.nextLine())) {
					System.out.println("Palabra borrada.");
				} else {
					System.out.println("La palabra no existe en la lista");
				}
			}
			case 5 -> {
				save();
				System.out.println("Cerrando gestión de palabras...");
				return false;
			}
			default -> {
				System.out.println("Opción no valida.");
				return menu();
			}
		}
		return true;
	}

	public static TreeSet<String> getPalabras() {
		return palabras;
	}
}