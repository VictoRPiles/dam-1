import java.io.IOException;

/**
 * @author Victor Piles
 * @since 11/02/2022 8:10
 */

/**
 * <h1>Explicación:</h1>
 * <p>
 * Por cada vuelta de bucle imprime "excepción rana" si el número proporcionado por 'i' es par o 0, o imprime "excepción
 * pezespada" si no lo es. Además siempre imprime el valor de a, que és 99 cuando se lanza una excepción tipo Exception
 * o 2 cuando es de tipo IOException, en el primer caso se asigna el valor capturando al excepción en el main y en el
 * segundo en el método getEntero. Repetirá esto 10 veces.
 * <h1>Salida:</h1>
 * <p>
 * Lanzando excepcion rana
 * <p>
 * 99
 * <p>
 * Lanzando excepcion pezespada
 * <p>
 * 2
 * <p>
 * Lanzando excepcion rana
 * <p>
 * 99
 * <p>
 * Lanzando excepcion pezespada
 * <p>
 * 2
 * <p>
 * Lanzando excepcion rana
 * <p>
 * 99
 * <p>
 * Lanzando excepcion pezespada
 * <p>
 * 2
 * <p>
 * Lanzando excepcion rana
 * <p>
 * 99
 * <p>
 * Lanzando excepcion pezespada
 * <p>
 * 2
 * <p>
 * Lanzando excepcion rana
 * <p>
 * 99
 * <p>
 * Lanzando excepcion pezespada
 * <p>
 * 2
 */
public class E01_Salida {

	public static int getEntero(int num) throws Exception {
		try {
			if (num % 2 == 0) throw new Exception("Lanzando excepcion rana");
			else throw new IOException("Lanzando excepcion pezespada");
		}
		catch (IOException io) {
			System.out.println(io.getMessage());
			return 2;
		}
	}

	public static void main(String[] args) {
		int a = 99;

		for (int i = 0; i < 10; i++) {
			try {
				a = getEntero(i);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				a = 99;
			}
			System.out.println(a);
		}
	}
}
