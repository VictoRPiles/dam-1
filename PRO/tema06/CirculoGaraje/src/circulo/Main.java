package circulo;

/**
 * @author Victor Piles
 * @since 31/01/2022 13:19
 */
public class Main {

	public static void main(String[] args) {
		Punto p1 = new Punto();
		Punto p2 = new Punto(20, 5);
		System.out.printf("Distancia entre p1 (X:%.2f Y:%.2f) y p2 (X:%.2f Y:%.2f): %.2f\n",
				p1.getX(), p1.getY(), p2.getX(), p2.getY(), p1.getDistanciaDesde(p2));

		Circulo c1 = new Circulo(p1, 12);
		System.out.printf("Area de c1: %.2f\n", c1.getArea());
		System.out.printf("Perimetro de c1: %.2f\n", c1.getPerimetro());
		System.out.printf("Distancia entre c1 (X:%.2f Y:%.2f R:%.2f) y p2 (X:%.2f Y:%.2f): %.2f\n",
				c1.getCentro().getX(), c1.getCentro().getX(), c1.getRadio(), p2.getX(), p2.getY(), c1.getDistanciaDesde(p2));
	}
}