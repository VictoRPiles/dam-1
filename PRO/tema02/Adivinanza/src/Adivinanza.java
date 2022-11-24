import java.util.Scanner;

public class Adivinanza {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Piensa un numero"); scanner.nextLine();
		System.out.println("Multiplicalo por 5");scanner.nextLine();
		System.out.println("Sumale 6"); scanner.nextLine();
		System.out.println("Multiplıcalo por 4");scanner.nextLine();
		System.out.println("Sumale 9"); scanner.nextLine();
		System.out.println("Multiplıcalo por 5");scanner.nextLine();
		System.out.println("Escribe el resultado");

		int valor = scanner.nextInt();

		System.out.println("El número que has pensado es -> " + ((valor - 165) / 100));
	}
}
