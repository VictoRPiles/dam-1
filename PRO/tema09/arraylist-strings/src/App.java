import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		String[] cadenas = {null, "aEiou", "ccc", "Aeina", "aceituno"};

		try {
			String[] c5v = Clase.obtenerArrCad5VocalesAL(cadenas);
			System.out.println(Arrays.toString(c5v));
		} catch (Exception e) {System.out.println(e.getMessage());}

		// Este siempre lanza Exception
		try {
			String[] c5v = Clase.obtenerArrCad5VocalesAL(null);
			System.out.println(Arrays.toString(c5v));
		} catch (Exception e) {System.out.println(e.getMessage());}
	}
}