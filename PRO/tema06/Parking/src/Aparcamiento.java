/**
 * @author Victor Piles
 * @since 28/01/2022 9:39
 */
public class Aparcamiento {

	private int capacidad;
	private int ocupados = 0;

	public Aparcamiento(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupados() {
		return ocupados;
	}

	public void setOcupados(int ocupados) {
		this.ocupados = ocupados;
	}

	public void aparcarCoche() {
		ocupados++;
	}

	public void sacarCoche() {
		ocupados--;
	}

	public boolean hayHuecos() {
		return capacidad > ocupados;
	}

	public boolean hayCoches() {
		return ocupados > 0;
	}

	@Override
	public String toString() {
		return String.format("En el parking hay %02d plazas ; %02d coches ; %02d huecos", capacidad, ocupados, (capacidad - ocupados));
	}
}
