import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RicambioTest {

	@Test
	void testRicambio() {
		Ricambio ric = new Ricambio("Ric1", 1);
		assertEquals("Ric1", ric.getDesRic());
		assertEquals(1, ric.getQuantita());
	}

}
