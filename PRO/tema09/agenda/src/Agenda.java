import java.util.ArrayList;

public class Agenda {
	private static ArrayList<Contacto> contactos = new ArrayList<>();

	/** Valida que el contacto no existe y lo añade a la lista */
	public static void add(Contacto contacto) {
		if (get(contacto.getNombre()) == null) contactos.add(contacto);
		else System.out.println("Ya hay un contacto con este nombre, no se añade.");
	}

	/** Valida que el contacto está en la lista y lo borra */
	public static void remove(Contacto contacto) {
		if (contactos.contains(contacto)) contactos.remove(contacto);
		else System.out.println("No se puede borrar este contacto, no existe.");
	}

	/**
	 * Busca en la lista el contacto con el nombre pasado por parámetro.
	 *
	 * @return Contacto si lo encuentra, null si no lo encuentra
	 */
	public static Contacto get(String nombre) {
		for (Contacto contacto : contactos) {
			if (contacto.equals(new Contacto(nombre))) return contacto;
		}

		return null;
	}

	/**
	 * Imprime los datos de la lista.
	 *
	 * @see Contacto#toString()
	 */
	public static void print() {
		System.out.println(contactos);
	}
}