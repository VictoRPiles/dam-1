package fecha;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	SimpleDateFormat format;
	Date hoy;

	public Fecha() {
		hoy = new Date();
	}

	public String getFecha(int tipo) {
		switch (tipo) {
			case 1 -> {
				format = new SimpleDateFormat("yyyy/MM");
				return format.format(hoy);
			}
			case 2 -> {
				format = new SimpleDateFormat("MM/yyyy");
				return format.format(hoy);
			}
			case 3 -> {
				format = new SimpleDateFormat("MM/yy");
				return format.format(hoy);
			}
			default -> {
				return "ERROR";
			}
		}
	}
}