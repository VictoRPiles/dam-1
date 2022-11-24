import java.util.Scanner;

public class BasePorAltura {

	public static void main(String[] args) {

		double base, altura, perimetro, area;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce la base -> ");
		base = scanner.nextDouble();
		System.out.print("Introduce la altura -> ");
		altura = scanner.nextDouble();

		perimetro = base * 2 + altura * 2;
		area = base * altura;

		System.out.println("El perímetro del rectángulo es -> " + perimetro + " cm");
		System.out.println("El área del rectángulo es -> " + area + " cm²");
	}
}
