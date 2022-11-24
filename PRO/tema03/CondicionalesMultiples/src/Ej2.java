import java.util.Scanner;

public class Ej2 {
	/**
	 * 2.- Realiza el ejercicio 14 de la actividad de condicionales
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String diaSemana;

		System.out.print("Introduce el dia de la semana -> "); diaSemana = scanner.nextLine();

		switch (diaSemana.toUpperCase()) {
			case "LUNES":
			case "MARTES":
			case "MIERCOLES":
			case "JUEVES":
			case "VIERNES":
				System.out.println("No es fin de semana");
				break;
			case "SABADO":
			case "DOMINGO":
				System.out.println("Es fin de semana");
				break;
			default:
				System.out.println("ERROR: No has introducido un día de la semana, comprueba erratas");
				break;
		}
	}
}
