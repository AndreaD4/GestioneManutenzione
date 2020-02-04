import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Linea_produzioneTest {

	@Test
	void testLinea_produzione() {
		Macchinario mac = new Macchinario(1, "Mac1");
		List<Macchinario> listMacc = new ArrayList<Macchinario>();
		listMacc.add(mac);
		Linea_produzione linPro = new Linea_produzione("Lin1", listMacc);
		assertEquals("Lin1", linPro.getDescr());
		assertEquals(1, linPro.listMacc.get(0).getId());
		assertEquals("Mac1", linPro.listMacc.get(0).getDesMacc());
	}

	@Test
	void testAddListMacc() {
		Macchinario mac = new Macchinario(1, "Mac1");
		List<Macchinario> listMacc = new ArrayList<Macchinario>();
		listMacc.add(mac);
		Linea_produzione linPro = new Linea_produzione("Lin1", listMacc);
		Macchinario mac2 = new Macchinario(2, "Mac2");
		assertEquals(1, linPro.getListMacc().size());
		linPro.addListMacc(mac2);
		assertEquals(2, linPro.getListMacc().size());
	}

}
