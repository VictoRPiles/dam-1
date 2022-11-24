import java.util.Scanner;

/**
 * @author Victor Piles
 * @since 24/02/2022 9:51
 */
public class Main {

	public static int menu() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("1) ROJO\n2) AMARILLO\n3) VERDE\n> ");

		switch (scanner.nextInt()) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			default:
				System.out.println("ERROR: Estado no válido"); return menu();
		}
	}

	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();

		semaforo.setEstado(menu());
		System.out.println(semaforo);
	}
}
