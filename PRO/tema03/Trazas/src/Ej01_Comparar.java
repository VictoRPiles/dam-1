public class Ej01_Comparar {
	/**
	 * 1.- Escribe los siguientes códigos y ejecútalos. ¿Hacen lo mismo?
	 * <p>
	 * RESPUESTA
	 * Sí, hacen lo mismo, ya que al incrementar la variable 'i' de uno en uno los dos cumplen la condición en el
	 * mismo momento
	 */
	public static void main(String[] args) {
		System.out.println("PRIMER PROGRAMA");
		Ejemplo01();
		System.out.println("===============");
		System.out.println("SEGUNDO PROGRAMA");
		Ejemplo02();
		System.out.println("===============");
		System.out.println("PRIMER PROGRAMA MODIFICADO");
		//Ejemplo01Modificado(); // Lo comento porque se queda el bucle infinito
		System.out.println("===============");
		System.out.println("SEGUNDO PROGRAMA MODIFICADO");
		Ejemplo02Modificado();
	}

	// PRIMER CÓDIGO
	public static void Ejemplo01() {

		int i, suma = 0;
		i = 1;
		while (i != 10) {
			suma = suma + i;
			i++;
		}
		System.out.println(suma);
	}

	// SEGUNDO CÓDIGO
	public static void Ejemplo02() {
		int i, suma = 0;
		i = 1;
		while (i < 10) {
			suma = suma + i;
			i++;
		}
		System.out.println(suma);
	}

	/**
	 * Cambia la sentencia i++ por i=i+2 ¿Siguen haciendo lo mismo? ¿Cuál es la conclusión?
	 * <p>
	 * RESPUESTA
	 * No, ya no hacen lo mismo, el primer programa nunca sale del bucle, ya que la variable 'i' pasa de ser 9 a ser
	 * 11, pero nunca es 10, por este motivo nunca se cumple la condición. El segundo programa funciona correctamente,
	 * pero cumple la condición con menos vueltas de bucle, esto implica que la mitad de números no se suman, por
	 * tanto el resultado de la variable 'suma' es menor.
	 */

	// PRIMER CÓDIGO MODIFICADO
	public static void Ejemplo01Modificado() {

		int i, suma = 0;
		i = 1;
		while (i != 10) {
			suma = suma + i;
			i += 2;
		}
		System.out.println(suma);
	}

	// SEGUNDO CÓDIGO MODIFICADO
	public static void Ejemplo02Modificado() {
		int i, suma = 0;
		i = 1;
		while (i < 10) {
			suma = suma + i;
			i += 2;
		}
		System.out.println(suma);
	}
}

