public class App2 {
	public static void main(String[] args) {
		ListaMultimedia listaMultimedia = new ListaMultimedia(10);
		Disco d1 = new Disco("Made in Japan", "Deep Purple", Formatos.mp3, 50f, Generos.rock);
		Disco d2 = new Disco("Machine Head", "Deep Purple", Formatos.mp3, 45f, Generos.rock);
		Disco d3 = new Disco("Texas", "ZZ Top", Formatos.mp3, 60f, Generos.blues);

		listaMultimedia.add(d1); listaMultimedia.add(d2); listaMultimedia.add(d3);
		System.out.println(listaMultimedia);

		Disco d4 = new Disco("Texas", "ZZ Top", Formatos.cdAudio, 60f, Generos.blues);
		listaMultimedia.add(d4);

		int i = listaMultimedia.indexOf(d4);
		System.out.println(listaMultimedia.get(i) + " Index -> " + i);
	}
}