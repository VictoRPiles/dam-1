import java.time.*;

public class Fechas {
	public static void main(String[] args) {
		LocalDate hoy;
		hoy = LocalDate.now();

		LocalTime ahora;
		ahora = LocalTime.now();

		LocalDateTime hoyAhora;
		hoyAhora = LocalDateTime.now();

		ZonedDateTime hoyAhoraZona;
		hoyAhoraZona = ZonedDateTime.now();

		LocalDate cumple;
		cumple = LocalDate.of(2003, Month.NOVEMBER, 18);

		System.out.println("Hoy es " + hoy);
		System.out.println("La hora actual es " + ahora);
		System.out.println("La fecha y hora actuales es: " + hoyAhora);
		System.out.println("La fecha y hora actuales con zona horaria es: " + hoyAhoraZona);
		System.out.println("Fecha de mi cumpleaños: " + cumple);
		System.out.println("Hoy es dia: " + hoy.getDayOfMonth());
		System.out.println("Este mes es: " + hoy.getMonth());
		System.out.println("Este año es: " + hoy.getYear());
	}
}
