import java.util.Scanner;

/**
 * @author Victor
 * @since 12/05/2022 - 11:25
 */
public class App {
	public static void main(String[] args) {
		if (GestionPalabras.load()) {
			System.out.println("Cargando palabras desde el archivo...");
		}

		while (menu()) ;
	}

	public static Boolean menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== AHORCADO =====");
		System.out.println("1) Gestion de palabras");
		System.out.println("2) Jugar");
		System.out.println("3) Salir");
		System.out.print("> ");
		switch (scanner.nextInt()) {
			case 1 -> {while (GestionPalabras.menu()) ;}
			case 2 -> Ahorcado.jugar();
			case 3 -> {
				System.out.println("Cerrando ahorcado...");
				return false;
			}
			default -> {
				System.out.println("Opción no valida.");
				return menu();
			}
		}
		return true;
	}
}