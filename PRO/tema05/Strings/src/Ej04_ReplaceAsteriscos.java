import java.util.Scanner;

public class Ej04_ReplaceAsteriscos {
	public static String vocalesMinusculas(String cadenaOriginal) {
		String cadena;

		cadena = cadenaOriginal.replaceAll("\\d+", "*");

		return cadena;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(vocalesMinusculas(scanner.nextLine()));
	}
}
