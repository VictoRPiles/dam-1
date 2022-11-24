import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Victor
 * @since 06/05/2022 - 10:34
 */
public class Cliente extends Persona implements Serializable {
	private ArrayList<Mascota> mascotas = new ArrayList<>();

	public Cliente(String dni, String nombre) {
		super(dni, nombre);
	}

	public Cliente(String dni, String nombre, ArrayList<Mascota> mascotas) {
		super(dni, nombre);
		this.mascotas = mascotas;
	}

	public boolean addMascota(Mascota m) {
		boolean existe = false;
		for (Mascota mascota : mascotas) {
			if (mascota.equals(m)) {
				existe = true;
				break;
			}
		}

		if (!existe) mascotas.add(m);

		return !existe;
	}

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Cliente)
			return DNI.equals(((Cliente) obj).DNI);

		return false;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"DNI='" + DNI + '\'' +
				", nombre='" + nombre + '\'' +
				'}';
	}
}