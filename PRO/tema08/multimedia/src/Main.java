public class Main {
	public static void main(String[] args) {
		ListaMultimedia listaMultimedia = new ListaMultimedia(10);
		Multimedia m1 = new Multimedia("M1", "Victor", Formatos.avi, 90f);
		Multimedia m2 = new Multimedia("M2", "Piles", Formatos.midi, 120f);
		Multimedia m3 = new Multimedia("M3", "Delgado", Formatos.mp3, 80f);
		Multimedia m4 = new Multimedia(m3.getTitulo(), m3.getAutor(), Formatos.cdAudio, 69f);

		listaMultimedia.add(m1); listaMultimedia.add(m2); listaMultimedia.add(m3); listaMultimedia.add(m4);

		System.out.println(listaMultimedia);

		System.out.println(m3.equals(m4));

		int i;
		System.out.println(i = listaMultimedia.indexOf(m4));
		System.out.println("Posición " + i + ": " + listaMultimedia.get(i));
	}
}
