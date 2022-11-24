public class Multimedia implements Comparable {
	private String titulo, autor;
	private Formatos formato;
	private float duracion;

	public Multimedia(String titulo, String autor, Formatos formato, float duracion) {
		this.titulo = titulo;
		this.autor = autor;
		this.formato = formato;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Formatos getFormato() {
		return formato;
	}

	public float getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return String.format("Titulo -> %s, Autor -> %s, Formato -> %s, Duración -> %.2f", titulo, autor, formato, duracion);
	}

	public boolean equals(Multimedia obj) {
		return ((this.autor.equals(obj.autor)) && (this.titulo.equals(obj.titulo)));
	}

	@Override
	public int compareTo(Object o) {
		if (this.duracion > ((Multimedia) o).getDuracion()) return 1;
		else if (this.duracion < ((Multimedia) o).getDuracion()) return -1;
		else return 0;
	}
}