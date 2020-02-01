import java.util.Date;

public class Segnalazione {

	String desSeg;
	Date data;
	
	public Segnalazione(String desSeg) {
		super();
		this.desSeg = desSeg;
		this.data = new Date();
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
		return "Segnalazione [" + desSeg + "]";
	}
	
	
}
