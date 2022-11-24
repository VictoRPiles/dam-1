public class App {
	public static void main(String[] args) {
		ListaMultimedia listaMultimedia = new ListaMultimedia(4);
		listaMultimedia.add(new Multimedia("m1", "a1", Formatos.avi, 30f));
		listaMultimedia.add(new Multimedia("m2", "a2", Formatos.mov, 20f));
		listaMultimedia.add(new Multimedia("m3", "a3", Formatos.dvd, 30f));
		listaMultimedia.add(new Multimedia("m4", "a4", Formatos.mp3, 10f));

		System.out.println("SIN ORDENAR\n" + listaMultimedia);
		listaMultimedia.sort();
		System.out.println("ORDENADA\n" + listaMultimedia);
	}
}