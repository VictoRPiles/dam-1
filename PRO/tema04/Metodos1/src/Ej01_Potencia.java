import java.util.Scanner;

public class Ej01_Potencia {
	/**
	 * 1.- Escribir una función que devuelva la primera potencia de 2 que supera al número que
	 * se le pasa como parámetro. Por ejemplo, si el número que se le da a la función es 17, la
	 * función devolverá 5, ya que 2⁴ <= 17 <= 2⁵
	 * Escribir un programa que pruebe esta función.
	 */
	public static void main(String[] args) {
		float numero;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce un numero -> ");
		numero = scanner.nextFloat();

		System.out.printf("%1$d -> 2 elevado a %1$d es mayor que %2$.2f", potencia(numero), numero);
	}

	public static short potencia(float numero) {
		float objetivo = numero;
		short exponente = 0;

		if (objetivo >= 1) {
			while (Math.pow(2, exponente) <= objetivo) {
				exponente++;
			}
		}

		return exponente;
	}
}
