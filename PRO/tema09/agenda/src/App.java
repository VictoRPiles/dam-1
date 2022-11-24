import java.util.Scanner;

public class App {
	static int menu() {
		Scanner scanner = new Scanner(System.in);
		int op;

		System.out.println("Selecciona una opción");
		System.out.println("1) Añadir contacto");
		System.out.println("2) Borrar contacto");
		System.out.println("3) Buscar contacto");
		System.out.println("4) Visualizar contactos");
		System.out.println("5) Salir");
		System.out.print("> ");

		return switch (op = scanner.nextInt()) {
			case 1, 2, 3, 4, 5 -> op;
			default -> menu();
		};
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			switch (menu()) {
				case 1 -> {
					System.out.print("Introduce el nombre y el teléfono\n> ");
					Agenda.add(new Contacto(scanner.next(), scanner.nextInt()));
				}
				case 2 -> {
					System.out.print("Introduce el nombre del contacto\n> ");
					Agenda.remove(Agenda.get(scanner.next()));
				}
				case 3 -> {
					System.out.print("Introduce el nombre del contacto\n> ");
					System.out.println(Agenda.get(scanner.next()));
				}
				case 4 -> Agenda.print();
				default -> {
					System.out.println("Saliendo...");
					salir = true;
				}
			}
		}
	}
}