package punto;

/**
 * @author Victor Piles
 * @since 14/01/2022 8:55
 */
public class PuntoApp {

	public static void main(String[] args) {

		Punto punto1 = new Punto();
		Punto punto2 = new Punto(5, 3);
		Punto punto3 = new Punto(2, -1);
		Punto punto4 = new Punto(
				Punto.getPuntoIntermedio(punto2, punto3)[0],
				Punto.getPuntoIntermedio(punto2, punto3)[1]
		);
		Punto punto5 = new Punto(4, 3);

		System.out.println(punto1);
		System.out.println(punto2);
		System.out.println(punto3);
		System.out.println(punto4);

		System.out.println(Punto.getDistancia(punto5));
	}
}
