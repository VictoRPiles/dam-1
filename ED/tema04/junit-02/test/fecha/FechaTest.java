package fecha;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class FechaTest {

	@Test
	public void getFecha() {
		Fecha fecha = new Fecha();

		/* OJO: La fecha esta hardcoded */
		assertEquals("2022/04", fecha.getFecha(1));
		assertEquals("04/2022", fecha.getFecha(2));
		assertEquals("04/22", fecha.getFecha(3));
		assertEquals("ERROR", fecha.getFecha(31));
	}
}