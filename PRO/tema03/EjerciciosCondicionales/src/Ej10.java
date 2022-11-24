import java.util.Scanner;

public class Ej10 {
	/**
	 * 10.- Se introduce por teclado una hora determinada con el formato H, M, S (H: horas, M:
	 * minutos, S: segundos). Calcular qué hora será dentro de un minuto. (Cuidado por
	 * ejemplo con las 12:45:59 o 13:59:59......)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] hora;
		String horaCompleta;
		int h = 0, m = 0, s = 0;

		System.out.print("Introduce la hora (h:m:s) -> "); horaCompleta = scanner.nextLine();

		/* Elimina los espacios de la cadena */
		horaCompleta = horaCompleta.replaceAll("\\s", "");
		/* Separa los números separados por coma */
		hora = horaCompleta.split(",");

		h = Integer.parseInt(hora[0]);
		m = Integer.parseInt(hora[1]);
		s = Integer.parseInt(hora[2]);

		/*
		Evita que se introduzcan datos sin sentido
		 */
		if (h > 23 || m > 59 || s > 59) {
			System.out.printf("ERROR: Tiempo %02d:%02d:%02d tiene un formato incorrecto", h, m, s);
			System.exit(0);
		}
		if (h < 0 || m < 0 || s < 0) {
			System.out.printf("ERROR: Tiempo %02d:%02d:%02d tiene un formato incorrecto", h, m, s);
			System.exit(0);
		}

		System.out.printf("Hora actual -> %02d:%02d:%02d\n", h, m, s);

		/*
		Transforma el tiempo a segundos, calcula cuantos segundos caben en X horas, los segundos que sobran se almacenan,
		calcula cuantos de los segundos restantes caben en X minutos
		 */
		s += ((h * 3600) + (m * 60) + 60); // sumamos 60 s al tiempo

		h = (s / 3600);
		s = (s % 3600);
		m = (s / 60);
		s = (s % 60);

		/*
		Si la hora es 24, significa que se ha cambiado de día
		 */
		if (h == 24) {
			h = 0;
		}

		System.out.printf("Dentro de un minuto -> %02d:%02d:%02d", h, m, s);
	}
}