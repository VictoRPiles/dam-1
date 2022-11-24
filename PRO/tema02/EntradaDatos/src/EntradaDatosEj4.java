import java.util.Scanner;

public class EntradaDatosEj4 {

	public static void main(String[] args) {

		/**
		 * 4.- Conociendo un ángulo y la longitud del lado opuesto de un triángulo rectángulo, puedo calcular
		 * la hipotenusa de 2 formas:
		 *
		 * En un paso:
		 * Hipotenusa = Opuesto/ sen(Ø)
		 * En 2 pasos:
		 * Adyacente= Opuesto/ tan(Ø)
		 * Hipotenusa= √(Adyacente² + Opuesto²)
		 *
		 * Pedir por teclado el ángulo y el lado opuesto y calcular la hipotensa de las 2 formas para comprobar
		 * que dan el mismo resultado.
		 */

		Scanner scanner = new Scanner(System.in);
		double angulo, ladoOpuesto, hipotenusa, adyacente;

		System.out.print("Introduce el angulo -> ");angulo = scanner.nextDouble();
		System.out.print("Introduce el lado opuesto -> ");ladoOpuesto = scanner.nextDouble();

		angulo = Math.toRadians(angulo); // El método Math.sin() trabaja con ángulos radiales, no en grados

		// Con un solo paso
		hipotenusa = (ladoOpuesto / Math.sin(angulo));
		System.out.println("Con un solo paso\nhipotenusa -> " + hipotenusa);

		// Con dos pasos
		adyacente = (ladoOpuesto / Math.tan(angulo));
		hipotenusa = Math.sqrt((Math.pow(adyacente, 2) + Math.pow(ladoOpuesto, 2)));
		System.out.println("Con dos pasos\nadyacente -> " + adyacente + "\nhipotenusa -> " + hipotenusa);
	}
}
