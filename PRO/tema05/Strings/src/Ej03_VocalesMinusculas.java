import java.util.Scanner;

public class Ej03_VocalesMinusculas {
	public static String vocalesMinusculas(String cadenaOriginal) {
		String cadena;

		cadena = cadenaOriginal.replaceAll("[aeiou]", "a");

		return cadena;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(vocalesMinusculas(scanner.nextLine()));
	}
}
