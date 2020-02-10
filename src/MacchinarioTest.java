import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MacchinarioTest {

	@Test
	void testMacchinario() {
		Macchinario mac = new Macchinario("1", "Mac1");
		assertEquals("1", mac.getID());
		assertEquals("Mac1", mac.getDescrizione());
	}

	@Test
	void testAddListRic() {
		Macchinario mac = new Macchinario("1", "Mac1");
		Ricambio ric = new Ricambio("Ric1", 1);
		assertEquals(0, mac.getListRic().size());
		mac.addListRic(ric);
		assertEquals(1, mac.getListRic().size());
	}

	@Test
	void testAddListSeg() {
		Macchinario mac = new Macchinario("1", "Mac1");
		Segnalazione seg = new Segnalazione("Seg1");
		assertEquals(0, mac.getListSeg().size());
		mac.addListSeg(seg);
		assertEquals(1, mac.getListSeg().size());
	}

	@Test
	void testAddListMan() {
		Macchinario mac = new Macchinario("1", "Mac1");
		Manutenzione man = new Manutenzione("Man1");
		assertEquals(0, mac.getListMan().size());
		mac.addListMan(man);
		assertEquals(1, mac.getListMan().size());
	}

}
