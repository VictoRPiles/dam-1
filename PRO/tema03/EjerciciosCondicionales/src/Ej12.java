import java.util.Scanner;

public class Ej12 {
	/**
	 * 12.- Escribe un programa para calcular la edad de una persona solicitando la fecha
	 * actual y la fecha de su nacimiento.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int edad, diaNac, mesNac, agnoNas, diaAct, mesAct, agnoAct;

		System.out.print("Introduce la fecha actual -> ");
		diaAct = scanner.nextInt(); mesAct = scanner.nextInt(); agnoAct = scanner.nextInt();
		System.out.print("Introduce la fecha de nacimiento -> ");
		diaNac = scanner.nextInt(); mesNac = scanner.nextInt(); agnoNas = scanner.nextInt();

		if (diaAct > 31 || diaNac > 31 || mesAct > 12 || mesNac > 12 || diaAct < 1 || diaNac < 1 || mesAct < 1 || mesNac < 1) {
			System.out.println("ERROR: Fecha incorrecta");
			System.exit(0);
		}

		if (mesAct < mesNac) {  // si aun no se ha llegado al mes de cumpleaños
			edad = agnoAct - agnoNas - 1;
		} else {
			if (mesAct > mesNac) {  // si se ha sobrepasado el mes de cumpleaños
				edad = agnoAct - agnoNas;
			} else {
				if (diaAct >= diaNac) {  // si es el mes del cumpleaños y se ha sobrepasado o es el dia de cumpleaños
					edad = agnoAct - agnoNas;
				} else { // si es el mes del cumpleaños, pero no se ha sobrepasado el dia de cumpleaños
					edad = agnoAct - agnoNas - 1;
				}
			}
		}

		System.out.println("Tu edad actual es -> " + edad);
	}
}
