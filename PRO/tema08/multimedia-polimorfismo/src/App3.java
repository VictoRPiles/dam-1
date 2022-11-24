public class App3 {
	public static void main(String[] args) {
		ListaMultimedia listaMultimedia = new ListaMultimedia(10);
		Disco d1 = new Disco("Made in Japan", "Deep Purple", Formatos.mp3, 50f, Generos.rock);
		Disco d2 = new Disco("Machine Head", "Deep Purple", Formatos.mp3, 45f, Generos.rock);
		Disco d3 = new Disco("Texas", "ZZ Top", Formatos.mp3, 60f, Generos.blues);
		Pelicula p1 = new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", Formatos.wav, 169f, "Tom Hanks", null);

		listaMultimedia.add(d1); listaMultimedia.add(d2); listaMultimedia.add(d3);
		listaMultimedia.add(p1);
		System.out.println(listaMultimedia);

		Disco d4 = new Disco("Texas", "ZZ Top", Formatos.cdAudio, 60f, Generos.blues);
		listaMultimedia.add(d4);

		System.out.println("Duración total -> " + listaMultimedia.duracionTotal());
		System.out.println("Discos de rock -> " + listaMultimedia.getDiscosRock());
		System.out.println("Sin actriz principal -> " + listaMultimedia.sinActriz());
	}
}
