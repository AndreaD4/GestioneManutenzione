
public class Ricambio {

	String desRic;
	int quantita;
	
	public Ricambio(String desRic, int quantita) {
		super();
		this.desRic = desRic;
		this.quantita = quantita;
	}

	public String getDesRic() {
		return desRic;
	}
	public void setDesRic(String desRic) {
		this.desRic = desRic;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	@Override
	public String toString() {
		return "[desRic=" + desRic + ", quantita=" + quantita + "]";
	}
}
