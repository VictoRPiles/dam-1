import java.util.HashSet;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public class Cliente extends Persona {
	private HashSet<Mascota> mascotas = new HashSet<>();

	public Cliente(String dni) {
		super(dni);
	}

	public Cliente(String dni, String nombre, String apellido) {
		super(dni, nombre, apellido);
	}

	public boolean addMascota(Mascota m) {
		return mascotas.add(m);
	}

	public boolean removeMascota(Mascota m) {
		return mascotas.remove(m);
	}

	public HashSet<Mascota> getMascotas() {
		return mascotas;
	}
}