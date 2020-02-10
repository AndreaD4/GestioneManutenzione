import java.util.ArrayList;
import java.util.List;

public class Macchinario {

	String ID;
	String descrizione;
	List<Ricambio> listRic;
	List<Segnalazione> listSeg;
	List<Manutenzione> listMan;

	public Macchinario(String ID, String desMacc) {
		super();
		this.ID = ID;
		this.descrizione = desMacc;
		this.listRic = new ArrayList<Ricambio>();
		this.listSeg = new ArrayList<Segnalazione>();
		this.listMan = new ArrayList<Manutenzione>();
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

	public void setDescrizione(String desMacc) {
		this.descrizione = desMacc;
	}

	public List<Ricambio> getListRic() {
		return listRic;
	}

	public void setListRic(List<Ricambio> listRic) {
		this.listRic = listRic;
	}

	public List<Segnalazione> getListSeg() {
		return listSeg;
	}

	public void setListSeg(List<Segnalazione> listSeg) {
		this.listSeg = listSeg;
	}

	public List<Manutenzione> getListMan() {
		return listMan;
	}

	public void setListMan(List<Manutenzione> listMan) {
		this.listMan = listMan;
	}
	
	public void addListRic(Ricambio ric) {
		this.listRic.add(ric);
	}
	
	public void addListSeg(Segnalazione seg) {
		this.listSeg.add(seg);
	}
	
	public void addListMan(Manutenzione man) {
		this.listMan.add(man);
	}

	@Override
	public String toString() {
		return "Macchinario [ID=" + ID + ", descrizione=" + descrizione + "]";
	}

}
