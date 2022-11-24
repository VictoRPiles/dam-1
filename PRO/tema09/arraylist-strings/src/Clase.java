import java.util.ArrayList;

public class Clase {
	/**
	 * @param cadenas Array de cadenas.
	 * @return Array con las cadenas que tienen las cinco vocales.
	 * @throws IllegalArgumentException Si recibe un parámetro nulo.
	 */
	public static String[] obtenerArrCad5VocalesAL(String[] cadenas) throws IllegalArgumentException {
		ArrayList<String> conCincoVocales = new ArrayList<>();

		if (cadenas == null) throw new IllegalArgumentException("Parámetro no válido");

		for (String cadena : cadenas) {
			if (cadena == null) continue;

			String cadenaToLower = cadena.toLowerCase(); // ignore case
			if (cadenaToLower.indexOf('a') != -1 && cadenaToLower.indexOf('e') != -1 && cadenaToLower.indexOf('i') != -1 && cadenaToLower.indexOf('o') != -1 && cadenaToLower.indexOf('u') != -1)
				conCincoVocales.add(cadena);
		}

		return conCincoVocales.toArray(new String[0]);
	}
}