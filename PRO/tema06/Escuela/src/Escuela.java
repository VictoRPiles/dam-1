import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Victor Piles
 * @since 03/02/2022 11:04
 */
public class Escuela {

	private Alumno[] grupo;

	public Escuela(Alumno[] grupo) {
		this.grupo = grupo;
	}

	public Alumno[] getGrupo() {
		return grupo;
	}

	/**
	 * Permite a cada alumno votar, llama a {@link #alumnoMasVotado()}
	 *
	 * @see Alumno#votar(Escuela, int)
	 */
	public void recuento() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Hay %d alumnos en el grupo\n", this.grupo.length);

		for (int i = 0; i < this.grupo.length; i++) {
			System.out.printf("Alumno %2d ¿A quien quieres votar?\n", i + 1);
			this.grupo[i].votar(this, scanner.nextInt() - 1);
		}

		alumnoMasVotado();
	}

	/**
	 * Asigna {@link Alumno#setDelegado(boolean)} = true a los alumnos con mayor numero de {@link Alumno#getVotos()}
	 */
	public void alumnoMasVotado() {
		int masVotos = Integer.MIN_VALUE;

		for (Alumno alumno : this.grupo) {
			if (alumno.getVotos() >= masVotos) {
				masVotos = alumno.getVotos();
			}
		}

		for (Alumno alumno : this.grupo) {
			if (alumno.getVotos() == masVotos) {
				alumno.setDelegado(true);
			}
		}
	}

	/**
	 * @return Una lista con los {@link Alumno} delegados
	 */
	public ArrayList<Alumno> getDelegados() {
		ArrayList<Alumno> delegados = new ArrayList<>();

		for (Alumno alumno : this.grupo) {
			if (alumno.isDelegado()) delegados.add(alumno);
		}

		if (delegados.size() > 1) {
			System.out.println("HAY UN EMPATE");
		}

		return delegados;
	}
}
