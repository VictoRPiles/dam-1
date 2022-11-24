public abstract class Vehiculo implements Comparable<Vehiculo> {
	private final String matricula;
	private final String modelo;
	private final String color;

	public Vehiculo(String matricula, String modelo, String color) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehiculo{" +
				"tipo='" + getClass().getName() + '\'' +
				", matricula='" + matricula + '\'' +
				", modelo='" + modelo + '\'' +
				", color='" + color + '\'' +
				'}';
	}

	/**
	 * Compara dos vehículos por su matrícula, si tienen la misma, compara por modelo.
	 */
	@Override
	public int compareTo(Vehiculo v) {

		if (this.matricula.equals(v.matricula)) return this.modelo.compareTo(v.modelo);

		return this.matricula.compareTo(v.matricula);
	}
}