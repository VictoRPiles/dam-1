import java.io.Serializable;

/**
 * @author Victor
 * @since 06/05/2022 - 9:41
 */
public class Contacto implements Serializable {
	private final String nombre;
	private final String telefono;

	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contacto) {
			return this.nombre.equals(((Contacto) obj).nombre);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Contacto{" +
				"nombre='" + nombre + '\'' +
				", telefono=" + telefono +
				'}';
	}

	public boolean equalsConTelefono(Object obj) {
		if (obj instanceof Contacto) {
			return this.nombre.equals(((Contacto) obj).nombre) && this.telefono.equals(((Contacto) obj).telefono);
		}
		return false;
	}
}