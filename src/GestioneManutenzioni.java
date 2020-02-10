import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestioneManutenzioni {

	static List<LineaDiProduzione> listLinPro = new ArrayList<LineaDiProduzione>();
	
	public static void main(String[] args) {
				
		String cod, oper;
		Scanner scan = new Scanner(System.in);
		
		/*
		Ricambio ric1 = new Ricambio("Ugello", 2);
		Ricambio ric2 = new Ricambio("Cuscinetto", 4);
		Ricambio ric3 = new Ricambio("Dado10", 5);
		
		List<Ricambio> listRic = new ArrayList<Ricambio>();
		
		listRic.add(ric1);
		listRic.add(ric2);
		listRic.add(ric3);
		
		Macchinario mac1=new Macchinario(1, "Estrusore");
		Macchinario mac2=new Macchinario(2, "Cesoia");
		Macchinario mac3=new Macchinario(3, "Bilancia");
		
		mac1.setListRic(listRic);
		
		List<Macchinario> listMac = new ArrayList<Macchinario>();
		
		listMac.add(mac1);
		listMac.add(mac2);
		listMac.add(mac3);
		
		LineaDiProduzione linPro1=new LineaDiProduzione(1,"Linea01");
		*/
		
		System.out.println("Inserisci codice di accesso: ");
		
		cod = scan.nextLine();
		if(goAuth(cod)) {
			oper = scan.nextLine();
			goJobAdmin(oper);
		} else {
			oper = scan.nextLine();
			goJobOper(oper);
		}
		scan.close();	
	}
	
	private static boolean goAuth(String cod) {
		String codiceAccesso="0000";
		if (codiceAccesso.equals(cod)) {
			System.out.println("---Gestione Manutenzione--- (Accesso eseguito come: AMMINISTRATORE)");
			System.out.println();
			System.out.println("1. Inserisci Linea di Produzione");
			System.out.println("2. Inserisci Macchinario");
			System.out.println("3. Visualizza manutenzione programmata");
			System.out.println("4. Inserisci manutenzione");
			System.out.println("5. Inserisci ricambi");
			System.out.println("6. Modifica ricambi");
			System.out.println("7. Visualizza segnalazioni");
			System.out.println("8. Genera manutenzione da segnalazione");
			System.out.println("9. Visualizza ricambi");
			System.out.println("0. ESCI");
			System.out.println();
			System.out.println("Digita l'operazione che vuoi effettuare: ");
			return true;
		} else {
			System.out.println("---Gestione Manutenzione--- (Accesso eseguito come: OPERATORE)");
			System.out.println();
			System.out.println("1. Visualizza manutenzione odierna");
			System.out.println("2. Segnala guasto");
			System.out.println("3. Segna manutenzione come completata");
			System.out.println("4. Visualizza ricambi");
			System.out.println("0. ESCI");
			System.out.println();
			System.out.println("Digita l'operazione che vuoi effettuare: ");
			return false;
		}
	}

	private static void goJobAdmin(String oper) {
		Scanner scan = new Scanner(System.in);
		String input, input2, input3, input4;
		int index, quantita;
		Macchinario m;
		switch(oper) {
			case "0":
				System.exit(0);
			case "1":
				System.out.println("---AGGIUNGI LINEA DI PRODUZIONE---");
				System.out.println();
				System.out.println("Inserisci l'ID della nuova Linea di Produzione:");
				input = scan.nextLine();
				System.out.println("Inserisci la descrizione della nuova Linea di Produzione:");
				input2 = scan.nextLine();
				aggiungiLineaDiProduzione(input, input2);
				System.out.println("Linea di Produzione inserita con successo");
				goMenu("0000");
			case "2":
				System.out.println("---AGGIUNGI MACCHINARIO---");
				System.out.println();
				System.out.println("Per quale Linea di Produzione si vuole inserire un macchinario? Indica il numero: ");
				for(int i=0; i<listLinPro.size(); i++) {
					System.out.println(i+". "+listLinPro.get(i).toString());
				}
				input = scan.nextLine();
				index = Integer.parseInt(input);
				System.out.println("Inserisci l'ID del nuovo macchinario:");
				input2 = scan.nextLine();
				System.out.println("Inserisci la descrizione del nuovo macchinario:");
				input3 = scan.nextLine();
				aggiungiMacchinario(input2, input3, listLinPro.get(index));
				System.out.println("Macchinario inserito con successo");
				goMenu("0000");
			case "3":
				System.out.println("---VISUALIZZA MANUTENZIONE PROGRAMMATA---");
				System.out.println();
				for(int a=0; a<listLinPro.size(); a++) {
					for(int i=0; i<listLinPro.get(a).getListMacc().size(); i++) {
						for(int j=0; j<listLinPro.get(a).getListMacc().get(i).listMan.size(); j++) {
							System.out.println(i+". ID: "+listLinPro.get(a).getListMacc().get(i).toString()+ " - " +listLinPro.get(a).getListMacc().get(i).getListMan().toString());
						}
					}
				}
				goMenu("0000");
			case "4":
				System.out.println("---INSERISCI MANUTENZIONE---");
				System.out.println();
				m = selezionaMacchinario();
				System.out.println("Indica il motivo della manutenzione: ");
				input = scan.nextLine();
				aggiungiManutenzione(input, m);
				System.out.println("Manutenzione inserita con successo");
				goMenu("0000");
			case "5":
				System.out.println("---INSERISCI RICAMBI---");
				System.out.println();
				m = selezionaMacchinario();
				System.out.println("Indica la descrizione del ricambio:");
				input3 = scan.nextLine();
				System.out.println("Indica la quantità del ricambio:");
				input4 = scan.nextLine();
				quantita = Integer.parseInt(input4);
				aggiungiRicambio(input3, quantita, m);
				System.out.println("Ricambio aggiunto con successo");
				goMenu("0000");
			case "6":
				System.out.println("---MODIFICA RICAMBI---");
				System.out.println();
				m = selezionaMacchinario();
				System.out.println("Quale ricambio vuoi modificare? Indica il numero:");
				if (m.listRic.size()==0) {
					System.out.println("Lista vuota");
					goMenu("0000");
				}
				for(int i=0; i<m.getListRic().size(); i++) {
					System.out.println(i+". "+m.getListRic().get(i).toString());
				}
				input = scan.nextLine();
				index = Integer.parseInt(input);
				System.out.println("Indica la nuova quantità del ricambio:");
				input2 = scan.nextLine();
				quantita = Integer.parseInt(input2);
				modificaRicambio(quantita, m.getListRic().get(index));
				System.out.println("Quantità del ricambio modificata con successo");
				goMenu("0000");
			case "7":
				System.out.println("---VISUALIZZA SEGNALAZIONI---");
				System.out.println();
				for(int a=0; a<listLinPro.size(); a++) {
					for(int i=0; i<listLinPro.get(a).getListMacc().size(); i++) {
						for(int j=0; j<listLinPro.get(a).getListMacc().get(i).listSeg.size(); j++) {
							System.out.println(i+". ID: "+listLinPro.get(a).getListMacc().get(i).toString()+ " - " +listLinPro.get(a).getListMacc().get(i).getListSeg().toString());
						}
					}
				}
				goMenu("0000");
			case "8":
				System.out.println("---GENERA MANUTENZIONE---");
				System.out.println();
				m = selezionaMacchinario();
				System.out.println("Lista segnalazioni: ");
				if (m.listMan.size()==0) {
					System.out.println("Lista vuota");
					goMenu("0000");
				}
				for(int i=0; i<m.getListSeg().size(); i++) {
					System.out.println(i+". "+m.getListSeg().get(i).toString());
				}
				System.out.println("Indica il numero della segnalazione da generare come manutezione: ");
				input = scan.nextLine();
				index = Integer.parseInt(input);
				generaManutenzione(m.getListSeg().get(index), m);
				System.out.println("Manutenzione generata con successo");
				goMenu("0000");
			case "9":
				System.out.println("---VISUALIZZA RICAMBI---");
				System.out.println();
				for(int a=0; a<listLinPro.size(); a++) {
					for(int i=0; i<listLinPro.get(a).getListMacc().size(); i++) {
						for(int j=0; j<listLinPro.get(a).getListMacc().get(i).listRic.size(); j++) {
							System.out.println(i+". ID: "+listLinPro.get(a).getListMacc().get(i).toString()+ " - " +listLinPro.get(a).getListMacc().get(i).getListRic().toString());
						}
					}
				}
				goMenu("0000");
			default:
				System.out.println("Operazione non valida");
				goMenu("0000");
		}
		scan.close();	
	}
	
	@SuppressWarnings("deprecation")
	private static void goJobOper(String oper) {
		Scanner scan = new Scanner(System.in);
		String input, input2, input3;
		int index, index2, durata;
		Macchinario m;
		switch(oper) {
			case "0":
				System.exit(0);
			case "1":
				System.out.println("---VISUALIZZA MANUTENZIONE ODIERNA---");
				System.out.println();
				Date now = new Date();
				for(int a=0; a<listLinPro.size(); a++) {
					for(int i=0; i<listLinPro.get(a).getListMacc().size(); i++) {
						for(int j=0; j<listLinPro.get(a).getListMacc().get(i).listMan.size(); j++) {
							if(listLinPro.get(a).getListMacc().get(i).listMan.get(j).getData().getDay()==now.getDay() && !listLinPro.get(a).getListMacc().get(i).listMan.get(j).getCompletata())	
								System.out.println(i+". ID: "+listLinPro.get(a).getListMacc().get(i).toString()+ " - " +listLinPro.get(a).getListMacc().get(i).getListMan().toString());
						}
					}
				}
				goMenu("0");
			case "2":
				System.out.println("---SEGNALA GUASTO---");
				System.out.println();
				m = selezionaMacchinario();
				System.out.println("Indica il motivo della segnalazione: ");
				input = scan.nextLine();
				aggiungiSegnalazione(input, m);
				System.out.println("Segnalazione inserita con successo");
				goMenu("0");
			case "3":
				System.out.println("---COMPLETA MANUTENZIONE---");
				System.out.println();
				m=selezionaMacchinario();
				System.out.println("Quale manutenzione vuoi completare? Indica il numero: ");
				if (m.listMan.size()==0) {
					System.out.println("Lista vuota");
					goMenu("0");
				}
				for(int i=0; i<m.listMan.size(); i++) {
					System.out.println(i+". "+m.listMan.toString());
				}
				input = scan.nextLine();
				index = Integer.parseInt(input);
				System.out.println("Quale ricambio hai utilizzato? Indica il numero:");
				if (m.listRic.size()==0) {
					System.out.println("Lista vuota");
					goMenu("0");
				}
				for(int i=0; i<m.listRic.size(); i++) {
					System.out.println(i+". "+m.listRic.get(i).toString());
				}
				input2 = scan.nextLine();
				index2 = Integer.parseInt(input2);
				System.out.println("Quanto ore hai impiegato? Indica il numero intero:");
				input3 = scan.nextLine();
				durata = Integer.parseInt(input3);
				completaManutenzione(m.getListMan().get(index), m.getListRic().get(index2), durata);
				System.out.println("Manutenzione completata con successo");
				goMenu("0");
			case "4":
				System.out.println("---VISUALIZZA RICAMBI---");
				System.out.println();
				for(int a=0; a<listLinPro.size(); a++) {
					for(int i=0; i<listLinPro.get(a).getListMacc().size(); i++) {
						for(int j=0; j<listLinPro.get(a).getListMacc().get(i).listRic.size(); j++) {
							System.out.println(i+". ID: "+listLinPro.get(a).getListMacc().get(i).toString()+ " - " +listLinPro.get(a).getListMacc().get(i).getListRic().toString());
						}
					}
				}
				goMenu("0");
			default:
				System.out.println("Operazione non valida");
				goMenu("0");
		}
		scan.close();		
	}

	private static void goMenu(String cod) {
		Scanner scan = new Scanner(System.in);
		String input;
		if(goAuth(cod)) {
			input = scan.nextLine();
			goJobAdmin(input);
		} else {
			input = scan.nextLine();
			goJobOper(input);
		}
		scan.close();	
	}
	
	private static void generaManutenzione(Segnalazione segnalazione, Macchinario macchinario) {
		Manutenzione manutenzione = new Manutenzione(segnalazione.getDescrizione());
		segnalazione.setGenerata();
		macchinario.addListMan(manutenzione);
	}
	
	private static void aggiungiManutenzione(String descrizione, Macchinario macchinario) {
		Manutenzione manutenzione = new Manutenzione(descrizione);
		macchinario.addListMan(manutenzione);
	}
	
	private static void aggiungiMacchinario(String ID, String descrizione, LineaDiProduzione lineaProduzione) {
		Macchinario macchinario = new Macchinario(ID, descrizione);
		lineaProduzione.addListMacc(macchinario);
	}
	
	private static void aggiungiSegnalazione(String descrizione, Macchinario macchinario) {
		Segnalazione segnalazione = new Segnalazione(descrizione);
		macchinario.addListSeg(segnalazione);
	}
	
	private static void aggiungiRicambio(String descrizione, int quantita, Macchinario macchinario) {
		Ricambio ricambio = new Ricambio(descrizione, quantita);
		macchinario.addListRic(ricambio);
	}
	
	private static void aggiungiLineaDiProduzione(String ID, String descrizione) {
		LineaDiProduzione lineaProduzione = new LineaDiProduzione(ID, descrizione);
		listLinPro.add(lineaProduzione);
	}
	
	private static void modificaRicambio(int quantita, Ricambio ricambio) {
		ricambio.setQuantita(quantita);
	}
	
	private static void completaManutenzione(Manutenzione manutenzione, Ricambio ricambio, int durata) {
		manutenzione.setCompletata(ricambio, durata);
	}
	
	private static Macchinario selezionaMacchinario() {
		Scanner scan = new Scanner(System.in);
		String input, input2;
		int index, index2;
		System.out.println("Indica il numero della Linea di produzione: ");
		for(int i=0; i<listLinPro.size(); i++) {
			System.out.println(i+". "+listLinPro.get(i).toString());
		}
		input = scan.nextLine();
		index = Integer.parseInt(input);
		System.out.println("Indica il numero del macchinario: ");
		for(int i=0; i<listLinPro.get(index).listMacc.size(); i++) {
			System.out.println(i+". "+listLinPro.get(index).listMacc.get(i).toString());
		}
		input2 = scan.nextLine();
		index2 = Integer.parseInt(input2);
	
		return listLinPro.get(index).listMacc.get(index2);
	}
}
