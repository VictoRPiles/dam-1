/**
 * @author Victor Piles
 * @since 03/02/2022 11:20
 */
public class Main {

	public static void main(String[] args) {

		Alumno[] g1 = new Alumno[30];

		for (int i = 0; i < g1.length; i++) {
			g1[i] = new Alumno();
		}

		Escuela e1 = new Escuela(g1);

		e1.recuento();
		System.out.println(e1.getDelegados());
	}
}
