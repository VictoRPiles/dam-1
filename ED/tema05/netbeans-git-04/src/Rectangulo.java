/**
 * @author Victor
 * @since 09/05/2022 - 9:42
 */
public class Rectangulo extends Figura {
	private float base;
	private float altura;

	public Rectangulo(float base, float altura) {
		this.base = base;
		this.altura = altura;
		calcularArea();
		calcularPerimetro();
	}

	@Override
	public void calcularArea() {
		this.area = base * altura;
	}

	@Override
	public void calcularPerimetro() {
		this.area = 2 * (base + altura);
	}
}