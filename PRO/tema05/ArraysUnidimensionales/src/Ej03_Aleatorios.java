public class Ej03_Aleatorios {
	public static void main(String[] args) {
		int[]   numeros          = new int[10];
		byte    digito           = 0;
		int     contador         = 0;
		boolean numeroEncontrado = false;

		do {
			while (!numeroEncontrado) {
				numeros[digito] = (int) (Math.random() * 100);
				contador++;

				if (numeros[digito] % 10 == digito) {
					numeroEncontrado = true;
				}
			}
			digito++;
			numeroEncontrado = false;
		} while (digito < 10);

		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("%02d\n", numeros[i]);
		}

		System.out.println("Se han generado " + contador + " numeros");
	}
}
