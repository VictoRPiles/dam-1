import java.util.Scanner;

public class Pelicula extends Multimedia {
	private String actorPrincipal, actrizPrincipal;

	public Pelicula(String titulo, String autor, Formatos formato, float duracion) {
		super(titulo, autor, formato, duracion);
		setActores(actorPrincipal, actrizPrincipal);
	}

	public Pelicula(String titulo, String autor, Formatos formato, float duracion, String actorPrincipal,
					String actrizPrincipal) {
		super(titulo, autor, formato, duracion);
		this.actorPrincipal = actorPrincipal;
		this.actrizPrincipal = actrizPrincipal;
	}

	private void setActores(String actorPrincipal, String actrizPrincipal) {
		Scanner scanner = new Scanner(System.in);

		while (actorPrincipal == null && actrizPrincipal == null) {

			System.out.println("Introduce un valor para al menos un actor");

			System.out.print("Introducir actor principal -> ");
			actorPrincipal = scanner.nextLine();
			System.out.print("Introducir actriz principal -> ");
			actrizPrincipal = scanner.nextLine();

			if (actorPrincipal.equals(""))
				actorPrincipal = null;
			if (actrizPrincipal.equals(""))
				actrizPrincipal = null;

			this.actorPrincipal = actorPrincipal;
			this.actrizPrincipal = actrizPrincipal;
		}

		scanner.close();
	}

	public String getActorPrincipal() {
		return actorPrincipal;
	}

	public String getActrizPrincipal() {
		return actrizPrincipal;
	}

	@Override
	public String toString() {
		return super.toString()
				+ String.format(", Actor principal -> %s, Actriz principal -> %s", actorPrincipal, actrizPrincipal);
	}
}
