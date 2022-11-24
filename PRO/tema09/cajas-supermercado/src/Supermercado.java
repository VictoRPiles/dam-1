import java.util.LinkedList;
import java.util.TreeSet;

public class Supermercado {
	private LinkedList<Cliente> clientes = new LinkedList<>();
	private TreeSet<Producto> productos = new TreeSet<>();
	private Caja caja1, caja2;

	public Supermercado(Caja caja1, Caja caja2) {
		this.caja1 = caja1;
		this.caja2 = caja2;
	}

	/**
	 * Añade el {@link Producto} p a {@link #productos}.
	 * <p>
	 * Si no se puede añadir, lanza {@link MismoProductoException} y la maneja.
	 */
	public void addProducto(Producto p) {
		if (!productos.add(p)) try {
			throw new MismoProductoException("ERROR: El producto " + p.getNombre() + " ya existe");
		} catch (MismoProductoException e) {
			System.out.println(e.getMessage());
		}
	}
}