package mercado;

import java.util.Iterator;
import java.util.TreeSet;

public class Mercado {
	private TreeSet<Producto> productos = new TreeSet<>();

	public void add(Producto o) {
		if (!productos.add(o)) try {
			throw new MismoProductoException("ERROR: Ya existe el producto " + o.getNombre());
		} catch (MismoProductoException e) {
			System.out.println(e.getMessage());
		}
	}

	public void remove(Producto o) {
		productos.remove(o);
	}

	@Override
	public String toString() {
		Iterator<Producto> i = productos.iterator();
		StringBuilder info = new StringBuilder("Producto {\n");

		while (i.hasNext()) {
			info.append("\t").append(i.next().toString()).append("\n");
		}

		return info.toString() + '}';
	}
}