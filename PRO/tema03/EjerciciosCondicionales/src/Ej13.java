import java.util.Scanner;

public class Ej13 {
	/**
	 * 13.- Escribe un programa que solicite tres valores enteros con el día, mes y año de una
	 * fecha e indique si se trata de valores válidos para una fecha. (tener en cuenta el
	 * número de días de cada mes)(el año será válido si es >=1970 y menor que 3000)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dia, mes, agno;

		System.out.print("Introduce la fecha -> ");
		dia = scanner.nextInt(); mes = scanner.nextInt(); agno = scanner.nextInt();

		if (dia < 1 || dia > 31) {
			System.out.println("ERROR: Dia " + dia + " no valido para una fecha");
		} else {
			System.out.println("Dia correcto");
		}
		if (mes < 1 || mes > 12) {
			System.out.println("ERROR: Mes " + mes + " no valido para una fecha");
		} else {
			System.out.println("Mes correcto");
		}
		if (agno < 1970 || agno > 3000) {
			System.out.println("ERROR: Año " + agno + " no valido para una fecha");
		} else {
			System.out.println("Año correcto");
		}
	}
}
