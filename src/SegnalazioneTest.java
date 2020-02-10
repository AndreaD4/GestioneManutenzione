import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SegnalazioneTest {

	@Test
	void testSegnalazione() {
		Segnalazione seg = new Segnalazione("Seg1");
		assertEquals("Seg1", seg.getDescrizione());
		assertFalse(seg.annullata);
		assertFalse(seg.generata);
	}

}
