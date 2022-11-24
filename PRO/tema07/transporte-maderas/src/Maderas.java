public enum Maderas {
	ROBLE("Castaño verdoso", 800f), CAOBA("Marrón oscuro", 770f), NOGAL("Marrón rojizo", 820f),
	CEREZO("Marrón cereza", 790f), BOJ("Marrón negruzco", 675f);

	private final String COLOR;
	private final float PESO;

	Maderas(String color, float peso) {
		this.COLOR = color;
		this.PESO = peso;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public float getPESO() {
		return PESO;
	}
}
