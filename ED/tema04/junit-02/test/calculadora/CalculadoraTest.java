package calculadora;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculadoraTest {

	@Test
	public void resta() {
		Calculadora calculadora = new Calculadora();

		assertTrue(calculadora.esMayor(10, 2));
		assertEquals(2, calculadora.resta(4, 2));
		assertEquals(2, calculadora.resta(2, 4));
	}

	@Test
	public void divide() {
		Calculadora calculadora = new Calculadora();

		assertNull(calculadora.divide(2, 0));
		assertNotNull(calculadora.divide(0, 2));
		assertEquals(String.valueOf(4), calculadora.divide(8, 2));
	}
}