import java.time.LocalDate;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public class Pez extends Mascota {
	public Pez(int id, String nombre) {
		super(id, nombre);
	}

	public Pez(int id, String nombre, LocalDate fechaNacimiento, Especie especie) {
		super(id, nombre, fechaNacimiento, especie);
	}
}