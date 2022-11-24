/**
 * @author Victor
 * @version 1
 * @since 09/05/2022 - 8:43
 */
public class Circulo extends Figura {

	private float radio;

	public Circulo(float radio) {
		this.radio = radio;
		calcularArea();
		calcularPerimetro();
	}

	/** PI * r^2 */
	@Override
	public void calcularArea() {
		this.area = (float) (Math.PI * Math.pow(radio, 2));
	}

	/** 2 * PI * r */
	@Override
	public void calcularPerimetro() {
		this.perimetro = (float) (2 * Math.PI * radio);
	}

	@Override
	public String toString() {
		return "Circulo {" + "\n" +
				"\tradio=" + radio + "\n" +
				"\tarea=" + area + "\n" +
				"\tperimetro=" + perimetro + "\n" +
				'}';
	}
}