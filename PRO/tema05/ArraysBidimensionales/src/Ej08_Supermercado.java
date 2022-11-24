import java.util.ArrayList;
import java.util.Scanner;

/**
 * 8.- En un supermercado se ha decidido controlar las horas de entrada de los
 * trabajadores de los distintos departamentos de la empresa (panadería,
 * carnicería, perfumería, verdulería, charcutería, almacén, ventas), con el objeto
 * de ajustar los horarios en función de la demanda de clientes en las horas de
 * apertura al público del establecimiento. Para hacer la estadística se han creado
 * unas plantillas identificando a un empleado por el número de departamento
 * (filas) y el número de empleado(columnas):
 * <p>
 * Se desea saber:
 * <p>
 * a) Relación de todos los empleados que llegaron antes de una hora dada
 * por el usuario, identificados por el nº de dpto. y el nº de empleado. Por
 * ejemplo si la hora introducida fuera 9.00, en relación a los datos
 * anteriores, el programa devolvería: 00, 01, 10, 20, 32, 33, 52, 64
 * <p>
 * b) Número de empleados total que se encontraban trabajando en
 * el establecimiento entre un intervalo de horas dadas por el usuario.
 * Por ejemplo, si el intervalo de horas fuera entre las 7.00 y las 8.00 el
 * resultado del programa sería 8
 * <p>
 * c) Número de empleados de cada uno de los departamentos que
 * se encontraban en el establecimiento a una hora dada. Por ejemplo, si la
 * hora dada por el usuario fuera las 9.00, el resultado del programa sería:
 * <p>
 * • Panadería: 2
 * <p>
 * • Carnicería: 1
 * <p>
 * • Perfumería: 1
 * <p>
 * • Verdulería: 3
 * <p>
 * • Charcutería: 0
 * <p>
 * • Almacén: 1
 * <p>
 * • Ventas: 2
 * <p>
 * Para ello el programa mostrará un menú con las opciones dadas y otra para
 * salir del programa.
 */
public class Ej08_Supermercado {
	static Scanner scanner = new Scanner(System.in);

	/**
	 * Almacena en el ArrayList el índice de los trabajadores que ficharon antes de una hora determinada
	 *
	 * @param matriz
	 */
	public static void antesDeHora(double[][] matriz) {
		ArrayList<String> resultado = new ArrayList<String>();
		double hora;

		System.out.print("Introduce la hora -> "); hora = scanner.nextDouble();

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] < hora) {
					resultado.add("" + i + j);
				}
			}
		}

		System.out.println(resultado.toString());
	}

	/**
	 * Almacena la cantidad de trabajadores que ficharon entre un intervalo de horas
	 *
	 * @param matriz
	 */
	public static void intervaloHoras(double[][] matriz) {
		int contador = 0;
		double horaLlegada, horaSalida;

		System.out.print("Introduce la hora de llegada -> "); horaLlegada = scanner.nextDouble();
		System.out.print("Introduce la hora de salida -> "); horaSalida = scanner.nextDouble();

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] > horaLlegada && matriz[i][j] < horaSalida) {
					contador++;
				}
			}
		}

		System.out.println(contador);
	}

	/**
	 * Muestra cuantos trabajadores de cada departamento estaban trabajando en una hora determinada
	 *
	 * @param matriz
	 */
	public static void departamentosHora(double[][] matriz) {
		int[] trabaDepart = new int[matriz.length];
		double hora;

		System.out.print("Introduce la hora -> "); hora = scanner.nextDouble();

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] <= hora) {
					trabaDepart[i]++;
				}
			}
		}
		for (int i = 0; i < trabaDepart.length; i++) {
			switch (i) {
				case 0:
					System.out.printf("Panadería -> %d\n", trabaDepart[i]);
					break;
				case 1:
					System.out.printf("Carnicería -> %d\n", trabaDepart[i]);
					break;
				case 2:
					System.out.printf("Perfumería -> %d\n", trabaDepart[i]);
					break;
				case 3:
					System.out.printf("Verdulería -> %d\n", trabaDepart[i]);
					break;
				case 4:
					System.out.printf("Charcutería -> %d\n", trabaDepart[i]);
					break;
				case 5:
					System.out.printf("Almacén -> %d\n", trabaDepart[i]);
					break;
				case 6:
					System.out.printf("Ventas -> %d\n", trabaDepart[i]);
					break;
			}
		}
	}

	public static void main(String[] args) {
		boolean opcionValida = true;
		double[][] departamentos = {
				{07.30, 07.35, 09.30, 09.30, 09.30, 13.00}, // PANADERÍA
				{07.30, 12.30, 13.06, 17.17, 19.00, 09.32}, // CARNICERÍA
				{07.30, 12.00, 13.27, 15.40, 17.07, 18.00}, // PERFUMERÍA
				{09.00, 13.06, 07.30, 07.30, 09.30, 17.07}, // VERDULERÍA
				{09.14, 09.30, 17.07, 13.06, 15.40, 15.40}, // CHARCUTERÍA
				{12.30, 17.07, 07.30, 09.30, 15.40, 13.06}, // ALMACÉN
				{09.00, 09.30, 13.06, 17.07, 07.30, 09.30}  // VENTAS
		};

		do {
			System.out.println("Antes de hora (1)\nIntervalo de horas (2)\nDepartamentos horas (3)\nSalir (4)");

			switch (scanner.nextInt()) {
				case 1:
					antesDeHora(departamentos);
					break;
				case 2:
					intervaloHoras(departamentos);
					break;
				case 3:
					departamentosHora(departamentos);
					break;
				default:
					System.out.println("SALIENDO...");
					opcionValida = false;
					break;
			}
		} while (opcionValida);
	}
}
