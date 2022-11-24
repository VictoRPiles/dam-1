package Elemento;

/**
 * @author Victor Piles
 * @since 21/01/2022 8:13
 */
public class Elemento {
	private String nombre;
	private static int numElem = 0;

	public Elemento(String nombre) {

		this.nombre = nombre;
		numElem++;
	}

	public static int getNumElem() {

		return numElem;
	}
}
