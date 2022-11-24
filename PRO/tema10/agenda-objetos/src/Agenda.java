import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Victor
 * @since 06/05/2022 - 9:40
 */
public class Agenda {
	private ArrayList<Contacto> contactos = new ArrayList<>();

	/**
	 * Permite añadir contactos NO IGUALES a la agenda.
	 *
	 * @see Contacto#equals(Object)
	 */
	public boolean add(Contacto c) {
		for (Contacto contacto : contactos) {
			if (contacto.equalsConTelefono(c)) return false;
		}
		return contactos.add(c);
	}

	/** Borra todos los contactos con el nombre pasado por parámetro. */
	public boolean remove(String nombreContacto) {
		boolean seHaBorrado = false;
		Contacto thisContacto;
		Iterator<Contacto> it = contactos.iterator();

		while (it.hasNext()) {
			thisContacto = it.next();
			if (thisContacto.equals(new Contacto(nombreContacto, ""))) {
				it.remove();
				seHaBorrado = true;
			}
		}

		return seHaBorrado;
	}

	/** @return Un Array con todos los contactos que tienen el nombre pasado por parámetro. */
	public Contacto[] get(String nombreContacto) {
		ArrayList<Contacto> contactosEncontrados = new ArrayList<>();

		for (Contacto contacto : contactos) {
			if (contacto.getNombre().equals(nombreContacto)) contactosEncontrados.add(contacto);
		}

		return contactosEncontrados.toArray(new Contacto[0]);
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder();

		for (Contacto contacto : contactos) {
			toString.append(contacto).append("\n");
		}

		return toString.toString();
	}
}