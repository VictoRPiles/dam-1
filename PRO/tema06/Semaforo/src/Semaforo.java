/**
 * @author Victor Piles
 * @since 10/01/2022 14:08
 */
public class Semaforo {
	private String estadoSemaforo = "rojo";

	public void setColor(String color) {

		estadoSemaforo = color.toLowerCase();
	}

	public String getColor() {

		return estadoSemaforo;
	}
}
