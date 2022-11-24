/**
 * @author Victor Piles
 * @since 14/02/2022 14:15
 */
public class Main {

	public static void main(String[] args) {
		Asignatura a1 = new Asignatura(1);
		Asignatura a2 = new Asignatura(2);
		Asignatura a3 = new Asignatura(3);

		Alumno alumno = new Alumno(a1, a2, a3);

		Profesor profesor = new Profesor();

		profesor.ponerNotas(alumno);
		System.out.printf("Media -> %.2f\n", profesor.calcularMedia(alumno));
	}
}
