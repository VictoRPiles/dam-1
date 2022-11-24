package documentacion;

/**
 * Clase que representa un circulo.
 *
 * @author Victor
 * @version 16/05/2022 - 9:16
 */
public class Circulo {

	private double centroX;
	private double centroY;
	private double radio;

	/**
	 * Círculo con radio y centro en el eje X e Y definido.
	 *
	 * @param x Centro en el eje X.
	 * @param y Centro en el eje Y.
	 * @param r Valor del radio.
	 */
	public Circulo(double x, double y, double r) {
		centroX = x;
		centroY = y;
		radio = r;
	}

	/**
	 * Devuelve el centro del círculo en el eje X.
	 *
	 * @return {@link #centroX}.
	 */
	public double getCentroX() {
		return centroX;
	}

	/**
	 * Devuelve el perímetro del círulo.
	 *
	 * @return Valor del perímetro (2 * PI * radio).
	 */
	public double getPerimetro() {
		return 2 * Math.PI * radio;
	}

	/**
	 * Desplaza el centro en el eje X e Y.
	 *
	 * @param despX Valor del desplazamiento en el eje X.
	 * @param despY Valor del desplazamiento en el eje Y.
	 */
	public void mueve(double despX, double despY) {
		centroX = centroX + despX;
		centroY = centroY + despY;
	}
}