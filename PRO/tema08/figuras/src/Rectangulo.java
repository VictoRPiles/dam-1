public class Rectangulo extends Figura {
	private double base, altura;

	public Rectangulo(Color color, double[] posicion, double base, double altura) {
		super(color, posicion);
		this.base = base;
		this.altura = altura;
	}

	public Rectangulo(double[] posicion, double base, double altura) {
		super(posicion);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double getArea() {
		return base * altura;
	}

	@Override
	public double getPerimetro() {
		return 2 * (base + altura);
	}

	@Override
	public String toString() {
		return "Rectangulo{" +
				"base=" + base +
				", altura=" + altura +
				"} " + super.toString();
	}
}
