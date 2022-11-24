/**
 * @author Victor Piles
 * @since 11/02/2022 9:46
 */
public class Corredor {

	int energia;

	public Corredor(int energia) {
		this.energia = energia;
	}

	public void recargarEnergia(int energia) {
		System.out.println("Recargando " + energia + " puntos de energia");
		this.energia += energia;
	}

	public void correr() throws AgotadoException {
		if (energia < 10) throw new AgotadoException("Me he quedado sin energia");
		System.out.println("Empiezo a correr | Energia: " + energia); energia -= 10;
	}
}
