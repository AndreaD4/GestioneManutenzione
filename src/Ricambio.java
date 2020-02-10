
public class Ricambio {

	String descrizione;
	int quantita;
	
	public Ricambio(String desRic, int quantita) {
		super();
		this.descrizione = desRic;
		this.quantita = quantita;
	}

	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String desRic) {
		this.descrizione = desRic;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Ricambio [descrizione=" + descrizione + ", quantita=" + quantita + "]";
	}
}
