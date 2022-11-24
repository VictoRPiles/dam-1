import java.util.Scanner;

public class MetodosRecursivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;

        System.out.print("Introduce la N -> ");
        n = scanner.nextInt();
        System.out.print("Introduce la M -> ");
        m = scanner.nextInt();

        System.out.printf("El sumatorio el %d es %.0f\n", n, sumatorio(n));
        System.out.printf("El exponencial de %d^%d es %.0f\n", n, m, exponencial(n, m));
    }

    public static double sumatorio(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumatorio(n - 1);
        }
    }

    public static double exponencial(int n, int m) {
        if (m == 0) {
            return 1;
        } else {
            return n * exponencial(n, m - 1);
        }
    }
}
