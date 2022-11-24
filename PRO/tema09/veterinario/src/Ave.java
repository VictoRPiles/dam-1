import java.time.LocalDate;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public class Ave extends Mascota {
	private int numeroAnilla;

	public Ave(int id, String nombre, int numeroAnilla) {
		super(id, nombre);
		this.numeroAnilla = numeroAnilla;
	}

	public Ave(int id, String nombre, LocalDate fechaNacimiento, Especie especie, int numeroAnilla) {
		super(id, nombre, fechaNacimiento, especie);
		this.numeroAnilla = numeroAnilla;
	}
}