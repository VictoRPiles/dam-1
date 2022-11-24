package v3;

/**
 * @author Victor Piles
 * @since 28/01/2022 9:23
 */
public class Main {

	public static void main(String[] args) {
		Alumno[] alumnos = new Alumno[5];

		alumnos[0] = new Alumno("Nombre #0", "Apellido #0");

		for (int i = 1; i < alumnos.length; i++) {
			float[] notas = new float[3];

			for (int j = 0; j < notas.length; j++) {
				notas[j] = (float) (Math.random() * 10);
			}

			Calificacion calificacion = new Calificacion(String.format("Calificación #%d", i), notas);
			alumnos[i] = new Alumno(String.format("Nombre #%d", i), String.format("Apellido #%d", i), calificacion);
		}

		System.out.printf("%s\n", Alumno.getIntoAlumnos(alumnos));
		System.out.printf("%s\n", Alumno.mayorQueNotaMedia(alumnos));
	}
}
