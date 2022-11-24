public class Ej3 {
	/**
	 * 3.- Diseñar un algoritmo que calcule la suma de los 20 primeros números pares,
	 * y el producto de los 20 primeros números impares simultáneamente:
	 */
	public static void main(String[] args) {
		int[] numerosPares = new int[20];
		int[] numerosImpares = new int[20];
		int i = 0, sumaPares = 0, sumaImpares = 0;

		System.out.print("Pares -> ");
		while (i < numerosPares.length) {
			numerosPares[i] = (int) (Math.random() * 100);
			if (numerosPares[i] % 2 == 0) {
				System.out.print(numerosPares[i] + ", ");
				sumaPares += numerosPares[i];
				i++;
			}
		}
		System.out.println("\nSuma de pares = " + sumaPares);

		i = 0;
		System.out.print("Impares -> ");
		while (i < numerosImpares.length) {
			numerosImpares[i] = (int) (Math.random() * 100);
			if (numerosImpares[i] % 2 != 0) {
				System.out.print(numerosImpares[i] + ", ");
				sumaImpares += numerosImpares[i];
				i++;
			}
		}
		System.out.println("\nSuma de impares = " + sumaImpares);
	}
}
