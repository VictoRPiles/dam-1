public class Camion extends Vehiculo {
	private Remolque remolque = null;

	public Camion(String matricula) {
		super(matricula);
	}

	public void ponerRemolque(Remolque remolque) {
		if (this.remolque == null) this.remolque = remolque;
	}

	public void quitarRemolque(Remolque remolque) {
		if (remolque != null) remolque = null;
	}

	@Override
	public void acelerar(double kmh) throws DemasiadoRapidoException {
		super.acelerar(kmh);
		if (remolque != null && velocidad > 100) throw new DemasiadoRapidoException();
	}

	@Override
	public String toString() {
		return "Camion{" +
				"remolque=" + remolque +
				"} " + super.toString();
	}
}
