import java.util.Scanner;

public class Ej5 {
	/**
	 * 5.- Diseño de un algoritmo que sume todos aquellos números leídos mientras no sean
	 * negativos,  al  introducirse  un  número  negativo,  muestra  la  suma  y    acaba  el
	 * programa
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num, suma = 0;

		do {
			num = scanner.nextInt();
			suma += num;
		} while (num >= 0);

		suma += Math.abs(num);      // sumamos lo que acabamos de restar con el último número

		System.out.printf("Total de la suma -> %d", suma);
	}
}
