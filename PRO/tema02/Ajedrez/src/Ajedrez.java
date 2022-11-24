import java.util.Scanner;

public class Ajedrez {

	/* Enlace -> https://www.aceptaelreto.com/problem/statement.php?id=481&cat=4https://www.aceptaelreto.com/problem/statement.php?id=481&cat=4 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int fila, columna_int;
		char columna_char = 0;

		System.out.println("Introduce los datos");
		while (true) {
			fila = scanner.nextInt();
			columna_int = scanner.nextInt();

			if (fila < 0 || fila > 8) {
				System.out.println("ERROR: Valor incorrecto para fila");
				System.exit(0);
			}

			switch (columna_int) {
				case 1:
					columna_char = 'h';
					break;
				case 2:
					columna_char = 'g';
					break;
				case 3:
					columna_char = 'f';
					break;
				case 4:
					columna_char = 'e';
					break;
				case 5:
					columna_char = 'd';
					break;
				case 6:
					columna_char = 'c';
					break;
				case 7:
					columna_char = 'b';
					break;
				case 8:
					columna_char = 'a';
					break;
				case 0:
					if (fila == 0) {
						System.out.println("CERRANDO PROGRAMA");
						System.exit(0);
					}
				default:
					System.out.println("ERROR: Valor incorrecto para columna");
					System.exit(0);
			}

			StringBuilder resultado = new StringBuilder();
			resultado.append(columna_char);
			resultado.append(fila);
			System.out.println(resultado);
		}
	}
}
