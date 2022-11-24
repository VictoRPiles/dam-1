import java.util.ArrayList;

public class Compra {
	private float importe = 0f;
	private ArrayList<Producto> productos = new ArrayList<>();

	public void add(Producto p) {
		productos.add(p);
		importe += p.getPrecio();
	}

	public void remove(Producto p) {
		productos.remove(p);
	}

	public float getImporte() {
		return importe;
	}
}