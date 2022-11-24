package Elemento;

/**
 * @author Victor Piles
 * @since 21/01/2022 8:17
 */
public class Main {
	public static void main(String[] args) {

		Elemento e1 = new Elemento("E1");
		Elemento e2 = new Elemento("E2");
		Elemento e3 = new Elemento("E3");

		System.out.println(Elemento.getNumElem());

		Elemento e4 = new Elemento("E4");
		Elemento e5 = new Elemento("E5");

		System.out.println(Elemento.getNumElem());
	}
}
