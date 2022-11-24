package garaje;

/**
 * @author Victor Piles
 * @since 31/01/2022 13:37
 */
public class Motor {

	private int litrosAceite;
	private final int caballos;

	public Motor(int caballos) {
		this.litrosAceite = 0;
		this.caballos = caballos;
	}

	public int getLitrosAceite() {
		return litrosAceite;
	}

	/**
	 * Incrementa los litros de aceite en averias
	 * @see Garaje#checkAveriaAsociada(String) 
	 */
	public void setLitrosAceite(int litrosAceite) {
		this.litrosAceite += litrosAceite;
	}

	public int getCaballos() {
		return caballos;
	}
}
