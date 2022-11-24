import java.util.Scanner;

/**
 * @author Victor Piles
 * @since 28/01/2022 9:54
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Aparcamiento a1 = new Aparcamiento(5);
		Puerta p1 = new Puerta(a1);
		Puerta p2 = new Puerta(a1);
		Puerta p = null;

		int puertaElegida;
		boolean puertaCorrecta = false;
		boolean salir = false;
		char opcion;

		while (!salir) {
			System.out.printf("%s\n", a1);

			while (!puertaCorrecta) {
				Puerta.verPuertas();
				System.out.println("Cerrar programa -1");

				puertaElegida = scanner.nextInt();

				if (puertaElegida == -1) {
					System.out.println("SALIENDO");
					puertaCorrecta = true; // para no utilizar un break...
					salir = true;
					//break;
				} else if (puertaElegida < 0 || puertaElegida > Puerta.getInstancias().size() - 1) {
					System.out.println("ERROR: Puerta incorrecta");
					puertaCorrecta = false;
				} else {
					p = Puerta.elegirPuerta(puertaElegida);
					puertaCorrecta = true;
				}
			}

			if (puertaCorrecta && !salir) {
				opcion = p.entrarSalir();
				if (opcion == 'A') p.aparcarCoche();
				else if (opcion == 'S') p.sacarCoche();
			}

			puertaCorrecta = false;
		}
	}
}
