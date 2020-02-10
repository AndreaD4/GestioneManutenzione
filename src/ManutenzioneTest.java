import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManutenzioneTest {

	@Test
	void testManutenzione() {
		Manutenzione man = new Manutenzione("Man1");
		assertEquals("Man1", man.getDescrizione());
		assertFalse(man.completata);
	}

	@Test
	void testSetCompletata() {
		Manutenzione man = new Manutenzione("Man1");
		Ricambio ric = new Ricambio("Ric1", 1);
		man.setCompletata(ric, 1);
		assertTrue(man.completata);
		assertEquals(1, man.getDurata());
		assertEquals("Ric1", man.getRicUtil().getDescrizione());
	}

}
