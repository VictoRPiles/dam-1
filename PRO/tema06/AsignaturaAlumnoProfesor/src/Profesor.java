/**
 * @author Victor Piles
 * @since 14/02/2022 14:11
 */
public class Profesor {

	public void ponerNotas(Alumno alumno) {
		for (int i = 0; i < alumno.getAsignaturas().length; i++) {
			alumno.getAsignaturas()[i].setCalificacion(Math.random() * 10);
			System.out.printf("Nota asignatura %d -> %.2f\n", i + 1, alumno.getAsignaturas()[i].getCalificacion());
		}
	}

	public Double calcularMedia(Alumno alumno) {
		double media = 0;

		for (int i = 0; i < alumno.getAsignaturas().length; i++) {
			media += alumno.getAsignaturas()[i].getCalificacion();
		}

		return (media / alumno.getAsignaturas().length);
	}
}
