/**
 * @author Victor Piles
 * @since 27/01/2022 11:16
 */
public class Main {

	public static void main(String[] args) {
		Bombilla bombilla = new Bombilla();

		System.out.println(bombilla);

		bombilla.setEsOnOffBombilla(); System.out.println(bombilla);

		Bombilla.setEsOnOffGeneral(); System.out.println(bombilla);
	}
}

