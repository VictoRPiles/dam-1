import java.util.Scanner;

public class Ej11 {
	/**
	 * 11.- Escribe un programa que solicite un valor real que indica una cantidad de dinero
	 * en euros. El programa debe mostrar por pantalla la mínima cantidad de monedas
	 * de cada tipo en que se debe devolver la cantidad de dinero indicada.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double dinero;
		int dosE, unE, cincuentaC, veinteC, diezC, cincoC, dosC, unC;

		System.out.print("Introduce una cantidad en € -> "); dinero = scanner.nextDouble();
		System.out.println("Para tener " + dinero + "€ se necesitan:");

		/*
		Pasamos los euros a céntimos
		 */
		dinero = dinero * 100;

		/*
		Calculamos la cantidad de céntimos que caben en cada una de las monedas, los céntimos restantes se almacenan
		para comprovar si caben en alguna otra moneda
		 */
		dosE = (int) (dinero / 200);
		dinero = (dinero % 200);
		unE = (int) (dinero / 100);
		dinero = (dinero % 100);
		cincuentaC = (int) (dinero / 50);
		dinero = (dinero % 50);
		veinteC = (int) (dinero / 20);
		dinero = (dinero % 20);
		diezC = (int) (dinero / 10);
		dinero = (dinero % 10);
		cincoC = (int) (dinero / 5);
		dinero = (dinero % 5);
		dosC = (int) (dinero / 2);
		dinero = (dinero % 2);
		/*
		En algunas ocasiones, al ser dinero de tipo double, al hacer operaciones se pierde una pequeña cantidad, es decir
		cuando solo queda 1c, no lo indica porque Java almacena algo menos (0.9999999999 por ejemplo), para solucionar
		el bug, redondeamos a la cifra más cercana
		 */
		unC = (int) Math.round(dinero);

		System.out.println(
				dosE + " monedas de 2€\n" +
				unE + " monedas de 1€\n" +
				cincuentaC + " monedas de 50c\n" +
				veinteC + " monedas de 20c\n" +
				diezC + " monedas de 10c\n" +
				cincoC + " monedas de 5c\n" +
				dosC + " monedas de 2c\n" +
				unC + " monedas de 1c"
		);
	}
}
