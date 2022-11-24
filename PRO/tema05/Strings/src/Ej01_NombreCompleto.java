import java.util.Scanner;

public class Ej01_NombreCompleto {
	public static void a(String nombreCompleto) {
		System.out.println("A) El nombre completo con todos los caracteres en minúsculas y luego en mayúsculas y su " +
		                   "longitud");
		System.out.println(nombreCompleto);
		System.out.println(nombreCompleto.toUpperCase());
		System.out.println(nombreCompleto.length());
	}

	public static void b(String nombreCompleto) {
		if (nombreCompleto.length() >= 2) {
			System.out.println("B) Los dos primeros caracteres de la cadena concatenada (solo en el caso de que la " +
			                   "longitud de esta sea de dos o más caracteres)");
			System.out.println(nombreCompleto.substring(0, 2));
		}
	}

	public static void c(String nombreCompleto) {
		if (nombreCompleto.length() >= 2) {
			System.out.println("C) Los dos últimos caracteres de la cadena concatenada (solo en el caso de que la " +
			                   "longitud de esta sea de dos o más caracteres)");
			System.out.println(nombreCompleto.substring(nombreCompleto.length() - 2));
		}
	}

	public static void d(String nombreCompleto) {
		short contador = 0;
		System.out.println("D) El número de ocurrencias en la cadena del último carácter");
		for (int i = 0; i < nombreCompleto.length(); i++) {

			if (nombreCompleto.charAt(i) == nombreCompleto.charAt(nombreCompleto.length() - 1)) {
				contador++;
			}
		}
		System.out.println("La '" + nombreCompleto.charAt(nombreCompleto.length() - 1) + "' aparece " + contador +
		                   " " +
		                   "veces");
	}

	public static void e(String nombreCompleto) {
		System.out.println("E) La cadena con todas las ocurrencias del primer carácter en mayúsculas");
		for (int i = 0; i < nombreCompleto.length(); i++) {

			if (nombreCompleto.charAt(i) == nombreCompleto.charAt(0)) {
				nombreCompleto = nombreCompleto.replace(nombreCompleto.charAt(i),
				                                        nombreCompleto.toUpperCase().charAt(i));
			}
		}
		System.out.println(nombreCompleto);
	}

	public static void f(String nombreCompleto) {
		System.out.println("F) La cadena con tres asteriscos por delante y por detrás");

		nombreCompleto = "***" + nombreCompleto + "***";

		System.out.println(nombreCompleto);
	}

	public static void g(String nombreCompleto) {
		System.out.println("G) La cadena invertida (Sólo la muestra, no la guarda invertida)");

		for (int i = nombreCompleto.length() - 1; i >= 0; i--) {
			System.out.print(nombreCompleto.charAt(i));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String  nombre, primerApellido, segundoApellido, nombreCompleto;

		System.out.print("Nombre -> ");
		nombre = scanner.nextLine();
		System.out.print("1º Apellido -> ");
		primerApellido = scanner.nextLine();
		System.out.print("2º Apellido -> ");
		segundoApellido = scanner.nextLine();

		nombreCompleto = nombre + " " + primerApellido + " " + segundoApellido;

		a(nombreCompleto);
		b(nombreCompleto);
		c(nombreCompleto);
		d(nombreCompleto);
		e(nombreCompleto);
		f(nombreCompleto);
		g(nombreCompleto);
	}
}
