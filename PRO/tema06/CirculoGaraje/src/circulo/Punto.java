package circulo;

/**
 * @author Victor Piles
 * @since 31/01/2022 13:01
 */
public class Punto {

	private double x, y;

	public Punto() {
		this.x = 0;
		this.y = 0;
	}

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/**
	 * @return La distancia hasta otro {@link Punto}
	 */
	public double getDistanciaDesde(Punto otroP) {

		return Math.sqrt(Math.pow((this.getX() - otroP.getX()), 2) + Math.pow((this.getY() - otroP.getY()), 2));
	}
}
