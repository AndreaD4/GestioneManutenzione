import java.util.ArrayList;
import java.util.List;

public class Macchinario {

	int id;
	String desMacc;
	List<Ricambio> listRic;
	List<Segnalazione> listSeg;
	List<Manutenzione> listMan;

	public Macchinario(int id, String desMacc) {
		super();
		this.id = id;
		this.desMacc = desMacc;
		this.listRic = new ArrayList<Ricambio>();
		this.listSeg = new ArrayList<Segnalazione>();
		this.listMan = new ArrayList<Manutenzione>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesMacc() {
		return desMacc;
	}

	public void setDesMacc(String desMacc) {
		this.desMacc = desMacc;
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
		return "Macchinario [id=" + id + ", desMacc=" + desMacc + ", listRic=" + listRic + ", listSeg=" + listSeg
				+ ", listMan=" + listMan + "]";
	}

}
