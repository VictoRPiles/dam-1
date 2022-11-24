/**
 * @author Victor Piles
 * @since 03/02/2022 11:04
 */
public class Alumno {

	private static int id = 0;
	private final int idAlumno;
	private int votos = 0;
	private boolean haVotado = false;
	private boolean delegado = false;

	public Alumno() {
		this.idAlumno = id++;
	}

	/**
	 * Añade un voto al alumno con {@link #idAlumno} == idVotado
	 * <p>
	 * Si este alumno ya ha votado o si se vota a él mismo, muestra un mensaje y no añade votos a nadie
	 */
	public void votar(Escuela escuela, int idVotado) {
		if (!haVotado) {
			haVotado = true;

			if (!(this.idAlumno == idVotado)) {
				for (int i = 0; i < escuela.getGrupo().length; i++) {
					if (escuela.getGrupo()[i].getIdAlumno() == idVotado) {
						escuela.getGrupo()[i].masVoto();
					}
				}
			} else System.out.println("NO TE PUEDES VOTAR A TI MISMO, VOTO NULO");
		} else System.out.println("ESTE ALUMNO YA HA VOTADO");
	}

	/**
	 * Cuando es llamado añade un voto al alumno
	 *
	 * @see #votar(Escuela, int)
	 */
	public void masVoto() {
		this.votos++;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public void setDelegado(boolean delegado) {
		this.delegado = delegado;
	}

	public boolean isDelegado() {
		return delegado;
	}

	@Override
	public String toString() {
		return String.format("Alumno -> %d", idAlumno + 1);
	}
}
