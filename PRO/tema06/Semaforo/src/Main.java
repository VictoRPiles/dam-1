/**
 * @author Victor Piles
 * @since 10/01/2022 14:08
 */
public class Main {
	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();
		
		System.out.println(semaforo.getColor());
		semaforo.setColor("verde");
		System.out.println(semaforo.getColor());
	}
}
