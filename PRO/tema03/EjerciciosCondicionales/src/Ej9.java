import java.util.Scanner;

public class Ej9 {
	/**
	 * 9.- Escribe un programa que calcule la cuota que se debe abonar en el club de golf.
	 * La cuota es de 500 €. Tendrán un 50% de descuento las personas mayores de 65
	 * años y un 25% los menores de 18 años si los padres no son socios y 35% si los
	 * padres son socios.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int edad;
		double cuota = 500;
		boolean padresSocios = false;

		System.out.print("Introduce la edad -> "); edad = scanner.nextInt();
		if (edad < 18) {
			System.out.print("Padres socios -> "); padresSocios = scanner.nextBoolean();
		}

		if (edad > 65) {
			cuota *= 0.5;
		} else if (edad < 18) {
			if (padresSocios) {
				cuota *= 0.65;
			} else {
				cuota *= 0.75;
			}
		}

		System.out.println("Cuota -> " + cuota + "€");
	}
}
