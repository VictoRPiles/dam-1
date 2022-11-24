import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculadoraTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void suma() {
		System.out.println("suma");
		Calculadora calculadora = new Calculadora(20, 10);

		assertEquals(30, calculadora.suma(), 2);
	}

	@Test
	public void resta() {
		System.out.println("resta");
		Calculadora calculadora = new Calculadora(20, 10);

		assertEquals(10, calculadora.resta(), 2);
	}

	@Test
	public void multiplica() {
		System.out.println("multiplica");
		Calculadora calculadora = new Calculadora(20, 10);

		assertEquals(200, calculadora.multiplica(), 2);
	}

	@Test
	public void divide() {
		System.out.println("divide");
		Calculadora calculadora = new Calculadora(20, 10);

		assertEquals(2, calculadora.divide(), 2);
	}
}