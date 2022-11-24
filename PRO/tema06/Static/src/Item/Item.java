package Item;

import java.util.ArrayList;

/**
 * @author Victor Piles
 * @since 21/01/2022 8:20
 */
public class Item {
	private String nombre;
	private int id;
	private static ArrayList<Item> instancias = new ArrayList<>();
	private static int contador = 0;

	public Item(String nombre) {

		this.nombre = nombre;
		this.id = ++contador;
		instancias.add(this);
	}

	public String getNombre() {

		return nombre;
	}

	public int getId() {

		return id;
	}

	public static int getContador() {

		return contador;
	}

	public static ArrayList<Item> getInstancias() {

		return instancias;
	}

	@Override
	public String toString() {

		String nom = this.getNombre();
		int id = this.getId();

		return String.format("Elemento -> %-8s ID -> %d", nom, id);
	}
}
