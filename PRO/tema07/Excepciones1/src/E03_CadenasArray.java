import java.util.Arrays;

/**
 * @author Victor Piles
 * @since 11/02/2022 8:37
 */
public class E03_CadenasArray {

	static void mostrarCadenasArray(String[] cadenas) {
		System.out.println("Analizando cadenas: " + Arrays.toString(cadenas));
		for (String cadena : cadenas) {
			try {System.out.println(cadena.charAt(0));}
			catch (NullPointerException e) {System.out.print("ERROR: Indice nulo\n");}
			catch (StringIndexOutOfBoundsException e) {System.out.print("ERROR: Indice out of bounds\n");}
		}
	}

	public static void main(String[] args) {
		mostrarCadenasArray(new String[]{"Hola", "Pepe", "Maria", "Miguel Angel"});
		mostrarCadenasArray(new String[5]);
		mostrarCadenasArray(new String[]{"hola", null, "pepe", "", "quinta"});
	}
}
