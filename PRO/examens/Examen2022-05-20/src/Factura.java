import java.util.Collection;
import java.util.Iterator;

public abstract class Factura {
    public static float facturar(Collection f, float precio) {
        Iterator it = f.iterator();
        Facturable p;
        float precioTotal = 0;
        while (it.hasNext()) {
            p = (Facturable) it.next();
            precioTotal += p.getPeso() * precio;
        }
        return precioTotal;
    }
}
