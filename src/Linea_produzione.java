import java.util.List;

public class Linea_produzione {

	String desLin;
	List <Macchinario> listMacc;
	
	public Linea_produzione(String descr, List<Macchinario> listMacc) {
		super();
		this.desLin = descr;
		this.listMacc = listMacc;
	}
	
	public String getDescr() {
		return desLin;
	}
	public void setDescr(String descr) {
		this.desLin = descr;
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
		return "Linea_produzione [desLin=" + desLin + ", listMacc=" + listMacc + "]";
	}
}
