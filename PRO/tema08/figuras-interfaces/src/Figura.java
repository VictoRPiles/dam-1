import java.util.Arrays;

public abstract class Figura implements Comparable {
	private Color color = Color.NEGRO;
	private double[] posicion = {0, 0};

	public Figura(Color color, double[] posicion) {
		this.color = color;
		this.posicion = posicion;
	}

	public Figura(double[] posicion) {
		this.posicion = posicion;
	}

	public abstract double getArea();

	public abstract double getPerimetro();

	public boolean menorQue(Figura f) {
		return this.getArea() < f.getArea();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double[] getPosicion() {
		return posicion;
	}

	public void setPosicion(double[] posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Figura{" +
				"color=" + color +
				", posicion=" + Arrays.toString(posicion) +
				'}';
	}

	@Override
	public int compareTo(Object o) {
		if (this.getArea() < ((Figura) o).getArea()) return -1;
		if (this.getArea() == ((Figura) o).getArea()) return 0;

		return 1;
	}
}