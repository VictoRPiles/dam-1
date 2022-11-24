import java.util.LinkedList;

public class Caja {
	private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	private LinkedList<Compra> compras = new LinkedList<>();
	private float saldoDiario;
	private Estado estado;

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}