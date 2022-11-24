package asignatura;

/**
 * @author Victor Piles
 * @since 14/01/2022 8:25
 */
public class Asignatura {

	private String nombre;
	private int codigo;
	private int curso;

	public Asignatura(String nombre, int codigo, int curso) {

		this.nombre = nombre;
		this.codigo = codigo;
		this.curso = curso;
	}

	public String getNombre() {

		return nombre;
	}

	public int getCodigo() {

		return codigo;
	}

	public int getCurso() {

		return curso;
	}

	public void imprimirAsignatura() {

		System.out.printf("Nombre ->\t%s\t|\tCodigo ->\t%d\t|\tCurso ->\t%d\n", nombre, codigo, curso);
	}
}
