/**
 * @author Victor Piles
 * @since 14/02/2022 14:05
 */
public class Asignatura {

	private int id;
	private double calificacion;

	public Asignatura(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
}
