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
			if (multimedia != null)
				enLista++;
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
			// noinspection StatementWithEmptyBody (cosas de mi IDE)
			while (listaMultimedia[++i] != m)
				;
		} catch (NullPointerException e) {
			System.out.println("No hay elementos en la lista");
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}

		return i;
	}

	/**
	 * @return Duración total de los objetos de la ListaMultimedia.
	 */
	public double duracionTotal() {
		double duracion = 0;
		for (Multimedia multimedia : listaMultimedia) {
			if (multimedia == null) break;

			duracion += multimedia.getDuracion();
		}

		return duracion;
	}

	/**
	 * @return Cuántos discos hay de rock.
	 */
	public int getDiscosRock() {
		int cantidad = 0;

		for (Multimedia multimedia : listaMultimedia) {
			if (multimedia == null) break;

			if (multimedia instanceof Disco && ((Disco) multimedia).getGenero() == Generos.rock)
				cantidad++;
		}

		return cantidad;
	}

	/**
	 * @return Cuántas películas no tienen actriz principal.
	 */
	public int sinActriz() {
		int cantidad = 0;

		for (Multimedia multimedia : listaMultimedia) {
			if (multimedia == null) break;

			if (multimedia instanceof Pelicula && ((Pelicula) multimedia).getActrizPrincipal() == null)
				cantidad++;
		}

		return cantidad;
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
