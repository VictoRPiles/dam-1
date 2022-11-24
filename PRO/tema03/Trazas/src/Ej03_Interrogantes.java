public class Ej03_Interrogantes {
	/**
	 * 3.- Sean los siguientes programas:
	 */
	public static void main(String[] args) {
		System.out.println("PROGRAMA 1");
		Programa01();
		System.out.println("===============");
		System.out.println("PROGRAMA 2 CORREGIDO");
		Programa02Corregido();
	}

	public static void Programa01() {
		int i = 1, j;
		while (i <= 20) {
			j = 1;
			while (j <= 10) {
				System.out.print(i);
				i++;
				j++;
			}
			System.out.println();
		}
	}

	/*
	public static void Programa02() {
		int i = 1;
		System.out.println();
		while (??????????){
			System.out.print(i);
			if (??????????){
				System.out.println();
			}
			i++;
		}
	}
	 */

	/**
	 * Sustituye los interrogantes por las expresiones adecuadas para que haga exactamente lo
	 * mismo que el primero (Pista: recuerda el operador %).
	 */

	public static void Programa02Corregido() {
		int i = 1;
		while (i <= 20) {
			System.out.print(i);
			if (i % 10 == 0) {
				System.out.println();
			}
			i++;
		}
	}
}
