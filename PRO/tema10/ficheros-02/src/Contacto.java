/**
 * @author Victor
 * @since 02/05/2022 - 14:13
 */
public class Contacto {
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
			return this.nombre.equals(((Contacto) obj).nombre) && this.telefono.equals(((Contacto) obj).telefono);
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
}