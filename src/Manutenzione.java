import java.util.Date;

public class Manutenzione {

	String desMan;
	Date data;
	boolean completata;
	Ricambio ricUtil;
	
	public Manutenzione(String desMan) {
		super();
		this.desMan = desMan;
		this.data = new Date();
		this.completata = false;
	}
	
	public String getDesMan() {
		return desMan;
	}
	public void setDesMan(String desMan) {
		this.desMan = desMan;
	}
	public boolean getCompletata() {
		return completata;
	}
	public void setCompletata(Ricambio ricUtil) {
		this.ricUtil = ricUtil;
		this.completata = true;
	}
	public Date getData() {
		return data;
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
			return "Manutenzione [desMan=" + desMan + ", data=" + data + ", completata= "+completata+", ricambio utilizzato"+ricUtil.toString()+"]";
		else
			return "Manutenzione [desMan=" + desMan + ", data=" + data + ", completata= "+completata+"]";
	}


}
