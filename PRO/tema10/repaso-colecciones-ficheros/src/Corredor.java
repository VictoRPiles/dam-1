/**
 * @author Victor
 * @since 13/05/2022 - 9:25
 */
public class Corredor implements Comparable<Corredor> {
	private final int dorsal;
	private String nombre;

	public Corredor(int dorsal) {
		this.dorsal = dorsal;
	}

	public Corredor(int dorsal, String nombre) {
		this.dorsal = dorsal;
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Corredor c) {
		return Integer.compare(dorsal, c.dorsal);
	}

	@Override
	public int hashCode() {
		int result = dorsal;
		result = 31 * result;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Corredor corredor = (Corredor) o;

		return dorsal == corredor.dorsal;
	}

	@Override
	public String toString() {

		return String.format("""
				<corredor>
				<dorsal>%d</dorsal>
				<nombre>%s</nombre>
				</corredor>
				""", dorsal, nombre);
	}
}