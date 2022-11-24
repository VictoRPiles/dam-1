import java.util.Scanner;

/**
 * @author Victor Piles
 * @since 17/01/2022 13:06
 */
public class LogisticaControlContenedor {
	static LogisticaAlmacen empresa = new LogisticaAlmacen();

	/**
	 * Imprime el menú de opciones.
	 *
	 * @return La opción elegida por el usuario
	 */
	public static char menu() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("ELIGE UNA OPCION:");
		System.out.println("M) Meter contenedor");
		System.out.println("S) Sacar contenedor");
		System.out.println("Q) Salir");

		return scanner.next().toLowerCase().charAt(0);
	}

	/**
	 * Comprueba si hay algún sitio disponible en el almacén. Un sitio está disponible si indice == true.
	 * <p>
	 * Cuando encuentra sitio rompe los dos bucles y no sigue buscando, informa al camionero y actualiza el estado de
	 * los almacenes en la clase LogisticaAlmacen.
	 * <p>
	 * Si llega a la última iteración del bucle significa que no hay sitio libre.
	 */
	public static void meterContenedor() {

		bucle_exterior:
		for (int i = 0; i < empresa.getAlmacenes().length; i++) {
			for (int j = 0; j < empresa.getAlmacenes()[i].length; j++) {
				if (!empresa.getAlmacenes()[i][j]) {
					System.out.printf("Puedes descargar en:\nAlmacen -> %d\nSitio -> %d\n", i + 1, j + 1);
					empresa.setAlmacenes(i, j, true);
					break bucle_exterior;
				}
			}

			if (i + 1 == empresa.getAlmacenes().length) System.out.println("NO HAY SITIO EN EL ALMACEN");
		}
	}

	/**
	 * Comprueba si hay algún contenedor disponible en el almacén. Un contenedor está disponible si indice == false.
	 * <p>
	 * Cuando encuentra un contenedor rompe los dos bucles y no sigue buscando, informa al camionero y actualiza el
	 * estado de los almacenes en la clase LogisticaAlmacen.
	 * <p>
	 * Si llega a la última iteración del bucle significa que no hay sitio libre.
	 */
	public static void sacarContenedor() {

		bucle_exterior:
		for (int i = 0; i < empresa.getAlmacenes().length; i++) {
			for (int j = 0; j < empresa.getAlmacenes()[i].length; j++) {
				if (empresa.getAlmacenes()[i][j]) {
					System.out.printf("Puedes cargar en:\nAlmacen -> %d\nContenedor -> %d\n", i + 1, j + 1);
					empresa.setAlmacenes(i, j, false);
					break bucle_exterior;
				}
			}

			if (i + 1 == empresa.getAlmacenes().length) System.out.println("NO HAY CONTENEDORES EN EL ALMACEN");
		}
	}

	public static void main(String[] args) {

		char opcion;

		do {
			opcion = menu();

			if (opcion == 'm') meterContenedor();
			else if (opcion == 's') sacarContenedor();
			else System.out.println("SALIENDO DEL PROGRAMA...");
		} while (opcion == 'm' || opcion == 's');
	}
}
