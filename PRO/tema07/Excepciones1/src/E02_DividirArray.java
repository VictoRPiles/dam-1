/**
 * @author Victor Piles
 * @since 11/02/2022 8:24
 */
public class E02_DividirArray {

	static class ClaseExcep1 {

		static void dividirEntreArray(int entero, int[] array) {
			for (int i : array) {
				try {
					if (i == 0 || entero == 0) throw new Exception("ERROR: Division entre 0");
					System.out.printf("%2d : %-2d = %5.2f\n", i, entero, ((double) i / (double) entero));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		/**
		 * Reescribe el código anterior con las sentencias de código necesarias para que la excepción no llegue a
		 * producirse (comprobar que el divisor debe ser distinto de cero)
		 */
		static void dividirEntreArray2(int entero, int[] array) {
			for (int i : array) {
				if (i == 0 || entero == 0) System.out.println("ERROR: Division entre 0");
				else System.out.printf("%2d : %-2d = %5.2f\n", i, entero, ((double) i / (double) entero));
			}
		}
	}

	public static void main(String[] args) {
		ClaseExcep1.dividirEntreArray(2, new int[]{-2, -1, 0, 1, 2});
		//ClaseExcep1.dividirEntreArray2(2, new int[]{-2, -1, 0, 1, 2});
	}
}
