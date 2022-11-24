public class Ej02_Tabla {
	/**
	 * 2.- Programa en java que escriba las tablas de multiplicar del 1 al 9, separadas por una línea horizontal, como
	 * en el ejemplo. Fíjate en la alineación de los números y los símbolos del producto y el =
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			System.out.println("\n TABLA DE " + i);
			System.out.println("------------");
			for (int j = 1; j <= 10; j++) {
				System.out.printf("%02d x %02d = %02d\n", i, j, (i * j));
			}
		}
	}
}
