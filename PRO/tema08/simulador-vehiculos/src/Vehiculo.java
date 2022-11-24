public class Vehiculo {
	private String matricula;
	protected double velocidad;

	public Vehiculo(String matricula) {
		this.matricula = matricula;
		this.velocidad = 0;
	}

	public void acelerar(double kmh) throws DemasiadoRapidoException {
		this.velocidad += (kmh > 0) ? kmh : 0;
	}

	@Override
	public String toString() {
		return "Vehiculo{" +
				"matricula='" + matricula + '\'' +
				", velocidad=" + velocidad +
				'}';
	}
}
