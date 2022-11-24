public class DatosJava {

	public static void main(String[] args) {

		/**
		 * 1.- Escribir un programa que escriba en la pantalla tu nombre completo en una línea y en la línea siguiente
		 * tu fecha de nacimiento.
		 * - Sin pedir datos por teclado:
		 * • con una sola sentencia
		 * • con 3 sentencias
		 */
		System.out.println("===== EJERCICIO 1 =====");

		/* Con una sola sentencia */
		System.out.println("Victor Piles Delgado\n18/11/2003");

		/* Con tres sentencias */
		System.out.print("Victor ");
		System.out.println("Piles Delgado");
		System.out.println("18/11/2003");

		/**
		 * 2.- Escribir un programa que declare 2 variables para almacenar las notas de los 2 parciales de la asignatura
		 * de programación (pueden tener decimales)
		 * NO PEDIR DATOS, las notas se asignarán como literales a las variables al declararlas.
		 * El programa escribirá la nota de cada parcial y finalmente la nota media
		 * Ejemplo de salida:
		 * PROGRAMACIÓN
		 * Parcial 1 = 8.2
		 * Parcial 2 = 6.5
		 * Final = 7.35
		 */
		System.out.println("===== EJERCICIO 2 =====");

		float parcial1 = 8.2f;
		float parcial2 = 6.5f;
		float mediaFinal = (parcial1 + parcial2) / 2;

		System.out.println("Parcial 1 = " + parcial1);
		System.out.println("Parcial 2 = " + parcial2);
		System.out.println("Media final = " + mediaFinal);

		/**
		 * 3.- Escribe un programa que visualice en pantalla cuánto le costará comprar unas deportivas cuyo precio de
		 * catálogo es de 85,00 €, si sabe que puede conseguir una rebaja del 15%.
		 */
		System.out.println("===== EJERCICIO 3 =====");

		float precioInicial = 85.0f;
		float precioFinal = (precioInicial * 0.85f); // 100 - 15

		System.out.println("El precio inicial de las deportivas era -> " + precioInicial + " €");
		System.out.println("Con la rebaja del 15% cuestan -> " + precioFinal + " €");

		/**
		 * 4.- Escribe un programa que visualice en pantalla cuánto le dará su banco después de seis meses si pone 2000€
		 * en una cuenta a plazo fijo al 2,75% anual. Recuerda que al pagarte los intereses el banco le retendrá el 18%
		 * para hacienda. Escribe los mensajes apropiados para entender todos los cálculos.
		 * Cantidad inicial: 2000
		 * Intereses anuales: 55.0
		 * Intereses a los 6 meses: 27.5
		 * Retención Hacienda: 4.95
		 * Interés neto: 22.55
		 * Cantidad final: 2022.55
		 */
		System.out.println("===== EJERCICIO 4 =====");

		float saldoInicial = 2000.0f;
		float interesAnual = (saldoInicial * 2.75f) / 100;
		float interesNeto = (((interesAnual / 2) * 82) / 100);

		System.out.println("Saldo inicial -> " + saldoInicial + " €");
		System.out.println("Interés anual -> " + interesAnual + " €");
		System.out.println("Interés 6 meses -> " + (interesAnual / 2) + " €");
		System.out.printf("Retención hacienda -> %.2f €\n", ((interesAnual / 2) - interesNeto)); // Formato con 2 decimales maximo
		System.out.println("Cantidad final -> " + (saldoInicial + interesNeto) + " €");

		/**
		 * 5.- Dadas las siguientes expresiones aritméticas, calcula cuál es el resultado de evaluarlas. Supón que las
		 * variables a y b que aparecen son del tipo int y 'a' tiene el valor de 2 y 'b' tiene el valor de 4.
		 * a) –a + 5 % b – a * a
		 * b) 5 + 3 % 7 * b * a – b % a
		 * c) (a+1) * (b + 1) – b / a
		 * d) a * ((a+2) / b)
		 */
		System.out.println("===== EJERCICIO 5 =====");

		int a = 2, b = 4;

		double opA = (-a + 5 % b - a * a);
		double opB = (5 + 3 % 7 * b * a - b % a);
		double opC = ((a + 1) * (b + 1) - b / a);
		double opD = (a * ((a + 2) / b));

		System.out.println("a) –a + 5 % b - a * a = " + opA);
		System.out.println("b) 5 + 3 % 7 * b * a - b % a = " + opB);
		System.out.println("c) (a + 1) * (b + 1) - b / a = " + opC);
		System.out.println("d) a * ((a + 2) / b) = " + opD);

		/**
		 * 6.- Escribe un programa para calcular el área y el volumen de un cilindro. Para ello declara una constante
		 * que guarda el valor de PI. Declara, también, variables para el diámetro y la altura del cilindro. Supón para
		 * el ejemplo que el cilindro tiene un diámetro de 15,5 cm y una altura de 42,4 cm.
		 */
		System.out.println("===== EJERCICIO 6 =====");

		/* El volumen de un cilindro es π r² h, y el área de su superficie es 2π r h + 2π r² */
		final double PI = Math.PI;
		double diametro = 15.5; // radio = diametro / 2
		double altura = 42.4;

		double areaCilindro = ((2 * PI * (diametro / 2) * altura)) + (2 * PI * Math.pow(diametro / 2, 2));
		double volumenCilindro = (PI * Math.pow(diametro / 2, 2) * altura);

		/* Formato con 4 decimales maximo */
		System.out.printf("El área del cilindro es -> %.4f cm²\n", areaCilindro);
		System.out.printf("El volumen del cilindro es -> %.4f cm³\n", volumenCilindro);
	}
}
