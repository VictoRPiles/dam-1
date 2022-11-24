import java.util.HashSet;
import java.util.LinkedList;

public class Cliente {
	private final String nombre;
	private final String apellido;
	private String dni;
	static HashSet<String> listaDNIs = new HashSet<>();
	private float vale;
	static LinkedList<Producto> cesta = new LinkedList<>();

	public Cliente(String nombre, String apellido, String dni, float vale) {
		this.nombre = nombre;
		this.apellido = apellido;
		if (listaDNIs.add(dni)) {
			this.dni = dni;
		} else {System.out.println("El DNI ya existe");}
		this.vale = vale;

	}

	@Override
	public String toString() {
		return "Cliente{" +
				"nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", dni='" + dni + '\'' +
				", vale=" + vale +
				'}';
	}

}