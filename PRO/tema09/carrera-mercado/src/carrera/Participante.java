package carrera;

class Participante implements Comparable<Participante> {
	private int dorsal;
	private String nombre;

	public Participante(int dorsal, String nombre) {
		this.dorsal = dorsal;
		this.nombre = nombre;
	}

	public Participante(int dorsal) {
		this.dorsal = dorsal;
	}

	@Override
	public int compareTo(Participante o) {
		return Integer.compare(this.dorsal, o.dorsal);
	}

	@Override
	public String toString() {
		return "Participante{" +
				"dorsal=" + dorsal +
				", nombre='" + nombre + '\'' +
				'}';
	}
}