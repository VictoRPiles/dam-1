import java.util.Scanner;

public class ComparaDosLetras {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char letra1, letra2;

		System.out.print("Introduce la primera letra -> "); letra1 = scanner.next().charAt(0);
		System.out.print("Introduce la segunda letra -> "); letra2 = scanner.next().charAt(0);

		if (letra1 == letra2) {
			System.out.println(letra1 + " y " + letra2 + " son la misma letra");
		} else {
			System.out.println(letra1 + " y " + letra2 + " no son la misma letra");
		}
	}
}
