import java.time.LocalDate;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public class Mamifero extends Mascota implements Vacunable {
	private LocalDate fechaVacunacion;
	private boolean vacunado;

	public Mamifero(int id, String nombre, LocalDate fechaVacunacion, boolean vacunado) {
		super(id, nombre);
		this.fechaVacunacion = fechaVacunacion;
		this.vacunado = vacunado;
	}

	public Mamifero(int id, String nombre, LocalDate fechaNacimiento, Especie especie, LocalDate fechaVacunacion,
					boolean vacunado) {
		super(id, nombre, fechaNacimiento, especie);
		this.fechaVacunacion = fechaVacunacion;
		this.vacunado = vacunado;
	}

	@Override
	public void vacunar() {
		fechaVacunacion = LocalDate.now();
		vacunado = true;
	}

	@Override
	public String toString() {
		return super.toString() +
				" Mamifero{" +
				"fechaVacunacion=" + fechaVacunacion +
				", vacunado=" + vacunado +
				"} ";
	}
}