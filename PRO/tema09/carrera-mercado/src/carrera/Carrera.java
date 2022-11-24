package carrera;

import java.util.Iterator;
import java.util.TreeSet;

class Carrera {
	private TreeSet<Participante> participantes = new TreeSet<>();

	public void add(Participante o) throws MismoDorsalException {
		if (!participantes.add(o))
			throw new MismoDorsalException("ERROR: " + o + " tiene un dorsal repetido, no se añade a la carrera.");
	}

	public void remove(Participante o) {
		participantes.remove(o);
	}

	@Override
	public String toString() {
		Iterator<Participante> i = participantes.iterator();
		StringBuilder info = new StringBuilder("Carrera {\n");

		while (i.hasNext()) {
			info.append("\t").append(i.next().toString()).append("\n");
		}

		return info.toString() + '}';
	}
}