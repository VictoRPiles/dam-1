import java.util.Scanner;

public class EntradaDatosEj3 {

	public static void main(String[] args) {

		/**
		 * 3- Escribe un programa que solicite al usuario una cantidad en segundos y la convierta a
		 * días, horas, minutos y segundos.
		 */

		Scanner scanner = new Scanner(System.in);
		int segundos;

		System.out.print("Escribe una cantidad de segundos -> ");segundos = scanner.nextInt();

		calculaTiempo(segundos);
	}
	public static void calculaTiempo(int segundos) {

		/**
		 * Dia -> 86400s
		 * Hora -> 3600s
		 * Minuto -> 60s
		 *
		 * FUNCIONAMIENTO
		 * Calcula cuantos dias caben en X segundos, los segundos que sobran se almacenan en segMeLlevo,
		 * calcula cuantas horas caben en segMeLlevo, los segundos que sobran se almacenan en segMeLlevo,
		 * calcula cuantos minutos caben en segMeLlevo, los segundos que sobran se almacenan en segMeLlevo,
		 * los segundos restantes en segMeLlevo se añaden a la cadena del resultado
		 */

		int minutos, horas, dias, segMeLlevo = segundos;

		dias = segundos / 86400;
		segMeLlevo %= 86400;
		horas = segMeLlevo / 3600;
		segMeLlevo %= 3600;
		minutos = segMeLlevo / 60;
		segMeLlevo %= 60;

		System.out.println(segundos + " segundos = " + dias  + "d " + horas + "h " + minutos + "m " + segMeLlevo + "s");
	}
}
