import java.util.Arrays;

/**
 * @author Victor Piles
 * @since 17/01/2022 13:06
 */
public class LogisticaAlmacen {
	private boolean[][] almacenes = new boolean[3][];

	public LogisticaAlmacen() {

		almacenes[0] = new boolean[2]; almacenes[1] = new boolean[4]; almacenes[2] = new boolean[8];
		// El almacén se inicia vacío
		for (int i = 0; i < almacenes.length; i++) {
			Arrays.fill(almacenes[i], false);
		}
	}

	public boolean[][] getAlmacenes() {

		return almacenes;
	}

	public void setAlmacenes(int i, int j, boolean valor) {

		this.almacenes[i][j] = valor;
	}
}
