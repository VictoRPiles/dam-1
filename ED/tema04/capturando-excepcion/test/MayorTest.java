import org.junit.Test;

import static org.junit.Assert.*;

public class MayorTest {

	@Test
	public void getMayorNum() {
		try {
			assertEquals(0, Mayor.getMayorNum(null));
			fail("No se ha lanzado NullPointerException");
		} catch (NullPointerException ignored) {} ;

		assertEquals(9, Mayor.getMayorNum(new int[]{3, 7, 9, 8}));
		assertEquals(9, Mayor.getMayorNum(new int[]{9, 7, 8}));
		assertEquals(9, Mayor.getMayorNum(new int[]{7, 9, 8}));
		assertEquals(9, Mayor.getMayorNum(new int[]{7, 8, 9}));
		assertEquals(9, Mayor.getMayorNum(new int[]{9, 7, 9, 8}));
		assertEquals(7, Mayor.getMayorNum(new int[]{7}));
		assertEquals(-4, Mayor.getMayorNum(new int[]{-4, -6, -7, -22}));
	}
}