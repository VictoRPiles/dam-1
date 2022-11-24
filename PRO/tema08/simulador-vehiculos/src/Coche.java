public class Coche extends Vehiculo {
	private byte puertas;

	public Coche(String matricula, byte puertas) {
		super(matricula);
		this.puertas = puertas;
	}

	public byte getPuertas() {
		return puertas;
	}

	@Override
	public String toString() {
		return "Coche{" +
				"puertas=" + puertas +
				"} " + super.toString();
	}
}
