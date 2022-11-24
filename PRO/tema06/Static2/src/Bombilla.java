/**
 * @author Victor Piles
 * @since 27/01/2022 11:17
 * <p>
 * Se desea representar las bombillas que pueda haber en una casa. Cada
 * bombilla tiene asociada un interruptor y solo uno. Así mismo, existe un
 * interruptor general de la casa. Un interruptor tiene dos estados, ON y OFF.
 * Una bombilla luce si el interruptor general de la casa está ON y su
 * interruptor asociado también. Escribe una clase de nombre Bombilla que
 * permita modelar la información anterior. Para ello, la clase dispondrá de:
 * <ul>
 *     <li>Un método para cambiar el estado del interruptor de la bombilla.</li>
 *     <li>Un método para cambiar el estado del interruptor general de la casa.</li>
 *     <li>Un método que determina si una bombilla está luciendo o no.</li>
 * </ul>
 * Escribe un programa que utilice la clase Bombilla del apartado anterior.
 * Para ello, se creará una Bombilla y se visualizará por pantalla si luce o no.
 * Luego se pulsa el interruptor de la Bombilla y se vuelve a visualizar el
 * estado de la misma. Por último, se pulsa el interruptor general y se visualiza
 * el estado.
 */
public class Bombilla {

	private static boolean esOnOffGeneral = false;
	private boolean esOnOffBombilla;

	public Bombilla() {
		this.esOnOffBombilla = false;
	}

	public static boolean isEsOnOffGeneral() {
		return esOnOffGeneral;
	}

	/**
	 * Cambia el estado del interruptor general
	 */
	public static void setEsOnOffGeneral() {
		if (esOnOffGeneral) {
			System.out.println("Apagando interruptor general...");
			esOnOffGeneral = false;
		} else {
			System.out.println("Encendiendo interruptor general...");
			esOnOffGeneral = true;
		}
	}

	public boolean isEsOnOffBombilla() {
		return esOnOffBombilla;
	}

	/**
	 * Cambia el estado del interruptor de bombilla
	 */
	public void setEsOnOffBombilla() {
		if (this.esOnOffBombilla) {
			System.out.println("Apagando interruptor de bombilla...");
			this.esOnOffBombilla = false;
		} else {
			System.out.println("Encendiendo interruptor de bombilla...");
			this.esOnOffBombilla = true;
		}
	}

	/**
	 * Si {@link #esOnOffBombilla} y {@link #esOnOffGeneral} estan encendidos la bombilla está luciendo
	 */
	public boolean estaLuciendo() {
		return (isEsOnOffBombilla() && isEsOnOffGeneral());
	}

	@Override
	public String toString() {
		if (estaLuciendo()) {return "La bombilla está luciendo";} else return "La bombilla no está luciendo";
	}
}

