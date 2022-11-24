package mercado;

public class App {
	public static void main(String[] args) {
		Mercado mercado = new Mercado();

		mercado.add(new Producto("Leche", 100));
		mercado.add(new Producto("Pan", 100));
		mercado.add(new Producto("Carne", 140));
		mercado.add(new Producto("Agua", 80));
		mercado.add(new Producto("Carne", 120));

		System.out.println(mercado);

		System.out.println("\nBORRANDO -> " + new Producto("Carne", 140) + "...\n");
		mercado.remove(new Producto("Carne"));

		System.out.println(mercado);
	}
}