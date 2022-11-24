/**
 * @author Victor Piles
 * @since 14/02/2022 14:08
 */
public class Alumno {

	private Asignatura[] asignaturas;

	public Alumno(Asignatura a1, Asignatura a2, Asignatura a3) {
		this.asignaturas = new Asignatura[]{a1, a2, a3};
	}

	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}
}
