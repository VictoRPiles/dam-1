import java.util.Scanner;

public class Ej02_Departamentos {
	public static void main(String[] args) {
		byte    num_departamento;
		int[]   departamentos = {0, 0, 0};
		boolean esDepartamento;
		Scanner scanner       = new Scanner(System.in);

		do {
			System.out.print("Numero de departamento [1,2,3] -> ");
			num_departamento = scanner.nextByte();

			switch (num_departamento) {
				case 1, 2, 3:
					departamentos[num_departamento - 1]++;
					esDepartamento = true;
					break;
				default:
					esDepartamento = false;
					break;
			}
		} while (esDepartamento);

		for (int i = 0; i < departamentos.length; i++) {
			System.out.printf("VENTAS DEPARTAMENTO %d -> %02d\n", (i + 1), departamentos[i]);
		}
	}
}
