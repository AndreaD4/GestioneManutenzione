import java.util.ArrayList;
import java.util.List;

public class LineaDiProduzione {
	String ID;
	String descrizione;
	List <Macchinario> listMacc;
	
	public LineaDiProduzione(String ID, String descr) {
		super();
		this.ID = ID;
		this.descrizione = descr;
		this.listMacc = new ArrayList<Macchinario>();
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descr) {
		this.descrizione = descr;
	}
	public List<Macchinario> getListMacc() {
		return listMacc;
	}
	public void setListMacc(List<Macchinario> listMacc) {
		this.listMacc = listMacc;
	}
	public void addListMacc(Macchinario macc) {
		this.listMacc.add(macc);
	}

	@Override
	public String toString() {
		return "LineaDiProduzione [ID=" + ID + ", descrizione=" + descrizione + "]";
	}
	

}
