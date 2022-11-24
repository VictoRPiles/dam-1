package coche;

/**
 * @author Victor Piles
 * @since 14/01/2022 8:05
 */
public class CocheApp {
	public static void main(String[] args) {

		Coche coche1 = new Coche("Fiesta", "Rojo", "112233BBB", 2019, true);
		Coche coche2 = new Coche("Focus", "Azul", "000000DNS", 2021, false);

		coche1.imprimeCoche();
		coche2.imprimeCoche();

	}
}
