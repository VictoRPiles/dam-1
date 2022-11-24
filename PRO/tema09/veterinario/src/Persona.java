import java.util.HashSet;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public abstract class Persona {
	private static HashSet<String> listaDni = new HashSet<>();
	private final String dni;
	private String nombre;
	private String apellido;

	public Persona(String dni) {
		this.dni = validarDni(dni);
	}

	public Persona(String dni, String nombre, String apellido) {
		this.dni = validarDni(dni);
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String validarDni(String dni) {
		if (listaDni.add(dni)) {
			return dni;
		} else {
			throw new IllegalArgumentException("ERROR: Otra persona tiene el DNI " + dni);
		}
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Persona{" +
				"dni='" + dni + '\'' +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				'}';
	}
}