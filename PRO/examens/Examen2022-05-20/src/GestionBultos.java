import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public abstract class GestionBultos {
    private static Long ref = 0L;
    private static TreeSet<Bulto> bultos = new TreeSet<>();

    /* Registrar nuevos envios */
    public static Boolean add(Bulto newBulto) {
        return bultos.add(newBulto);
    }

    /* Generar un reparto */
    public static void generarReparto(String zona) throws IOException {
        ArrayList<Bulto> bultosEnReparto = new ArrayList<>();

        for (Bulto bulto : bultos) {
            if (bulto.zona.equals(zona)) {
                if (bulto.estado.equals(Estado.PENDIENTE)) {
                    bulto.cambiarEstado(true);
                    bultosEnReparto.add(bulto);
                }
            }
        }

        guardar(bultosEnReparto);
    }

    private static void guardar(ArrayList<Bulto> bultosEnReparto) throws IOException {
        final String RUTA = "bultos-reparto.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(RUTA));

            for (Bulto bulto : bultosEnReparto) {
                bw.write(bulto + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
                System.out.println("Generando reparto...");
            }
        }
    }

    /* Cerrar los envios */
    public static void cerrarEnvio(int referencia, boolean exito) {
        for (Bulto bulto : bultos) {
            /* La cartas siempre se entregan */
            if (bulto instanceof Carta) {
                bulto.cambiarEstado(true);
            }

            /* En los paquetes la entrega depende del exito */
            if (bulto.equals(new Paquete(referencia))) {
                bulto.cambiarEstado(exito);
            }
        }
    }

    /* Cargar los datos */
    public static void load() throws IOException {
        final String RUTA = "pendientes.dat";
        ObjectInputStream objectInputStream = null;
        Bulto bulto;

        if (!new File(RUTA).exists()) System.out.println("No existe el fichero " + RUTA);
        else {
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(RUTA)));

                while ((bulto = (Bulto) objectInputStream.readObject()) != null) {
                    bultos.add(bulto);
                    ref++;
                }
            } catch (EOFException e) {
                System.out.println("Importando bultos desde " + RUTA);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            }
        }
    }

    /* Guardar los pendientes */
    public static void save() throws IOException {
        final String RUTA = "pendientes.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(RUTA));

            for (Bulto bulto : bultos) {
                /* Si no esta entregado */
                if (!bulto.estado.equals(Estado.ENTREGADO)) {
                    objectOutputStream.writeObject(bulto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                objectOutputStream.close();
                System.out.println("Guardando los bultos pendientes...");
            }
        }
    }

    /* Finalizar programa */
    public static void finalizar(float PRECIO_KILO, float PRECIO_CARTA) {
        short contadorCartas = 0, contadorPaquetes = 0;
        float precioTotal = 0;

        for (Bulto bulto : bultos) {
            if (bulto.estado.equals(Estado.ENTREGADO)) {
                if (bulto instanceof Carta) {
                    contadorCartas++;
                    precioTotal += PRECIO_CARTA;
                }
                if (bulto instanceof Paquete) {
                    contadorPaquetes++;
                    precioTotal += PRECIO_KILO * ((Paquete) bulto).getPeso();
                }
                bultos.remove(bulto);
            }
        }
        System.out.printf("Numero de Cartas -> %d\nNumero de paquetes -> %d\nPrecio total -> %.2f\n", contadorCartas, contadorPaquetes, precioTotal);
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Devuelve la siguiente referencia disponible, aumenta la referencia en 1 */
    public static Long getNextRef() {
        return ++ref;
    }

    /* Imprime el toString de los bultos */
    public static void print() {
        for (Bulto bulto : bultos) {
            System.out.println(bulto);
        }
    }

    /* Genera una factura para los bultos Facturables */
    public static void generarFactura(float precio) {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        float fact;

        for (Bulto bulto : bultos) {
            if (bulto instanceof Paquete && bulto.estado.equals(Estado.ENTREGADO)) {
                paquetes.add((Paquete) bulto);
            }
        }

        fact = Factura.facturar(paquetes, precio);
        System.out.println("Facturación de paquetes: " + fact);
    }

    /* Devuelve bultos entregados */
    public static Bulto[] getBultosEntregados() {
        TreeSet<Bulto> bultosEntregados = new TreeSet<>();

        for (Bulto bulto : bultos) {
            if (bulto.estado.equals(Estado.ENTREGADO)) {
                bultosEntregados.add(bulto);
            }
        }

        return bultosEntregados.toArray(new Bulto[0]);
    }

    /* Devuelve bultos no entregados */
    public static Bulto[] getBultosNoEntregados() {
        TreeSet<Bulto> bultosEntregados = new TreeSet<>();

        for (Bulto bulto : bultos) {
            if (!bulto.estado.equals(Estado.ENTREGADO)) {
                bultosEntregados.add(bulto);
            }
        }

        return bultosEntregados.toArray(new Bulto[0]);
    }
}
