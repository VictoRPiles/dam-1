public class Circulo extends Figura {

	private double radio;

	public Circulo(Color color, double[] posicion, double radio) {
		super(color, posicion);
		this.radio = radio;
	}

	public Circulo(double[] posicion, double radio) {
		super(posicion);
		this.radio = radio;
	}

	@Override
	public double getArea() {
		return Math.PI * radio * radio;
	}

	@Override
	public double getPerimetro() {
		return 2 * Math.PI * radio;
	}

	@Override
	public String toString() {
		return "Circulo{" +
				"radio=" + radio +
				"} " + super.toString();
	}
}