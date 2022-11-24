import java.util.LinkedList;
import java.util.ListIterator;

public class App {
	public static void main(String[] args) {
		LinkedList<String> paises = new LinkedList<>(), capitales = new LinkedList<>();
		ListIterator<String> iteratorPaises, iteratorCapitales;

		/* Paises */
		paises.add("Espanya"); paises.add("Colombia");
		paises.add("Mexico"); paises.add("Peru");

		/* Capitales */
		capitales.add("Madrid"); capitales.add("Bogota");
		capitales.add("CDMX"); capitales.add("Lima");

		iteratorPaises = paises.listIterator(); iteratorCapitales = capitales.listIterator();
		while (iteratorCapitales.hasNext()) {
			if (iteratorPaises.hasNext()) iteratorPaises.next();

			iteratorPaises.add(iteratorCapitales.next());
		}

		System.out.println(paises);
	}
}