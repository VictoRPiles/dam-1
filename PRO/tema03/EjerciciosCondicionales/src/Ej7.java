public class Ej7 {
	/**
	 * 7.- Los trabajadores de una fábrica de automóviles tienen tres turnos: mañana, noche y
	 * festivo. Se desea calcular el sueldo semanal a razón de 5 días de trabajo por semana
	 * y la siguiente tarifa:
	 * a. 600 pts/h -> mañana
	 * b. 800 pts/h -> noche
	 * c. 1000 pts/h -> festivos
	 */
	public static void main(String[] args) {
		// NOTA : ASUMO QUE CADA TURNO ES DE 8H DE TRABAJO
		int tarifaA = 600 * 40, tarifaB = 800 * 40, tarifaC = 1000 * 40;

		System.out.println("Tarifa A -> " + tarifaA + " pts/semana -> " + (tarifaA * 0.0060) + "€");
		System.out.println("Tarifa B -> " + tarifaB + " pts/semana -> " + (tarifaB * 0.0060) + "€");
		System.out.println("Tarifa C -> " + tarifaC + " pts/semana -> " + (tarifaC * 0.0060) + "€");
	}
}
