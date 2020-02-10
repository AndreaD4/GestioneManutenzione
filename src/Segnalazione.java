import java.util.Date;

public class Segnalazione {

	String descrizione;
	Date data;
	boolean annullata, generata;
	
	public Segnalazione(String desSeg) {
		super();
		this.descrizione = desSeg;
		this.data = new Date();
		this.annullata = false; 
		this.generata = false;
	}
	
	public boolean isAnnullata() {
		return annullata;
	}

	public void setAnnullata() {
		this.annullata = false;
	}

	public boolean isGenerata() {
		return generata;
	}

	public void setGenerata() {
		this.generata = true;
	}

	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String desSeg) {
		this.descrizione = desSeg;
	}
	
	public Date getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Segnalazione [descrizione=" + descrizione + ", data=" + data + ", annullata=" + annullata
				+ ", generata=" + generata + "]";
	}
	
}
