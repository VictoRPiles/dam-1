import java.io.Serializable;

public abstract class Bulto implements Comparable<Bulto>, Serializable {
    protected final int referencia;
    protected String destino;
    protected String remitente;
    protected String zona;
    protected Estado estado;

    public Bulto(int referencia, String destino, String remitente, String zona, Estado estado) {
        this.referencia = referencia;
        this.destino = destino;
        this.remitente = remitente;
        this.zona = zona;
        this.estado = estado;
    }

    public Bulto(int referencia) {
        this.referencia = referencia;
    }

    public void cambiarEstado(boolean exito) {
        if (exito) {
            switch (estado) {
                case PENDIENTE -> estado = Estado.ENREPARTO;
                case ENREPARTO -> estado = Estado.ENTREGADO;
            }
        }
    }

    /* Se ordenan por zona */
    @Override
    public int compareTo(Bulto o) {
        return zona.compareTo(o.zona);
    }

    /* Se identifican por referencia */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bulto bulto = (Bulto) o;

        return referencia == bulto.referencia;
    }

    @Override
    public int hashCode() {
        return referencia;
    }

    @Override
    public String toString() {
        return "Bulto{" +
                "referencia=" + referencia +
                ", destino='" + destino + '\'' +
                ", remitente='" + remitente + '\'' +
                ", zona='" + zona + '\'' +
                ", estado=" + estado +
                '}';
    }
}