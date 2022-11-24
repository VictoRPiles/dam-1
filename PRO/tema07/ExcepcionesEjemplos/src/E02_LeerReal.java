import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Victor Piles
 * @since 10/02/2022 11:40
 */
public class E02_LeerReal {

	private static float leerReal() throws Exception {
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		float real = 0;

		try {
			real = scanner.nextFloat();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: No has introducido un numero o no tiene formato correcto");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("ERROR: Desconocido");
			throw new Exception();
		}

		return real;
	}

	public static void main(String[] args) {
		float valor = 0;
		boolean continuar = true;

		do {
			try {
				System.out.print("Valor Real con .: ");
				valor = leerReal();
				continuar = false;
			} catch (Exception e) {
				System.out.println("Introduce un valor correcto");
			}
		} while (continuar);

		System.out.println("Valor real: " + valor);
	}
}
