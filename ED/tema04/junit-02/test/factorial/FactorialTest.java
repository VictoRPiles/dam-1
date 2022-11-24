package factorial;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

	@Test
	public void calculo() {
		assertEquals(120, Factorial.calculo(5));
		try {
			Factorial.calculo(-1);
			fail();
		} catch (IllegalArgumentException ignored) {}
	}
}