enum Generos {rock, pop, punk, blues, jazz};

public class Disco extends Multimedia {

	private Generos genero;

	public Disco(String titulo, String autor, Formatos formato, float duracion) {
		super(titulo, autor, formato, duracion);
	}

	public Disco(String titulo, String autor, Formatos formato, float duracion, Generos genero) {
		super(titulo, autor, formato, duracion);
		this.genero = genero;
	}

	public Generos getGenero() {
		return genero;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", Género -> %s", genero);
	}
}
