import java.io.Serializable;

/**
 * @author Victor
 * @since 06/05/2022 - 10:34
 */
public class Mascota implements Serializable {
	protected final String ID;
	protected String nombre;
	protected Especie especie;

	public Mascota(String ID, String nombre) {
		this.ID = ID;
		this.nombre = nombre;
	}

	public Mascota(String ID, String nombre, Especie especie) {
		this.ID = ID;
		this.nombre = nombre;
		this.especie = especie;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Mascota) return ID.equals(((Mascota) obj).ID);

		return false;
	}
}