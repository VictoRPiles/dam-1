package v1;

/**
 * @author Victor Piles
 * @since 27/01/2022 11:59
 */
public class Main {

	public static void main(String[] args) {
		Alumno[] alumnos = new Alumno[5];

		alumnos[0] = new Alumno("Nombre #0", "Apellido #0");

		for (int i = 1; i < alumnos.length; i++) {
			alumnos[i] = new Alumno(String.format("Nombre #%d", i), String.format("Apellido #%d", i), (float) (Math.random() * 10));
		}

		System.out.printf("%s\n", Alumno.getIntoAlumnos(alumnos));
		System.out.printf("%s\n", Alumno.mayorQueNotaMedia(alumnos));
	}
}
