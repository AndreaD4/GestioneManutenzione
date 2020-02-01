
public class Segnalazione {

	String desSeg;
	
	public Segnalazione(String desSeg) {
		super();
		this.desSeg = desSeg;
	}
	
	public String getDesSeg() {
		return desSeg;
	}
	public void setDesSeg(String desSeg) {
		this.desSeg = desSeg;
	}
	
	@Override
	public String toString() {
		return "Segnalazione [" + desSeg + "]";
	}
	
	
}
