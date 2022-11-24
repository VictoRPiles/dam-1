import java.util.Scanner;

public class Ej02_TresMetodos {
	public static String getMitad(String cadena) {
		cadena = cadena.substring(0, (cadena.length() / 2));

		return cadena;
	}

	public static String esNoEs(String cadena) {
		cadena = cadena.replace("es", "no es");

		return cadena;
	}

	public static int encuentraSubcadenas(String texto, String cadena) {
		int ultimoIndex = 0;
		int contador    = 0;

		while (ultimoIndex != -1) {

			ultimoIndex = texto.indexOf(cadena, ultimoIndex);

			if (ultimoIndex != -1) {
				contador++;
				ultimoIndex += cadena.length();
			}
		}
		return contador;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(getMitad("Hola que tal"));
		System.out.println(getMitad("Adiós"));

		System.out.println(esNoEs(scanner.nextLine()));

		System.out.println(encuentraSubcadenas(scanner.nextLine(), scanner.nextLine()));
	}
}
