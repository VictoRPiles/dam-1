import java.time.LocalDate;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public class Perro extends Mamifero {
	public Perro(int id, String nombre, LocalDate fechaVacunacion, boolean vacunado) {
		super(id, nombre, fechaVacunacion, vacunado);
	}

	public Perro(int id, String nombre, LocalDate fechaNacimiento, Especie especie, LocalDate fechaVacunacion,
				 boolean vacunado) {
		super(id, nombre, fechaNacimiento, especie, fechaVacunacion, vacunado);
	}
}