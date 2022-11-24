public abstract class Figura {
	protected float area;
	protected float perimetro;

	public abstract void calcularArea();

	public abstract void calcularPerimetro();

	public float getArea() {
		return area;
	}

	public float getPerimetro() {
		return perimetro;
	}
}