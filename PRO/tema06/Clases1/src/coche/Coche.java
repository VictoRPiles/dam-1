package coche;

/**
 * @author Victor Piles
 * @since 14/01/2022 8:05
 */
public class Coche {

	private final String modelo;
	private String color;
	private final String matricula;
	private int agnoFab;
	private boolean modSeg; // false: a terceros

	public Coche(String modelo, String color, String matricula, int agnoFab, boolean modSeg) {

		this(modelo, matricula);
		this.color = color;
		this.agnoFab = agnoFab;
		this.modSeg = modSeg;
	}

	public Coche(String modelo, String matricula) {

		this.modelo = modelo;
		this.matricula = matricula;
	}

	public String getModelo() {

		return modelo;
	}

	public String getColor() {

		return color;
	}

	public void setColor(String color) {

		this.color = color;
	}

	public String getMatricula() {

		return matricula;
	}

	public int getAgnoFab() {

		return agnoFab;
	}

	public boolean isModSeg() {

		return modSeg;
	}

	public void setModSeg(boolean modSeg) {

		this.modSeg = modSeg;
	}

	public void imprimeCoche() {

		System.out.printf("Modelo ->\t%s\t|\tColor ->\t%s\n", modelo, color);
	}
}
