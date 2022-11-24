package control;

import java.util.LinkedList;

public class Pila implements PilaColaInterface {
	private LinkedList<Object> pila = new LinkedList<>();

	/**
	 * Añade el objeto a la lista.
	 *
	 * @return Si la operación se ha completado con éxito.
	 */
	@Override
	public boolean meter(Object o) {
		try {
			pila.add(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Borra el elemento que devuelve (LIFO).
	 *
	 * @return El último elemento de la lista.
	 */
	@Override
	public Object sacar() {
		try {
			return pila.getLast();
		} finally {
			pila.removeLast();
		}
	}

	/**
	 * @return {@link LinkedList#size()}.
	 */
	@Override
	public int tamanyo() {
		return pila.size();
	}

	@Override
	public String toString() {
		StringBuilder elementos = new StringBuilder();

		for (Object o : pila) {
			elementos.append(o).append("\n");
		}

		return elementos.toString();
	}
}