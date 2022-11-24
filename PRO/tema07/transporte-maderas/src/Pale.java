public class Pale {
	private final float VOLUMEN = 2.27f;
	private float peso;
	private Maderas tipoMadera;

	public Pale(Maderas tipoMadera) {
		this.tipoMadera = tipoMadera;
		this.setPeso();
	}

	public void setPeso() {
		this.peso = tipoMadera.getPESO() * VOLUMEN;
	}

	@Override
	public String toString() {
		return String.format("TIPO -> %-6s | COLOR -> %-15s | PESO PALE -> %.2f Kg", tipoMadera, tipoMadera.getCOLOR(), peso);
	}
}
