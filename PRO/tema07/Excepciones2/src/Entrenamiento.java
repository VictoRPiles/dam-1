/**
 * @author Victor Piles
 * @since 11/02/2022 9:52
 */
public class Entrenamiento {

	public static void main(String[] args) {
		Corredor corredor = new Corredor(50);
		byte vecesAgotado = 0;

		while (vecesAgotado < 3) {
			try {
				corredor.correr();
			}
			catch (AgotadoException e) {
				System.out.println(e.getMessage());
				vecesAgotado++;

				switch (vecesAgotado) {
					case 1:
						corredor.recargarEnergia(30); break;
					case 2:
						corredor.recargarEnergia(10); break;
				}
			}
		}

		System.out.println("ENTRENAMIENTO TERMINADO");
	}
}
