import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Nuevo pedido");
        System.out.println("2) Generar reparto");
        System.out.println("3) Cerrar envio");
        System.out.println("4) Salir");

        return scanner.nextInt();
    }

    public static void main(String[] args) {
        int op;
        try {
            GestionBultos.load();
        } catch (IOException e) {
            System.out.println("Error al cargar los datos");
        }
        GestionBultos.print();

        do {
            op = menu();

            switch (op) {
                case 1 -> GestionBultos.add(Vista.pedirDatos());
                case 2 -> {
                    try {
                        GestionBultos.generarReparto(Vista.pedirCodigo());
                    } catch (IOException e) {
                        System.out.println("Error al guardar el reparto en el fichero");
                    }
                }
                case 3 -> {
                    System.out.println("Bultos entregados");
                    for (Bulto bulto : GestionBultos.getBultosEntregados()) {
                        GestionBultos.cerrarEnvio(bulto.referencia, true);
                    }
                    System.out.println("Bultos no entregados");
                    for (Bulto bulto : GestionBultos.getBultosNoEntregados()) {
                        GestionBultos.cerrarEnvio(bulto.referencia, false);
                    }
                }
                case 4 -> {
                    GestionBultos.finalizar(1, 0.15f);
                    GestionBultos.print();
                }
                default -> System.out.println("Opción incorrecta");
            }
        } while (op != 4);
    }
}
