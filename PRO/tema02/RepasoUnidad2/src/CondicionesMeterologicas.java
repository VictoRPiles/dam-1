import java.util.Scanner;

public class CondicionesMeterologicas {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean llueve, sol, regar, abonar;
		int diasRiego, diasAbono;

		System.out.print("Llueve -> "); llueve = scanner.nextBoolean();
		System.out.print("Sol -> "); sol = scanner.nextBoolean();
		System.out.print("Dias Riego -> "); diasRiego = scanner.nextInt();
		System.out.print("Dias Abono -> "); diasAbono = scanner.nextInt();

		if (llueve || sol || (diasRiego < 5)) {
			regar = false;
			abonar = false;
		} else if (diasAbono < 10) {
			regar = true;
			abonar = false;
		} else {
			regar = true;
			abonar = true;
		}

		System.out.println("Regar -> " + regar);
		System.out.println("Abonar -> " + abonar);
	}
}
