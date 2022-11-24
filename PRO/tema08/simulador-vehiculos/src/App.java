public class App {
	public static void main(String[] args) {
		Vehiculo[] vehiculos = new Vehiculo[4];
		Coche coc1 = new Coche("1111COC", (byte) 4);
		Coche coc2 = new Coche("2222COC", (byte) 2);
		Camion cam1 = new Camion("1111CAM");
		Camion cam2 = new Camion("2222CAM");

		vehiculos[0] = coc1; vehiculos[1] = coc2; vehiculos[2] = cam1; vehiculos[3] = cam2;

		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo instanceof Camion) ((Camion) vehiculo).ponerRemolque(new Remolque(5000));
			try {
				vehiculo.acelerar(200);
				System.out.println(vehiculo);
			} catch (DemasiadoRapidoException e) {
				System.out.println(vehiculo + " Va demasiado rápido");
			}
		}
	}
}
