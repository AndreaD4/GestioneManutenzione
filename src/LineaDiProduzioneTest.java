import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineaDiProduzioneTest {

	@Test
	void testLinea_produzione() {
		LineaDiProduzione linPro = new LineaDiProduzione("1","Lin1");
		assertEquals("1", linPro.getID());
		assertEquals("Lin1", linPro.getDescrizione());
	}

	@Test
	void testAddListMacc() {
		LineaDiProduzione linPro = new LineaDiProduzione("1", "Lin1");
		assertEquals(0, linPro.getListMacc().size());
		Macchinario mac = new Macchinario("1", "Mac1");
		linPro.addListMacc(mac);
		assertEquals(1, linPro.getListMacc().size());
	}

}
