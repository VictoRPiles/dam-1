import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Victor
 * @since 13/05/2022 - 9:24
 */
public class App {
	public static void main(String[] args) {
		while (menu(new Carrera())) ;
	}

	private static boolean menu(Carrera carrera) {
		Scanner scanner = new Scanner(System.in);
		int dorsal;
		String nombre;

		System.out.println("===== CARRERA =====");
		System.out.println("1) Añadir corredor");
		System.out.println("2) Borrar corredor");
		System.out.println("3) Ver corredores");
		System.out.println("4) Exportar corredores");
		System.out.println("5) Salir");
		System.out.print("> ");

		switch (scanner.nextInt()) {
			case 1 -> {
				System.out.print("Introduce el dorsal -> ");
				dorsal = scanner.nextInt();
				scanner.nextLine(); /* limpiar buffer */
				System.out.print("Introduce el nombre -> ");
				nombre = scanner.nextLine();

				if (carrera.add(new Corredor(dorsal, nombre))) {
					System.out.println("Añadiendo corredor...");
				} else System.out.println("El corredor ya existe...");

				return true;
			}
			case 2 -> {
				System.out.print("Introduce el dorsal -> ");
				dorsal = scanner.nextInt();

				if (carrera.remove(new Corredor(dorsal))) {
					System.out.println("Borrando corredor...");
				} else System.out.println("El corredor no existe...");

				return true;
			}
			case 3 -> {
				System.out.println(carrera);

				return true;
			}
			case 4 -> {
				System.out.print("Introduce la ruta al archivo de exportación -> ");
				scanner.nextLine(); /* limpiar buffer */
				String ruta = scanner.nextLine();

				try {
					carrera.exportar(new File(ruta));
				} catch (IOException e) {
					System.out.println("Fallo al exportar los datos al fichero.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				return true;
			}
			case 5 -> {
				System.out.println("Cerrando programa...");
				return false;
			}
			default -> {
				System.out.println("Opción incorrecta");
				return menu(carrera);
			}
		}
	}
}