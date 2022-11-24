import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Vista {

    /* Pide los datos para crear un nuevo bulto */
    public static Bulto pedirDatos() {
        Scanner scanner = new Scanner(System.in);
        String direccion, remitente, zona;
        char resp;
        System.out.print("Direccion -> ");
        direccion = scanner.nextLine();
        System.out.print("Remitente -> ");
        remitente = scanner.nextLine();
        System.out.print("Zona -> ");
        zona = scanner.nextLine();

        do {
            System.out.print("Paquete (P) o Carta (C) -> ");
            resp = scanner.nextLine().toUpperCase().charAt(0);
        } while (resp != 'C' && resp != 'P');

        if (resp == 'P') {
            float peso = 0;
            Exception e;

            do {
                try {
                    System.out.print("Peso -> ");
                    peso = scanner.nextFloat();
                    e = null;
                } catch (InputMismatchException inputMismatchException) {
                    e = inputMismatchException;
                }
            } while (e != null);

            return new Paquete(GestionBultos.getNextRef().intValue(), direccion, remitente, zona, peso, Estado.PENDIENTE);
        }

        return new Carta(GestionBultos.getNextRef().intValue(), direccion, remitente, zona, Estado.PENDIENTE);
    }

    /* Pide un codigo postal */
    public static String pedirCodigo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el codigo postal º-> ");
        return scanner.nextLine();
    }
}
