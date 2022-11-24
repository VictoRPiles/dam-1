import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Victor
 * @since 28/04/2022 - 10:12
 */
public class Clinica {
	private final String nombre;
	private HashSet<Cliente> clientes = new HashSet<>();
	private ArrayList<Perro> perrosVacunados = new ArrayList<>();

	public Clinica(String nombre) {
		this.nombre = nombre;
	}

	public boolean addCliente(Cliente c) {
		return clientes.add(c);
	}

	public boolean removeCliente(Cliente c) {
		return clientes.remove(c);
	}

	/**
	 * Busca en {@link #clientes} un {@link Cliente} con el DNI pasado por parámetro.
	 * <p>
	 * Si lo encuentra busca en {@link Cliente#getMascotas()} una mascota con el nombre pasado por parámetro.
	 * <p>
	 * Si no encuentra el Cliente, Mascota o no esta implementa {@link Vacunable} lanza un mensaje de error.
	 */
	public void vacunarPerro(String dni, String nombreMascota) {
		Iterator<Cliente> clienteIterator = clientes.iterator();
		Iterator<Mascota> mascotaIterator;
		Cliente thisCliente = null;
		Mascota thisMascota = null;
		boolean clienteEncontrado = false;
		boolean mascotaEncontrada = false;

		while (clienteIterator.hasNext() && !clienteEncontrado) {
			thisCliente = clienteIterator.next();

			if (thisCliente.getDni().equals(dni)) {
				clienteEncontrado = true;
			} else {
				thisCliente = null;
			}
		}

		if (thisCliente != null) {
			mascotaIterator = thisCliente.getMascotas().iterator();

			while (mascotaIterator.hasNext() && !mascotaEncontrada) {
				thisMascota = mascotaIterator.next();
				if (thisMascota.getNombre().equals(nombreMascota)) {
					if (thisMascota instanceof Perro) {
						System.out.println("Vacunando a " + thisMascota + "...");

						((Mamifero) thisMascota).vacunar();
						perrosVacunados.add((Perro) thisMascota);
					} else if (thisMascota instanceof Mamifero) {
						System.out.println("ERROR: La mascota " + nombreMascota + " es de una especie vacunable, " +
								"pero" +
								" " +
								"no es un perro.");
					} else {
						System.out.println("ERROR: La mascota " + nombreMascota + " no es de una especie vacunable.");
					}

					mascotaEncontrada = true;
				} else {
					thisMascota = null;
				}
			}

			if (thisMascota == null) {
				System.out.println("ERROR: Mascota " + nombreMascota + " no registrada.");
			}

		} else {
			System.out.println("ERROR: Cliente con DNI " + dni + " no registrado.");
		}
	}

	public void printClientes() {
		Iterator<Cliente> clienteIterator = clientes.iterator();

		System.out.println("Clientes de " + this);
		while (clienteIterator.hasNext()) {
			System.out.println("\t" + clienteIterator.next());
		}
	}

	public void printPerrosVacunados() {
		System.out.println("Perros vacunados en " + this);
		for (Perro perroVacunado : perrosVacunados) {
			System.out.println("\t" + perroVacunado);
		}
	}

	@Override
	public String toString() {
		return "Clínica " + nombre;
	}
}