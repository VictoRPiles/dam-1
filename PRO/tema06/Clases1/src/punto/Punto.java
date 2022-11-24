package punto;

/**
 * @author Victor Piles
 * @since 14/01/2022 8:55
 */
public class Punto {

	private int x, y;

	public Punto() {

	}

	public Punto(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public void setCoordenadas(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public void setX(int x) {

		this.x = x;
	}

	public int getX() {

		return x;
	}

	public void setY(int y) {

		this.y = y;
	}

	public int getY() {

		return y;
	}

	/**
	 * @return La distancia al origen [0,0]
	 */
	public static double getDistancia(Punto p1) {

		Punto p2 = new Punto();

		return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
	}

	/**
	 * @return La distancia hasta otro punto
	 */
	public static double getDistancia(Punto p1, Punto p2) {

		return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
	}

	/**
	 * Hay que tener en cuenta que el resultado no es preciso, ya que estamos trabajando con números enteros
	 *
	 * @return El punto intermedio entre dos puntos
	 */
	public static int[] getPuntoIntermedio(Punto p1, Punto p2) {

		int coordenadas[] = new int[2];

		coordenadas[0] = (p1.getX() + p2.getX()) / 2;
		coordenadas[1] = (p1.getY() + p2.getY()) / 2;

		return coordenadas;
	}

	@Override
	public String toString() {

		String info = String.format("(%2d,%2d )", x, y);

		return info;
	}
}
