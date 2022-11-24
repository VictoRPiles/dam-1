public class Producto implements Comparable<Producto> {
	private String nombre;
	private float precio;

	public Producto(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Producto o) {
		return nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return "Producto{" +
				"nombre='" + nombre + '\'' +
				", precio=" + precio +
				'}';
	}
}