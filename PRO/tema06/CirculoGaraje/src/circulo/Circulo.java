package circulo;

/**
 * @author Victor Piles
 * @since 31/01/2022 13:00
 */
public class Circulo {

	private Punto centro;
	private double radio;

	public Circulo() {
		this.centro = new Punto();
		radio = 10f;
	}

	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}

	public Circulo(double xPunto, double yPunto, double radio) {
		this.centro = new Punto(xPunto, yPunto);
		this.radio = radio;
	}

	public Punto getCentro() {
		return centro;
	}

	public double getRadio() {
		return radio;
	}

	/**
	 * La distancia entre el punto y la circunferencia se calcula como la distancia entre el {@link Punto} y el {@link
	 * Circulo#centro} de la circunferencia, calculado en {@link Punto#getDistanciaDesde(Punto)} menos el {@link
	 * Circulo#radio}
	 */
	public double getDistanciaDesde(Punto otroP) {

		return centro.getDistanciaDesde(otroP) - radio;
	}

	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
	}

	public double getPerimetro() {
		return Math.PI * radio * 2;
	}
}
