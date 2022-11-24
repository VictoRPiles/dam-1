import java.io.Serializable;

/**
 * @author Victor
 * @since 06/05/2022 - 10:33
 */
public class Persona implements Serializable {
	protected final String DNI;
	protected String nombre;

	public Persona(String dni, String nombre) {
		this.DNI = dni;
		this.nombre = nombre;
	}
}