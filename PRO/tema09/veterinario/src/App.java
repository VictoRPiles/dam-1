import java.time.LocalDate;

/**
 * @author Victor
 * @since 28/04/2022 - 10:13
 */
public class App {
	public static void main(String[] args) {
		Clinica clinica1 = new Clinica("Clinica 1");
		Clinica clinica2 = new Clinica("Clinica 2");

		Cliente cliente1 = new Cliente("11111111A", "Cliente 1", "Numero uno");
		Cliente cliente2 = new Cliente("22222222B", "Cliente 2", "Numero dos");
		Cliente cliente3 = new Cliente("33333333C", "Cliente 3", "Numero tres");

		/* Casos de prueba con ID correcto */
		Perro mascota1 = new Perro(1, "Perro 1", null, false);
		Ave mascota3 = new Ave(2, "Ave 1", 20);
		Pez mascota4 = new Pez(10, "Pez 1");
		Mamifero mascota5 = new Mamifero(3, "Mamifero 1", null, false);
		/* Casos de prueba con ID repetido */
		Perro mascota2 = new Perro(1, "Perro 2", LocalDate.now(), Especie.PERRO, LocalDate.now(), true);

		/* Añadiendo clientes a las clínicas */
		clinica1.addCliente(cliente1);
		clinica1.addCliente(cliente2);
		clinica2.addCliente(cliente1);
		clinica2.addCliente(cliente3);

		/* Añadiendo mascotas a los clientes */
		cliente1.addMascota(mascota1);
		cliente1.addMascota(mascota2);
		cliente1.addMascota(mascota5);
		cliente2.addMascota(mascota3);
		cliente3.addMascota(mascota4);

		System.out.println();
		/* Print clientes */
		clinica1.printClientes();
		clinica2.printClientes();

		/* Se borra cliente 2 + Print clientes */
		clinica1.removeCliente(cliente2);
		clinica1.printClientes();

		System.out.println();
		/* Casos de prueba correctos */
		clinica1.vacunarPerro("11111111A", "Perro 1");
		clinica1.vacunarPerro("11111111A", "Perro 2");
		clinica2.vacunarPerro("11111111A", "Perro 1");
		/* Casos de prueba con mensajes de error */
		clinica1.vacunarPerro("11111111A", "Perro Desconocido");
		clinica1.vacunarPerro("11111111A", "Mamifero 1");
		clinica1.vacunarPerro("22222222B", "Ave 1");
		clinica2.vacunarPerro("33333333C", "Pez 1");

		System.out.println();
		/* Print perros vacunados */
		clinica1.printPerrosVacunados();
		clinica2.printPerrosVacunados();
	}
}