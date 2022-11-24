import java.util.Scanner;

public class Ej06_Siglas {
	public static String devuelveSiglas(String cadena) {
		String siglas = "";

		// por cada String in String[]
		for (String s :
				cadena.split("\\s+")) {
			siglas += s.charAt(0);
		}

		return siglas.toUpperCase();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(devuelveSiglas(scanner.nextLine()));
	}
}
