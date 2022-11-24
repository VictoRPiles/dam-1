import java.util.Scanner;

public class ComparaDosCadenas {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String cadena1, cadena2;

		System.out.print("Introduce la primera cadena -> "); cadena1 = scanner.nextLine();
		System.out.print("Introduce la segunda cadena -> "); cadena2 = scanner.nextLine();

		if (cadena1.equals(cadena2)) {
			System.out.println(cadena1 + " y " + cadena2 + " son la misma cadena");
		} else {
			System.out.println(cadena1 + " y " + cadena2 + " no son la misma cadena");
		}
	}
}
