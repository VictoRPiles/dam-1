import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Victor
 * @since 06/05/2022 - 13:31
 */
public class Perro extends Mascota implements Vacunable, Serializable {
	private boolean vacunado;
	private LocalDate fechaVacunacion;

	public Perro(String ID, String nombre) {
		super(ID, nombre);
	}

	public Perro(String ID, String nombre, Especie especie, boolean vacunado, LocalDate fechaVacunacion) {
		super(ID, nombre, especie);
		this.vacunado = vacunado;
		this.fechaVacunacion = fechaVacunacion;
	}

	public boolean isVacunado() {
		return vacunado;
	}

	@Override
	public void vacunar() {
		vacunado = true;
		fechaVacunacion = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Perro{" +
				"ID=" + ID +
				", nombre=" + nombre +
				", vacunado=" + vacunado +
				", fechaVacunacion=" + fechaVacunacion +
				'}';
	}
}