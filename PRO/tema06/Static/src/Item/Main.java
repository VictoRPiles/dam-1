package Item;

/**
 * @author Victor Piles
 * @since 21/01/2022 8:21
 */
public class Main {
	public static void main(String[] args) {

		System.out.println("\nAÑADIMOS TRES ITEMS\n");

		Item i1 = new Item("uno");
		Item i2 = new Item("dos");
		Item i3 = new Item("tres");

		for (int i = 0; i < Item.getContador(); i++) {

			System.out.println(Item.getInstancias().get(i).toString());
		}

		System.out.println("\nAÑADIMOS DOS ITEMS MAS\n");

		Item i4 = new Item("cuatro");
		Item i5 = new Item("cinco");

		for (int i = 0; i < Item.getContador(); i++) {

			System.out.println(Item.getInstancias().get(i).toString());
		}
	}
}
