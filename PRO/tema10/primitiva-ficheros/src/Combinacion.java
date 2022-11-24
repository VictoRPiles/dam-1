import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Victor
 * @since 09/05/2022 - 14:11
 */
public class Combinacion {
	private Numero numeroGanador;
	private Numero numeroReintegro;

	public Combinacion() {
		numeroGanador = new Numero(6, 1, 49);
		numeroReintegro = new Numero(1, 0, 9);
	}

	public Combinacion(Numero numeroGanador, Numero numeroReintegro) {
		this.numeroGanador = numeroGanador;
		this.numeroReintegro = numeroReintegro;
	}

	public Numero getNumeroGanador() {
		return numeroGanador;
	}

	public Numero getNumeroReintegro() {
		return numeroReintegro;
	}

	@Override
	public boolean equals(Object otro) {
		if (otro instanceof Combinacion) {
			Iterator<Integer> thisIterator = this.numeroGanador.valor.iterator();
			Iterator<Integer> otroIterator = ((Combinacion) otro).numeroGanador.valor.iterator();

			if (!(this.numeroGanador.longitud == ((Combinacion) otro).numeroGanador.longitud)) {
				return false;
			}

			while (thisIterator.hasNext()) {
				if (!thisIterator.next().equals(otroIterator.next())) {
					return false;
				}
			}

			thisIterator = this.numeroReintegro.valor.iterator();
			otroIterator = ((Combinacion) otro).numeroReintegro.valor.iterator();

			if (!(this.numeroReintegro.longitud == ((Combinacion) otro).numeroReintegro.longitud)) {
				return false;
			}

			while (thisIterator.hasNext()) {
				if (!thisIterator.next().equals(otroIterator.next())) {
					return false;
				}
			}

			return true;
		}

		return super.equals(otro);
	}

	@Override
	public String toString() {
		return numeroGanador +
				", Reintegro -> " + numeroReintegro;
	}

	public void exportar(File fichero) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fichero, true));

			bw.write(this + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}