public class Paquete extends Bulto implements Facturable {
    private float peso;

    public Paquete(int referencia, String destino, String remitente, String zona, float peso, Estado estado) {
        super(referencia, destino, remitente, zona, estado);
        this.peso = peso;
    }

    public Paquete(int referencia) {
        super(referencia);
    }

    @Override
    public float getPeso() {
        return peso;
    }

    @Override
    public void cambiarEstado(boolean exito) {
        if (exito) {
            switch (estado) {
                case PENDIENTE -> estado = Estado.ENREPARTO;
                case ENREPARTO -> estado = Estado.ENTREGADO;
            }
        } else {
            if (!estado.equals(Estado.ENREPARTO)) {
                System.out.println("ERROR: El paquete no está el reparto");
            } else {
                estado = Estado.DEVUELTO;
            }
        }
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "referencia=" + referencia +
                ", destino='" + destino + '\'' +
                ", remitente='" + remitente + '\'' +
                ", zona='" + zona + '\'' +
                ", peso=" + peso + '\'' +
                ", estado=" + estado +
                '}';
    }
}