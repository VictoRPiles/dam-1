package garaje;

/**
 * @author Victor Piles
 * @since 31/01/2022 13:38
 */
public class Coche {

	private Motor motor;
	private final String marca, modelo;
	private double precioAverias;

	public Coche(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		motor = new Motor((int) ((Math.random() + 1) * 100));
	}

	public Motor getMotor() {
		return motor;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPrecioAverias() {
		return precioAverias;
	}

	/**
	 * Incrementa el dinero gastado en averías
	 *
	 * @see Garaje#checkAveriaAsociada(String)
	 */
	public void acumularAveria(double gasto) {
		this.precioAverias += gasto;
	}

	@Override
	public String toString() {
		return String.format("Coche: %4s %5s\tPrecio Averias: %.2f\tAceite Motor: %d\n",
				marca, modelo, precioAverias, motor.getLitrosAceite());
	}
}
