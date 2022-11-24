import java.util.Scanner;

public class Ej20a {
	/**
	 * 20a.- De los ejercicios propuestos anteriormente para las estructuras repetitivas
	 * MIENTRAS y REPETIR..HASTA, indica cuáles de ellos serían adecuados para
	 * resolver con una estructura de este tipo y el motivo, y resuélvelos.
	 */
	public static void main(String[] args) {
		/*
		Ej1();
		Ej2();
		Ej3();
		Ej4();
		Ej6();
		Ej8();
		Ej9();
		Ej11();
		Ej14();
		Ej15();
		Ej16();
		Ej19a();
		Ej19b();
		Ej19c();
		*/
	}

	public static void Ej1() {
		/**
		 * 1.- Diseña un algoritmo que visualice los 50 primeros números enteros.
		 */
		for (int i = 0; i <= 50; i++) {
			System.out.println(i);
		}
	}

	public static void Ej2() {
		/**
		 * 2.- Diseña un algoritmo que sume los números comprendidos entre el 1 y un número
		 * introducido por el usuario a través del teclado. Si el número introducido es <1 la
		 * suma será 0.
		 */
		Scanner scanner = new Scanner(System.in);
		int suma = 0, numero;

		numero = scanner.nextInt();

		if (numero > 0) {
			for (int i = 1; i <= numero; i++) {
				suma += i;
			}
		} else {
			suma = 0;
		}
		System.out.println(suma);
	}

	public static void Ej3() {
		/**
		 * 3.- Diseña un algoritmo que muestre los números comprendidos entre dos números
		 * introducidos desde el teclado en orden ascendente
		 */
		Scanner scanner = new Scanner(System.in);
		int num1, num2;

		System.out.print("Primer numero -> "); num1 = scanner.nextInt();
		System.out.print("Segundo numero -> "); num2 = scanner.nextInt();

		if (num2 < num1) {
			System.out.printf("ERROR: El número 2 (%d) debe ser mayor que el número 1 (%d)", num2, num1);
			System.exit(0);
		}

		System.out.printf("Entre el %d y el %d, existen los números -> ", num1, num2);

		for (int i = num1; i <= num2; i++) {
			System.out.printf("%d ", i);
		}
	}

	public static void Ej4() {
		/**
		 * 4.- Diseña un algoritmo que muestre los números comprendidos entre dos números
		 * introducidos desde el teclado en orden descendente
		 */
		Scanner scanner = new Scanner(System.in);
		int num1, num2;

		System.out.print("Primer numero -> "); num1 = scanner.nextInt();
		System.out.print("Segundo numero -> "); num2 = scanner.nextInt();

		if (num2 < num1) {
			System.out.printf("ERROR: El número 2 (%d) debe ser mayor que el número 1 (%d)", num2, num1);
			System.exit(0);
		}

		System.out.printf("Entre el %d y el %d, existen los números -> ", num1, num2);

		for (int i = num2; i >= num1; i--) {
			System.out.printf("%d ", i);
		}
	}

	public static void Ej6() {
		/**
		 * 6.- Diseña un algoritmo que calcule y muestre el factorial de un número entero positivo
		 * dado por teclado
		 */
		Scanner scanner = new Scanner(System.in);
		int num, factorial = 1;

		System.out.print("Introduce el numero -> "); num = scanner.nextInt();

		if (num < 0) {
			System.out.println("ERROR: El numero debe ser positivo");
		} else {
			for (int i = 1; i <= num; i++) {
				factorial *= i;
			}
			System.out.printf("!%d -> %d", num, factorial);
		}
	}

	public static void Ej8() {
		/**
		 * 8.- Diseña un algoritmo que lea 10 números y cuente los positivos, negativos y nulos
		 * y muestre los totales
		 */
		Scanner scanner = new Scanner(System.in);
		int num, positivos = 0, negativos = 0, nulos = 0;

		for (int i = 0; i < 10; i++) {
			System.out.printf("Introduce el %dº numero -> ", i + 1); num = scanner.nextInt();
			if (num != 0) {
				if (num > 0) {
					positivos++;
				} else {
					negativos++;
				}
			} else {
				nulos++;
			}
		}
		System.out.printf("Positivos -> %d\nNegativos -> %d\nNulos -> %d", positivos, negativos, nulos);
	}

	public static void Ej9() {
		/**
		 * 9.- Diseña un algoritmo que calcule la potencia de un número por productos sucesivos
		 * dada la base y el exponente.
		 */
		Scanner scanner = new Scanner(System.in);
		int base, exponente;
		long resultado;

		System.out.print("Introduce la base -> "); base = scanner.nextInt();
		System.out.print("Introduce el exponente -> "); exponente = scanner.nextInt();

		resultado = base;
		for (int i = 1; i < exponente; i++) {
			resultado = (resultado * base);
		}
		System.out.printf("%d^%d = %d", base, exponente, resultado);
	}

	public static void Ej11() {
		/**
		 * 11.- Diseñar un algoritmo que realice y muestre el producto de dos números
		 * enteros positivos introducidos por teclado utilizando sumas sucesivas.
		 */
		Scanner scanner = new Scanner(System.in);
		int num, numInicial, multiplicar;

		System.out.print("Introduce el numero -> "); num = scanner.nextInt();
		System.out.print("Multiplicado por -> "); multiplicar = scanner.nextInt();

		numInicial = num;
		if (num >= 0 && multiplicar > 0) {
			System.out.printf("%d x %d = ", num, multiplicar);
			for (int i = 1; i < multiplicar; i++) {
				num += numInicial;
			}
			System.out.printf("%d", num);
		} else if (multiplicar == 0) {
			System.out.printf("%d x %d = 0", num, multiplicar);
		} else {
			System.out.println("ERROR: Introduce un numero positivo");
		}
	}

	public static void Ej14() {
		/**
		 * 14.- Escribir un algoritmo que lea un número y escriba todos los números
		 * comprendidos entre dicho número y la unidad en orden decreciente. (utilizando
		 * el bucle repetir-hasta)
		 */
		Scanner scanner = new Scanner(System.in);
		int numero;

		System.out.print("Introduce el numero -> "); numero = scanner.nextInt();

		for (int i = numero; i >= 1; i--) {
			System.out.println(i);
		}
	}

	public static void Ej15() {
		/**
		 * 15.- Diseñar un algoritmo que lee “N” caracteres y contabiliza el número de veces
		 * que se repiten las vocales a, e, i, o, y u
		 */
		Scanner scanner = new Scanner(System.in);
		byte n, vocales = 0;
		char[] caracteres;

		System.out.print("Numero de caracteres -> "); n = scanner.nextByte();
		caracteres = new char[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Introduce un caracter -> "); caracteres[i] = scanner.next().charAt(0);

			caracteres[i] = Character.toUpperCase(caracteres[i]);
			switch (caracteres[i]) {
				case 'A', 'E', 'I', 'O', 'U':
					vocales++;
					break;
			}
		}
		System.out.printf("Has introducido %d vocales", vocales);
	}

	public static void Ej16() {
		/**
		 * 16.- Escribir un algoritmo que lee un número entero positivo y seguidamente escribe
		 * el carácter “*”, un número de veces igual al valor numérico leído. En aquellos
		 * casos en que el valor leído no sea positivo se deberá escribir un único asterisco.
		 */
		Scanner scanner = new Scanner(System.in);
		short numero;

		System.out.print("¿Quantos '*' quieres? "); numero = scanner.nextShort();

		if (numero > 0) {
			for (int i = 0; i < numero; i++) {
				System.out.print("* ");
			}
		} else {
			System.out.print("*");
		}
	}

	public static void Ej19a() {
		/**
		 * 19a.- Diseña un algoritmo que muestre los números comprendidos entre el 1 y 50
		 */
		for (int i = 1; i <= 50; i++) {
			System.out.println(i);
		}
	}

	public static void Ej19b() {
		/**
		 * 19b.- Diseña un algoritmo que muestre los números comprendidos entre el 1 y
		 * un número introducido por teclado en orden descendente.
		 */
		Scanner scanner = new Scanner(System.in);
		int numero;

		System.out.print("Introduce un numero -> "); numero = scanner.nextInt();

		for (int i = numero; i > 0; i--) {
			System.out.println(i);
		}
	}

	public static void Ej19c() {
		/**
		 * 19c.- Diseña un algoritmo que calcule y muestre el factorial de un número
		 * entero positivo dado por teclado
		 */
		Scanner scanner = new Scanner(System.in);
		int numero, factorial = 1;

		System.out.print("Introduce el numero -> "); numero = scanner.nextInt();

		if (numero > 0) {
			for (int i = 1; i <= numero; i++) {
				factorial = factorial * i;
			}
			System.out.printf("!%d -> %d", numero, factorial);
		} else {
			System.out.println("ERROR: El numero debe ser positivo");
		}
	}
}