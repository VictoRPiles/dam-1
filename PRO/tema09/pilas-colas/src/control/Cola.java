package control;

import java.util.LinkedList;

public class Cola implements PilaColaInterface {
	private LinkedList<Object> cola = new LinkedList<>();

	/**
	 * Añade el objeto a la lista.
	 *
	 * @return Si la operación se ha completado con éxito.
	 */
	@Override
	public boolean meter(Object o) {
		try {
			cola.add(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Borra el elemento que devuelve.
	 *
	 * @return El primer elemento de la lista (FIFO).
	 */
	@Override
	public Object sacar() {
		try {
			return cola.getFirst();
		} finally {
			cola.removeFirst();
		}
	}

	/**
	 * @return {@link LinkedList#size()}.
	 */
	@Override
	public int tamanyo() {
		return cola.size();
	}

	@Override
	public String toString() {
		StringBuilder elementos = new StringBuilder();

		for (Object o : cola) {
			elementos.append(o).append("\n");
		}

		return elementos.toString();
	}
}