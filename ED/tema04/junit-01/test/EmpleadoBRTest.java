import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmpleadoBRTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void calculaSalarioBrutoTest() throws BRException {
		EmpleadoBR empleadoBR = new EmpleadoBR();
		float result;

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 2000, 8);
		assertEquals(1360, result, 2);

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 1500, 3);

		assertEquals(1260, result, 2);

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 1499.99f, 0);
		assertEquals(1100, result, 2);

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 1250, 8);
		assertEquals(1760, result, 2);

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 1000, 0);
		assertEquals(1600, result, 2);

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 999.99f, 3);
		assertEquals(1560, result, 2);

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 500, 0);
		assertEquals(1500, result, 2);

		result = empleadoBR.calculaSalarioBruto(TipoEmpleado.ENCARGADO, 0, 8);
		assertEquals(1660, result, 2);

		/* Lanza BRException */
		try {
			empleadoBR.calculaSalarioBruto(TipoEmpleado.VENDEDOR, -1, 8);
			empleadoBR.calculaSalarioBruto(TipoEmpleado.VENDEDOR, 1500, -1);
			empleadoBR.calculaSalarioBruto(null, 1500, 8);
			fail("Se esperaba BRException");
		} catch (BRException ignored) {}
	}

	@Test
	public void calculaSalarioNetoTest() throws BRException {
		EmpleadoBR empleadoBR = new EmpleadoBR();
		float result;

		result = empleadoBR.calculaSalarioNeto(2000);
		assertEquals(1640, result, 4);

		result = empleadoBR.calculaSalarioNeto(1500);
		assertEquals(1230, result, 4);

		result = empleadoBR.calculaSalarioNeto(1499.99f);
		assertEquals(1259.9916f, result, 4);

		result = empleadoBR.calculaSalarioNeto(1250);
		assertEquals(1050, result, 4);

		result = empleadoBR.calculaSalarioNeto(1000);
		assertEquals(840, result, 4);

		result = empleadoBR.calculaSalarioNeto(999.99f);
		assertEquals(999.99f, result, 4);

		result = empleadoBR.calculaSalarioNeto(500);
		assertEquals(500, result, 4);

		result = empleadoBR.calculaSalarioNeto(0);
		assertEquals(0, result, 4);

		/* Lanza BRException */
		try {
			empleadoBR.calculaSalarioNeto(-1);
			fail("Se esperaba BRException");
		} catch (BRException ignored) {}
	}
}