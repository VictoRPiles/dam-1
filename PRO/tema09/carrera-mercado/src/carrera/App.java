package carrera;

class App {
	public static void main(String[] args) {
		Carrera carrera = new Carrera();

		try {
			carrera.add(new Participante(110, "Victor"));
			carrera.add(new Participante(100, "Ivan"));
			carrera.add(new Participante(120, "Alfonso"));
			carrera.add(new Participante(130, "Sergio"));
			carrera.add(new Participante(130, "Carlos"));
		} catch (MismoDorsalException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(carrera);

		System.out.println("\nBORRANDO -> " + new Participante(130, "Sergio") + "...");
		carrera.remove(new Participante(130));

		try {
			System.out.println("AÑADIENDO -> " + new Participante(130, "Carlos") + "...\n");
			carrera.add(new Participante(130, "Carlos"));
		} catch (MismoDorsalException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(carrera);

		System.out.println("\nBORRANDO -> " + new Participante(120, "Alfonso") + "...\n");
		carrera.remove(new Participante(120));

		System.out.println(carrera);
	}
}