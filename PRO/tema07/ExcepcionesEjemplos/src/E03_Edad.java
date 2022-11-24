import java.util.Scanner;

/**
 * @author Victor Piles
 * @since 10/02/2022 11:55
 */
class Persona {

	String nombre;
	int edad;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) throws Exception {
		if (!(edad > 0 && edad < 100)) throw new Exception("Edad incorrecta");

		this.edad = edad;
	}

	@Override
	public String toString() {
		return String.format("Nombre: %s | Edad: %d", nombre, edad);
	}
}

public class E03_Edad {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Persona persona = new Persona(scanner.nextLine());

		while (true) {
			try {
				persona.setEdad(scanner.nextInt());
				System.out.println(persona);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
