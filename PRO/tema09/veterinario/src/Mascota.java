import java.time.LocalDate;
import java.util.TreeSet;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public abstract class Mascota {
	private static TreeSet<Integer> listaId = new TreeSet<>();
	private final int id;
	private final String nombre;
	private LocalDate fechaNacimiento;
	private Especie especie;

	public Mascota(int id, String nombre) {
		this.id = validarId(id);
		this.nombre = nombre;
	}

	public Mascota(int id, String nombre, LocalDate fechaNacimiento, Especie especie) {
		this.id = validarId(id);
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.especie = especie;
	}

	public int validarId(int id) {
		if (listaId.add(id)) {
			return id;
		}

		System.out.printf("WARNING: Otra mascota tiene el Id %d, se asigna %d.\n", id, listaId.last() + 1);
		return validarId(getNextId());
	}

	public int getNextId() {
		return listaId.last() + 1;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Mascota{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", fechaNacimiento=" + fechaNacimiento +
				", especie=" + especie +
				'}';
	}
}