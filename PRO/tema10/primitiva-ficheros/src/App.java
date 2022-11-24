import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Victor
 * @since 09/05/2022 - 13:54
 */
public class App {
	static ArrayList<Combinacion> combinaciones = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		File exp = new File("combinaciones.txt");

		while (menu()) {
			jugar();
		}

		System.out.printf("Exportando combinaciones a %s ...\n", exp.getPath());
		for (Combinacion combinacion : combinaciones) {
			combinacion.exportar(exp);
		}

		System.out.println("Cerrando programa...");
	}

	private static boolean menu() {
		System.out.println("===== PRIMITIVA =====");
		System.out.println("1) Jugar y sorteo");
		System.out.println("2) Salir");
		System.out.print("> ");

		return switch (scanner.nextInt()) {
			case 1 -> true;
			case 2 -> false;
			default -> menu();
		};
	}

	private static void printCombinacion(Combinacion combinacion) {
		System.out.printf("(%d) -> ", combinaciones.size());
		System.out.println(combinacion);
	}

	private static void jugar() {
		int[] valor;
		int reintegro;

		Combinacion combinacion = new Combinacion();
		combinaciones.add(combinacion);

		printCombinacion(combinacion);

		System.out.println("Introduce tu numero");
		valor = new int[combinacion.getNumeroGanador().longitud];
		for (int i = 0; i < valor.length; i++) {
			System.out.print("Valor " + (i + 1) + " -> ");
			valor[i] = scanner.nextInt();
		}

		System.out.print("Reintegro -> ");
		reintegro = scanner.nextInt();

		Numero numeroGanador = new Numero(valor.length, valor);
		Numero numeroReintegro = new Numero(1, new int[]{reintegro});

		System.out.println(combinacion.equals(new Combinacion(numeroGanador, numeroReintegro))
				? "Felicidades, has acertado"
				: "No has acertado, otra vez será");

	}
}