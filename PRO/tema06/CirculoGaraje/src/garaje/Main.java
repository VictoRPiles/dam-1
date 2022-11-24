package garaje;

/**
 * @author Victor Piles
 * @since 31/01/2022 13:49
 */
public class Main {

	public static void main(String[] args) {
		Garaje garaje = new Garaje();
		Coche c1 = new Coche("Ford", "Focus");
		Coche c2 = new Coche("Audi", "A1");

		System.out.printf("¿El coche 1 puede entrar? %b\n", Garaje.aceptarCoche(c1, "faros"));
		System.out.printf("¿El coche 2 puede entrar? %b\n", Garaje.aceptarCoche(c2, "aceite"));
		Garaje.devolverCoche();
		System.out.printf("¿El coche 2 puede entrar? %b\n", Garaje.aceptarCoche(c2, "aceite"));
		Garaje.devolverCoche();
		System.out.printf("¿El coche 2 puede entrar? %b\n", Garaje.aceptarCoche(c2, "aceite"));
		System.out.printf("¿El coche 1 puede entrar? %b\n", Garaje.aceptarCoche(c1, "faros"));
		Garaje.devolverCoche();
		System.out.printf("¿El coche 1 puede entrar? %b\n", Garaje.aceptarCoche(c1, "faros"));
		Garaje.devolverCoche();

		System.out.println(c1);
		System.out.println(c2);
	}
}
