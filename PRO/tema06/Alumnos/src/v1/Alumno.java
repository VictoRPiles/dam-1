package v1;

/**
 * @author Victor Piles
 * @since 27/01/2022 11:56
 */
public class Alumno {

	private final String nombre, apellido;
	private float notaFinal = Float.MIN_VALUE; /* Valor para nota no definida */

	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Alumno(String nombre, String apellido, float notaFinal) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.notaFinal = notaFinal;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(float notaFinal) {
		this.notaFinal = notaFinal;
	}

	/**
	 * Calcula la nota media de un Array de alumnos Si estos no tienen una nota definida (es decir {@link #notaFinal} !=
	 * de {@link Float#MIN_VALUE}) no se computan en la media
	 *
	 * @param alumnos
	 * 		Array de alumnos
	 */
	public static float getNotaMedia(Alumno[] alumnos) {
		double notas = 0;
		int sinNota = 0;

		for (Alumno alumno : alumnos) {
			if (alumno.notaFinal != Float.MIN_VALUE) notas += alumno.getNotaFinal();
			else sinNota++;
		}

		return (float) (notas / (alumnos.length - sinNota));
	}

	/**
	 * Muestra la información de los alumnos de un Array Utiliza el método {@link #toString()}
	 *
	 * @param alumnos
	 * 		Array de alumnos
	 * @return {@link #toString()} de los alumnos concatenados y con saltos de línea
	 */
	public static String getIntoAlumnos(Alumno[] alumnos) {
		String infoAlumnos = "";

		for (Alumno alumno : alumnos) {
			infoAlumnos = infoAlumnos.concat(alumno.toString() + "\n");
		}

		return infoAlumnos;
	}

	/**
	 * Muestra {@link #toString()} de los alumnos con {@link #notaFinal} > {@link Alumno#getNotaMedia(Alumno[])} y la
	 * cantidad de estos que cumplen la condicion
	 *
	 * @param alumnos
	 * 		Array de alumnos
	 * @return Un mensaje con la cantidad de alumnos por encima de la media (no un entero)
	 */
	public static String mayorQueNotaMedia(Alumno[] alumnos) {
		int contador = 0;
		float media = getNotaMedia(alumnos);

		System.out.println("Alumnos por encima de la media");
		for (Alumno alumno : alumnos) {
			if (alumno.getNotaFinal() > media) {
				System.out.println(alumno);
				contador++;
			}
		}

		return String.format("Hay %d alumnos por encima de la media (%02.2f)", contador, media);
	}

	@Override
	public String toString() {
		return String.format("Nombre: %10s\t|\tApellido: %10s\t|\tNota Final: %02.2f", nombre, apellido, notaFinal);
	}
}
