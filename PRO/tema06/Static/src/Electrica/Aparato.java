package Electrica;

/**
 * @author Victor Piles
 * @since 21/01/2022 8:57
 */
public class Aparato {

	private final double potencia;
	private double consumo;
	private Boolean esOnOff = false;
	private static double consumoTotal;

	public Aparato(double consumo) {
		this.consumo = consumo;
		potencia = consumo;
	}

	/**
	 * Establece la potencia
	 *
	 * @param consumo
	 * 		Siempre será 0 (apagado) o {@link #potencia} (encendido),
	 * 		para garantizar esto, solo se puede acceder al método desde otros métodos de la clase
	 */
	private void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public static void setConsumoTotal(double consumo) {
		Aparato.consumoTotal += consumo;
	}

	public static double getConsumoTotal() {
		return consumoTotal;
	}

	/**
	 * Establece el estado del aparato, ajusta su {@link #potencia} y actualiza el {@link #consumoTotal}
	 * Si el estado actual es el mismo que el pasado por parámetro no hace nada
	 * Si no, cambia su estado y actualiza su {@link #potencia}
	 *
	 * @param esOnOff
	 * 		true para encendido, false para apagado
	 */
	public void setEsOnOff(Boolean esOnOff) {
		if (this.esOnOff != esOnOff) {
			this.esOnOff = esOnOff;

			if (this.esOnOff) {
				setConsumoTotal(potencia);
				setConsumo(potencia);
			} else {
				setConsumoTotal(-potencia);
				setConsumo(0);
			}
		}
	}

	public static String toStringAparato() {
		return String.format("Consumo total actual -> %8.2fW", getConsumoTotal());
	}
}
