import java.util.Scanner;

public class EntradaDatosEj1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/**
		 * 1.- Modifica los ejercicios 1, 2, 3 y 4 del Fichero Ejercicio1 de modo que los datos para las
		 * operaciones se pidan por teclado:
		 * • Pide el nombre y apellidos y guárdalo en una
		 *   variable. Luego pide la fecha de nacimiento. Por
		 *   último escríbelo con una sola sentencia.
		 * • Pide la nota de los 2 parciales
		 * • Por teclado se pedirá el precio y el descuento
		 * • Por teclado se pide el dinero a ingresar. (los
		 * porcentajes no hace falta pedirlos, los que tenga
		 * el programa)
		 * */

		System.out.println("===== EJERCICIO 1.1 =====");

		System.out.print("Escribe tu nombre -> ");
		String nombre = scanner.nextLine();
		System.out.print("Escribe tus apellidos -> ");
		String apellidos = scanner.nextLine();
		System.out.print("Escribe tu fecha de nacimiento -> ");
		String fecha_nacimiento = scanner.nextLine();

		/* Con una sola sentencia */
		System.out.println(nombre + " " + apellidos + "\n" + fecha_nacimiento);

		/* Con tres sentencias */
		System.out.print(nombre + " ");
		System.out.println(apellidos);
		System.out.println(fecha_nacimiento);

		System.out.println("===== EJERCICIO 1.2 =====");

		System.out.print("Nota del primer parcial -> ");
		float parcial1 = scanner.nextFloat();
		System.out.print("Nota del segundo parcial -> ");
		float parcial2 = scanner.nextFloat();

		float mediaFinal = (parcial1 + parcial2) / 2;

		System.out.println("Parcial 1 = " + parcial1);
		System.out.println("Parcial 2 = " + parcial2);
		System.out.println("Media final = " + mediaFinal);

		System.out.println("===== EJERCICIO 1.3 =====");

		System.out.print("Precio -> ");
		float precioInicial = scanner.nextFloat();
		System.out.print("Descuento -> ");
		float descuento = scanner.nextFloat();
		float precioFinal = precioInicial - ((precioInicial * descuento) / 100);

		System.out.println("El precio inicial de las deportivas era -> " + precioInicial + " €");
		System.out.println("Con la rebaja del " + descuento + "% cuestan -> " + precioFinal + " €");

		System.out.println("===== EJERCICIO 1.4 =====");

		System.out.print("Dinero a ingresar -> ");
		float saldoInicial = scanner.nextFloat();
		float interesAnual = (saldoInicial * 2.75f) / 100;
		float interesNeto = (((interesAnual / 2) * 82) / 100);

		System.out.println("Saldo inicial -> " + saldoInicial + " €");
		System.out.println("Interés anual -> " + interesAnual + " €");
		System.out.println("Interés 6 meses -> " + (interesAnual / 2) + " €");
		System.out.printf("Retención hacienda -> %.2f €\n", ((interesAnual / 2) - interesNeto)); // Formato con 2 decimales maximo
		System.out.println("Cantidad final -> " + (saldoInicial + interesNeto) + " €");
	}
}
