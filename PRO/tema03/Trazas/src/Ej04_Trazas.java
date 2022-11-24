import java.util.Scanner;

public class Ej04_Trazas {
	/**
	 * 4.- Analiza el siguiente algoritmo y contesta las cuestiones
	 */
	public static void main(String[] args) {
		System.out.println("TRAZAS 1");
		Trazas1();
		System.out.println("===============");
		System.out.println("TRAZAS 2");
		Trazas2();
		System.out.println("===============");
		System.out.println("TRAZAS 3");
		//Trazas3();
	}

	public static void Trazas1() {
		int ant, sig;
		boolean flag = false;
		Scanner tec = new Scanner(System.in);

		ant = tec.nextInt();
		sig = tec.nextInt();
		while (sig != 0 && flag == false) {
			if (ant == sig) {
				flag = true;
			}
			ant = sig;
			sig = tec.nextInt();
		}
		if (flag) {
			System.out.println("Verdadero");
		} else {
			System.out.println("Falso");
		}
	}

	/**
	 * A) ¿Cuántos números lee antes de acabar?
	 *
	 * RESPUESTA
	 * Lee como mínimo 2 números, 'ant' y 'sig', si entra en el bucle lee 'sig' tantas veces como se repita. Aunque se
	 * introduzca dos números iguales, el programa necesita que se introduzca otro cualquiera antes de salir del bucle.
	 */

	/**
	 * B) Modifícalo para que escriba junto al mensaje Verdadero o Falso el número de números que ha leído
	 */
	public static void Trazas2() {
		int ant, sig;
		byte numLeidos = 0;
		boolean flag = false;
		Scanner tec = new Scanner(System.in);

		ant = tec.nextInt(); numLeidos++;
		sig = tec.nextInt(); numLeidos++;
		while (sig != 0 && flag == false) {
			if (ant == sig) {
				flag = true;
			}
			ant = sig;
			sig = tec.nextInt(); numLeidos++;
		}
		if (flag) {
			System.out.println("Verdadero. Números leídos -> " + numLeidos);
		} else {
			System.out.println("Falso. Números leídos -> " + numLeidos);
		}
	}
}
