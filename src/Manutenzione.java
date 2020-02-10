import java.util.Date;

public class Manutenzione {

	String descrizione;
	Date data;
	int durata;
	boolean completata;
	Ricambio ricUtil;
	
	public Manutenzione(String desMan) {
		super();
		this.descrizione = desMan;
		this.data = new Date();
		this.completata = false;
		this.durata = -1;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String desMan) {
		this.descrizione = desMan;
	}
	public boolean getCompletata() {
		return completata;
	}
	public void setCompletata(Ricambio ricUtil, int durata) {
		this.ricUtil = ricUtil;
		this.completata = true;
		this.durata = durata;
	}
	public Date getData() {
		return data;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public Ricambio getRicUtil() {
		return ricUtil;
	}
	public void setRicUtil(Ricambio ricUtil) {
		this.ricUtil = ricUtil;
	}
	
	@Override
	public String toString() {
		if(ricUtil != null)
			return "Manutenzione [desMan=" + descrizione + ", data=" + data + ", completata= "+completata+", ricambio utilizzato"+ricUtil.toString()+"]";
		else
			return "Manutenzione [desMan=" + descrizione + ", data=" + data + ", completata= "+completata+"]";
	}


}
