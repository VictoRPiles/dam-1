import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ej5 {
	/**
	 * 5.- Realiza el ejercicio 13 de la actividad de condicionales utilizando la
	 * estructura condicional múltiple para la selección de meses
	 */
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		GregorianCalendar calendario = new GregorianCalendar();
		int dia, mes, año;
		System.out.print("Introduce un dia: ");
		dia = lector.nextInt();
		System.out.print("Introduce un mes: ");
		mes = lector.nextInt();
		System.out.print("Introduce un año: ");
		año = lector.nextInt();

		if (año < 1970 || año >= 3000) {
			System.out.println("Año incorrecto");
		} else {
			System.out.println("Año correcto");
			switch (mes) {
				case 1, 3, 5, 7, 8, 10, 12:
					System.out.println("Mes correcto");
					if (dia <= 31 && dia >= 1) {
						System.out.println("Dia correcto");
					} else {
						System.out.println("Dia incorrecto");
					}
					break;
				case 4, 6, 9, 11:
					System.out.println("Mes correcto");
					if (dia <= 30 && dia >= 1) {
						System.out.println("Dia correcto");
					} else {
						System.out.println("Dia incorrecto");
					}
					break;
				case 2:
					System.out.println("Mes correcto");
					/* método de la clase GregorianCalendar, evalúa si el año es bisiesto */
					if (calendario.isLeapYear(año)) {
						if (dia <= 29 && dia >= 1) {
							System.out.println("Dia correcto");
						} else {
							System.out.println("Dia incorrecto");
						}
					} else {
						if (dia <= 28 && dia >= 1) {
							System.out.println("Dia correcto");
						} else {
							System.out.println("Dia incorrecto");
						}
					}
					break;
				default:
					System.out.println("Mes incorrecto");
					break;
			}
		}
	}
}