/**
 * @author Victor Piles
 * @since 24/02/2022 9:51
 */
public class Semaforo {

	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(int nEstado) {
		if (nEstado == 1) this.estado = Estado.ROJO;
		else if (nEstado == 2) this.estado = Estado.AMARILLO;
		else this.estado = Estado.VERDE;
	}

	@Override
	public String toString() {
		return String.format("El semáforo está en %s", estado);
	}
}
