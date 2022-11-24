package mercado;

public class Producto implements Comparable<Producto> {
	private String nombre;
	private int cantidad;

	public Producto(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Producto o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return "Producto{" +
				"nombre='" + nombre + '\'' +
				", cantidad=" + cantidad +
				'}';
	}
}