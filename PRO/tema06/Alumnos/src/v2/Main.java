package v2;

/**
 * @author Victor Piles
 * @since 28/01/2022 8:24
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

			alumnos[i] = new Alumno(String.format("Nombre #%d", i), String.format("Apellido #%d", i), notas);
		}

		System.out.printf("%s\n", Alumno.getIntoAlumnos(alumnos));
		System.out.printf("%s\n", Alumno.mayorQueNotaMedia(alumnos));
	}
}
