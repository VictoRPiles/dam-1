package v3;

/**
 * @author Victor Piles
 * @since 28/01/2022 9:22
 */
public class Calificacion {

	String nombre;
	private float[] notasAsign;

	public Calificacion(String nombre, float[] notasAsign) {
		this.nombre = nombre;
		this.notasAsign = notasAsign;
	}

	public float[] getNotasAsign() {
		return notasAsign;
	}

	/**
	 * Calcula la nota media de un Array de alumnos Si estos no tienen una nota definida (es decir {@link
	 * Alumno#getNotaFinal()} != de {@link Float#MIN_VALUE}) no se computan en la media
	 *
	 * @param alumnos
	 * 		Array de alumnos
	 */
	public static float getNotaMedia(Alumno[] alumnos) {
		double notas = 0;
		int sinNota = 0;

		for (Alumno alumno : alumnos) {
			if (alumno.getNotaFinal() != Float.MIN_VALUE) notas += alumno.getNotaFinal();
			else sinNota++;
		}

		return (float) (notas / (alumnos.length - sinNota));
	}

	/**
	 * Calcula la {@link Alumno#getNotaFinal()} realizando la media de {@link #notasAsign} Si {@link #notasAsign}[i] ==
	 * {@link Float#MIN_VALUE} significa que la nota no está definida y no se computa
	 */
	public float calcularNotaFinal() {
		int contador = 0;
		float notaFinal = 0;

		for (int i = 0; i < notasAsign.length; i++) {
			if (notasAsign[i] > Float.MIN_VALUE) {
				notaFinal += notasAsign[i];
				contador++;
			}
		}
		return (notaFinal / contador);
	}
}
