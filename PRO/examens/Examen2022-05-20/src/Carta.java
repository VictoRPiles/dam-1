public class Carta extends Bulto {
    public Carta(int referencia, String destino, String remitente, String zona, Estado estado) {
        super(referencia, destino, remitente, zona, estado);
    }

    public Carta(int referencia) {
        super(referencia);
    }
}
