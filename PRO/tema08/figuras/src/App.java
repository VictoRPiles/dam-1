public class App {
	private static Boolean estanEnOrden(Figura[] vec) {

		for (int i = 0; i < vec.length - 1; i++) {
			if ((vec[i].compareTo(vec[i + 1])) != -1) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Figura[] vec = new Figura[4];
		vec[0] = new Circulo(Color.ROJO, new double[]{4, 5}, 3);
		vec[1] = new Rectangulo(new double[]{3, 6}, 10, 12);
		vec[2] = new Rectangulo(Color.AZUL, new double[]{2, 5}, 3, 5);
		vec[3] = new Circulo(new double[]{42, 35}, 4);

		for (Figura figura : vec) {
			System.out.printf("%.2f\n", figura.getArea());
		}

		System.out.println("Ordenados: " + estanEnOrden(vec));
	}
}