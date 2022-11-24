import java.util.Arrays;

public class ListaMultimedia {
	private Multimedia[] listaMultimedia;
	private int contador;

	public ListaMultimedia(int contador) {
		this.listaMultimedia = new Multimedia[contador];
		this.contador = contador;
	}

	public int size() {
		int enLista = 0;
		for (Multimedia multimedia : listaMultimedia) {
			if (multimedia != null) enLista++;
		}
		return enLista;
	}

	public boolean add(Multimedia m) {
		try {
			listaMultimedia[size()] = m;
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	public Multimedia get(int posicion) {
		return listaMultimedia[posicion];
	}

	public int indexOf(Multimedia m) {
		int i = -1;
		try {
			//noinspection StatementWithEmptyBody (cosas de mi IDE)
			while (listaMultimedia[++i] != m) ;
		} catch (NullPointerException e) {
			System.out.println("No hay elementos en la lista");
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}

		return i;
	}

	/** @see Multimedia#compareTo(Object) */
	public void sort() {
		Arrays.sort(listaMultimedia);
	}

	@Override
	public String toString() {
		StringBuilder elementosToString = new StringBuilder();
		for (int i = 0; i < this.size(); i++) {
			elementosToString.append(listaMultimedia[i]).append("\n");
		}

		return elementosToString.toString();
	}
}