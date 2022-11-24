import java.util.Scanner;

public class Ej05_PalabrasDeCadena {
	public static int palabrasCadena(String cadena) {
		int palabras = 0;

		cadena = cadena.trim();

		if (cadena.isEmpty()) {
			return 0;
		}

		return cadena.split("\\s+").length; // '+' por si hay más de un espacio seguido
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(palabrasCadena(scanner.nextLine()));
	}
}
