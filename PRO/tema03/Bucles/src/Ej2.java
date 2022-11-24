public class Ej2 {
	/**
	 * 2.- Diseñar un algoritmo que lee 40 números, los procesa y determina
	 * si alguno era múltiplo de 3
	 */
	public static void main(String[] args) {
		int[] numeros = new int[40];

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 100);
		}
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] % 3 == 0) {
				System.out.printf("%02d -> SI es múltiplo de 3\n", numeros[i]);
			} else {
				System.out.printf("%02d -> NO es múltiplo de 3\n", numeros[i]);
			}
		}
	}
}
