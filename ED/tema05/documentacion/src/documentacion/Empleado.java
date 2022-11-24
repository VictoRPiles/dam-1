package documentacion;

/**
 * Clase Empleado Contiene información de cada empleado.
 *
 * @author Victor
 * @version 1.0
 */
public class Empleado {

	/** Nombre del empleado */
	private String apellido;
	/** Edad del empleado */
	private int edad;
	/** Apellido del empleado */
	private String nombre;
	/** Salario del empleado */
	private double salario;

	/**
	 * Constructor con 4 parámetros
	 *
	 * @param nombre   Nombre del empleado
	 * @param apellido Apellido del empleado
	 * @param edad     Edad del empleado
	 * @param salario  Salario del empleado
	 */
	public Empleado(String nombre, String apellido, int edad, double salario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.salario = salario;
	}

	/** Constructor por defecto */
	public Empleado() {
		this("", "", 0, 0);
	}

	/**
	 * Comprueba que el nombre no este vacío
	 *
	 * @return <ul>
	 * <li>true: el nombre es una cadena vacía</li>
	 * <li> false: el nombre no es una cadena vacía</li>
	 * </ul>
	 */
	private boolean compruebaNombre() {
		if (nombre.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * Suma un plus al salario del empleado si el empleado tiene más de 40 años
	 *
	 * @param sueldoPlus Aumento del sueldo
	 * @return <ul>
	 * <li>true: se suma el plus al sueldo</li>
	 * <li> false: no se suma el plus al sueldo</li>
	 * </ul>
	 */
	public boolean plus(double sueldoPlus) {
		boolean aumento = false;
		if (edad > 40 && compruebaNombre()) {
			salario += sueldoPlus;
			aumento = true;
		}
		return aumento;
	}
}