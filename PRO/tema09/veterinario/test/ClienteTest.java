import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

	@Test
	public void validarDni() {
		Cliente onTest = new Cliente("BBB", "on", "Test");
		assertEquals("AAA", onTest.validarDni("AAA"));
		assertThrows(IllegalArgumentException.class, () -> onTest.validarDni("BBB"));
	}

	@Test
	public void addMascota() {
		Cliente onTest = new Cliente("CCC", "on", "Test");
		Pez m = new Pez(10, "Toby");
		assertTrue(onTest.addMascota(m));
		assertFalse(onTest.addMascota(m));
	}

	@Test
	public void removeMascota() {
		Cliente onTest = new Cliente("DDD", "on", "Test");
		Pez m = new Pez(20, "Tonet");
		onTest.addMascota(m);
		assertTrue(onTest.removeMascota(m));
		assertFalse(onTest.removeMascota(m));
	}
}