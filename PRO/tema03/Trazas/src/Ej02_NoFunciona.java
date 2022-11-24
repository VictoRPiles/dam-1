public class Ej02_NoFunciona {
	/**
	 * 2.- ¿Por qué no funciona el siguiente código?. Modifícalo para que funcione
	 * <p>
	 * RESPUESTA
	 * No funciona porque las variables 'suma' y 'i' no estan inicializadas, en la primera línea dentro del bucle, se
	 * le pide al programa que almacene en 'suma' el valor de 'suma' más el de 'i', pero el programa no conoce el
	 * valor de ninguna de las dos variables, por tanto hay que introducir un valor antes, por ejemplo el valor 0 para
	 * las dos.
	 */
	public static void main(String[] args) {
		CodigoCorregido();
	}

	/*
	public static void CodigoConErrores() {
		int i, suma;
		while (i < 10) {
			suma = suma + i;
			i++;
		}
		System.out.print(suma);
	}
	*/
	public static void CodigoCorregido() {
		int i = 0, suma = 0;
		while (i < 10) {
			suma = suma + i;
			i++;
		}
		System.out.print(suma);
	}
}