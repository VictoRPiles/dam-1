public class Contacto {
	private final String nombre;
	private int telefono;

	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Contacto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	@Override
	public boolean equals(Object obj) {
		return this.nombre.equals(((Contacto) obj).getNombre());
	}

	@Override
	public String toString() {
		return "Contacto{" +
				"nombre='" + nombre + '\'' +
				", telefono=" + telefono +
				'}';
	}
}