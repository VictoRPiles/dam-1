import java.util.Random;
import java.util.TreeSet;

/**
 * @author Victor
 * @since 09/05/2022 - 14:01
 */
public class Numero {
	public int longitud;
	protected TreeSet<Integer> valor = new TreeSet<>();
	protected int min, max;

	public Numero(int longitud, int min, int max) {
		this.longitud = longitud;
		this.min = min;
		this.max = max;
		generar();
	}

	public Numero(int longitud, int[] valor) {
		this.longitud = longitud;
		for (int i = 0; i < longitud; i++) {
			this.valor.add(valor[i]);
		}
	}

	public void generar() {
		Random rand = new Random();

		for (int i = 0; i < longitud; i++) {
			int random;
			do {
				random = rand.nextInt((max - min) + 1) + min;
			} while (!valor.add(random));
		}
	}

	@Override
	public String toString() {
		return valor.toString();
	}
}