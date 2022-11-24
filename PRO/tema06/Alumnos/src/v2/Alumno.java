package v2;

/**
 * @author Victor Piles
 * @since 28/01/2022 8:24
 */
public class Alumno {

	private final String nombre, apellido;
	private float notaFinal = Float.MIN_VALUE; /* Valor para nota no definida */
	private float[] notasAsign = {Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE};

	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Alumno(String nombre, String apellido, float[] notasAsign) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.notasAsign = notasAsign;
		this.notaFinal = calcularNotaFinal(notasAsign);
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

	public float[] getNotasAsign() {
		return notasAsign;
	}

	public void setNotasAsign(float[] notasAsign) {
		this.notasAsign = notasAsign;
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

	/**
	 * Calcula la {@link #notaFinal} realizando la media de {@link #notasAsign} Si {@link #notasAsign}[i] == {@link
	 * Float#MIN_VALUE} significa que la nota no está definida y no se computa
	 */
	public float calcularNotaFinal(float[] notasAsign) {
		int contador = 0;

		for (int i = 0; i < notasAsign.length; i++) {
			if (notasAsign[i] > Float.MIN_VALUE) {
				notaFinal += notasAsign[i];
				contador++;
			}
		}
		return (notaFinal / contador);
	}

	@Override
	public String toString() {
		return String.format("Nombre: %10s\t|\tApellido: %10s\t|\tNota Final: %02.2f", nombre, apellido, notaFinal);
	}
}
