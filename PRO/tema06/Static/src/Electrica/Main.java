package Electrica;

/**
 * @author Victor Piles
 * @since 21/01/2022 9:00
 */
public class Main {

	public static void main(String[] args) {
		Aparato bombilla = new Aparato(100);
		Aparato radiador = new Aparato(1200);
		Aparato plancha = new Aparato(2000);

		System.out.println(Aparato.toStringAparato());

		bombilla.setEsOnOff(true);
		plancha.setEsOnOff(true);

		System.out.println(Aparato.toStringAparato());

		plancha.setEsOnOff(false);
		radiador.setEsOnOff(true);

		System.out.println(Aparato.toStringAparato());

		plancha.setEsOnOff(true);

		System.out.println(Aparato.toStringAparato());
	}
}
