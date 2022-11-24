import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Pale elegirPale() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("1) ROBLE\n2) CAOBA\n3) NOGAL\n4) CEREZO\n5) BOJ\n6) Salir\n> ");

		switch (scanner.nextInt()) {
			case 1:
				return new Pale(Maderas.ROBLE);
			case 2:
				return new Pale(Maderas.CAOBA);
			case 3:
				return new Pale(Maderas.NOGAL);
			case 4:
				return new Pale(Maderas.CEREZO);
			case 5:
				return new Pale(Maderas.BOJ);
			case 6:
				return null;
			default:
				return elegirPale();
		}
	}

	public static void main(String[] args) {
		ArrayList<Pale> palesElegidos = new ArrayList<>();
		Pale pale;

		while ((pale = elegirPale()) != null) {
			System.out.println(pale);
			palesElegidos.add(pale);
		}

		if (palesElegidos.size() != 0) {
			System.out.println("-- RESUMEN");
			for (Pale estePale : palesElegidos) {
				System.out.println(estePale);
			}
		}
	}
}
