import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Victor
 * @since 06/05/2022 - 13:35
 */
public class Clinica {
	private static HashSet<Cliente> clientes = new HashSet<>();
	private static ArrayList<Perro> perrosVacunados = new ArrayList<>();

	/** Escribe la información de los perros vacunados en el fichero de texto. */
	public static void exportarPerrosVacunados() {
		File fichero = new File("exportaciones/perros-vacunados.txt");
		if (!new File("exportaciones").exists()) {
			if (new File("exportaciones").mkdir()) System.out.println("Creando la carpeta exportaciones...");
		}

		for (Cliente cliente : clientes) {
			Perro thisPerro = null;
			BufferedWriter bufferedWriter = null;

			for (Mascota mascota : cliente.getMascotas()) {
				if (mascota instanceof Perro && perrosVacunados.contains(mascota)) {
					thisPerro = (Perro) mascota;
				}

				try {
					bufferedWriter = new BufferedWriter(new FileWriter(fichero, true));

					if (thisPerro != null) {
						bufferedWriter.write(cliente + " | " + thisPerro + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (bufferedWriter != null) bufferedWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static boolean addCliente(Cliente cliente) {
		return clientes.add(cliente);
	}

	public static Cliente getCliente(String DNI) {

		for (Cliente cliente : clientes) {
			if (cliente.equals(new Cliente(DNI, ""))) {
				return cliente;
			}
		}

		return null;
	}

	public static Perro getPerro(String DNI, String ID) {

		Cliente cliente = getCliente(DNI);

		if (cliente != null) {
			for (Mascota mascota : cliente.getMascotas()) {
				if (mascota instanceof Perro && mascota.equals(new Mascota(ID, ""))) {
					return (Perro) mascota;
				}
			}
		}

		return null;
	}

	public static void vacunarPerro(Perro perro) {
		perro.vacunar();
		perrosVacunados.add(perro);
	}

	public static HashSet<Cliente> getClientes() {
		return clientes;
	}

	public static void addPerroVacunado(Perro perro) {
		perrosVacunados.add(perro);
	}
}