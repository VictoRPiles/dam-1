import java.util.*;

public class Ventanilla {
	private static int contadorCoches = 0;
	private Ventanillas denominacion;
	private LinkedList<Vehiculo> colaVehiculos = new LinkedList<>();
	private static LinkedList<Vehiculo> colaGeneral = new LinkedList<>();

	public Ventanilla(Ventanillas denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * Añade un {@link Vehiculo} a {@link #colaVehiculos} de la ventanilla correspondiente y a {@link #colaGeneral}.
	 * Incrementa {@link #contadorCoches}.
	 */
	public void add(Vehiculo v) {
		colaVehiculos.add(v);
		colaGeneral.add(v);

		if (v instanceof Coche) contadorCoches++;
	}

	public void remove() {
		colaVehiculos.removeFirst();
	}

	public Vehiculo getFirst() {
		return colaVehiculos.getFirst();
	}

	/** @return Cantidad de {@link Vehiculo} instanciados como {@link Coche} que han entrado a la autovía. */
	public static int getContadorCoches() {
		return contadorCoches;
	}

	/**
	 * Ordena una copia de la lista {@link #colaGeneral}.
	 * {@link Collections#sort(List)} utilizará el método {@link Vehiculo#compareTo(Vehiculo)}.
	 *
	 * @return Cola de todos los vehículos ordenada.
	 */
	public static LinkedList<Vehiculo> ordenarVehiculos() {
		LinkedList<Vehiculo> colaOrdenada = (LinkedList<Vehiculo>) colaGeneral.clone();

		Collections.sort(colaOrdenada);

		return colaOrdenada;
	}

	@Override
	public String toString() {
		return "Ventanilla{" +
				"denominacion=" + denominacion +
				'}';
	}
}