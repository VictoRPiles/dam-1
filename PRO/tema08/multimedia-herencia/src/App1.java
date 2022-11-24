public class App1 {

	public static void main(String[] args) {
		ListaMultimedia listaMultimedia = new ListaMultimedia(10);
		Pelicula pelicula1 = new Pelicula("Madagascar 3", "Kowalski", Formatos.wav, 90f, "Rey Lucian", "Lauren Philips");
		Pelicula pelicula2 = new Pelicula("Super Salidos", "Netflix", Formatos.avi, 120f, "McLovin", "Aletta Ocean");
		Pelicula pelicula3 = new Pelicula("Fast and Furious", "Ivan", Formatos.wav, 90f);

		listaMultimedia.add(pelicula1); listaMultimedia.add(pelicula2); listaMultimedia.add(pelicula3);
		System.out.println(listaMultimedia);

		Pelicula pelicula4 = new Pelicula("Fast and Furious", "Ivan", Formatos.dvd, 90f, "Victor", "Victoria");

		listaMultimedia.add(pelicula4);
		int i = listaMultimedia.indexOf(pelicula4);
		System.out.println(listaMultimedia.get(i) + " Index -> " + i);
	}
}
