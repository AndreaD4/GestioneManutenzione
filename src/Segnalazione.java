import java.util.Date;

public class Segnalazione {

	String desSeg;
	Date data;
	boolean annullata, generata;
	
	public Segnalazione(String desSeg) {
		super();
		this.desSeg = desSeg;
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

	public String getDesSeg() {
		return desSeg;
	}
	public void setDesSeg(String desSeg) {
		this.desSeg = desSeg;
	}
	
	public Date getData() {
		return data;
	}

	@Override
	public String toString() {
		return "[desrizione=" + desSeg + ", data=" + data + ", annullata=" + annullata + ", generata="
				+ generata + "]";
	}
	
}
