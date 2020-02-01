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
	
	public void printListMacc() {
		for(int i=0; i<this.getListMacc().size(); i++) {
			System.out.println(i+". ID: "+this.getListMacc().get(i).id+", Descrizione: "+this.getListMacc().get(i).desMacc);
		}
	}
	
	public void printListRic(int index) {
		for(int i=0; i<this.getListMacc().get(index).listRic.size(); i++) {
			System.out.println(i+". ID: "+this.getListMacc().get(i).id+", Descrizione: "+this.getListMacc().get(i).desMacc+", Ricambio: "+this.getListMacc().get(index).listRic.get(i).desRic+", Quantità: "+this.getListMacc().get(index).listRic.get(i).quantita);
		}
	}
	
	public void printListMan() {
		for(int i=0; i<this.getListMacc().size(); i++) {
			for(int j=0; j<this.getListMacc().get(i).listMan.size(); j++) {
				System.out.println(i+". ID: "+this.getListMacc().get(i).id+", Descrizione: "+this.getListMacc().get(i).desMacc+", "+this.getListMacc().get(i).listMan.get(j).toString());
			}
		}
	}
	
	public void printListSeg() {
		for(int i=0; i<this.getListMacc().size(); i++) {
			for(int j=0; j<this.getListMacc().get(i).listSeg.size(); j++) {
				System.out.println(i+". ID: "+this.getListMacc().get(i).id+", Descrizione: "+this.getListMacc().get(i).desMacc+", Segnalazione: "+this.getListMacc().get(i).listSeg.get(j).toString());
			}
		}
	}
	
	@Override
	public String toString() {
		return "Linea_produzione [desLin=" + desLin + ", listMacc=" + listMacc + "]";
	}
}
