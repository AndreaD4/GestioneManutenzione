import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManutenzioneTest {

	@Test
	void testManutenzione() {
		Manutenzione man = new Manutenzione("Man1");
		assertEquals("Man1", man.getDesMan());
		assertFalse(man.completata);
	}

	@Test
	void testSetCompletata() {
		Manutenzione man = new Manutenzione("Man1");
		Ricambio ric = new Ricambio("Ric1", 1);
		man.setCompletata(ric);
		assertTrue(man.completata);
		assertEquals("Ric1", man.getRicUtil().getDesRic());
	}

}
