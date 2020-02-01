import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfaccia {

	public static void main(String[] args) {
		
		String cod, oper;
		Scanner scan = new Scanner(System.in);
		
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
		
		Linea_produzione linPro1=new Linea_produzione("Linea01", listMac);
		
		System.out.println("Inserisci codice di accesso: ");
		
		cod = scan.nextLine();
		if(goAuth(cod)) {
			oper = scan.nextLine();
			goJobAdmin(oper,linPro1);
		} else {
			oper = scan.nextLine();
			goJobOper(oper,linPro1);
		}
		scan.close();	
	}
	
	private static boolean goAuth(String cod) {
		String codiceAccesso="0000";
		if (codiceAccesso.equals(cod)) {
			System.out.println("---Gestione Manutenzione--- (Accesso eseguito come: AMMINISTRATORE)");
			System.out.println();
			System.out.println("1. Visualizza manutenzione programmata");
			System.out.println("2. Inserisci manutenzione");
			System.out.println("3. Visualizza ricambi");
			System.out.println("4. Inserisci ricambi");
			System.out.println("5. Modifica ricambi");
			System.out.println("6. Visualizza segnalazioni");
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
			System.out.println();
			System.out.println("Digita l'operazione che vuoi effettuare: ");
			return false;
		}
	}

	private static void goJobAdmin(String oper, Linea_produzione linPro) {
		Scanner scan = new Scanner(System.in);
		String input, input2, input3;
		switch(oper) {
			case "1":
				System.out.println("---VISUALIZZA MANUTENZIONE PROGRAMMATA---");
				System.out.println();
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					for(int j=0; j<linPro.getListMacc().get(i).listMan.size(); j++) {
						System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc+", "+linPro.getListMacc().get(i).listMan.get(j).toString());
					}
				}
				goExit(linPro);
			case "2":
				System.out.println("---INSERISCI MANUTENZIONE---");
				System.out.println();
				System.out.println("Per quale macchinario si vuole organizzare una manutenzione? Indica il numero: ");
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc);
				}
				input = scan.nextLine();
				System.out.println("Indica il motivo della manutenzione: ");
				input2 = scan.nextLine();
				Manutenzione man=new Manutenzione(input2);
				linPro.getListMacc().get(Integer.parseInt(input)).addListMan(man);
				System.out.println("Manutenzione inserita con successo");
				goExit(linPro);
			case "3":
				System.out.println("---VISUALIZZA RICAMBI---");
				System.out.println();
				System.out.println("Di quale macchinario vuoi visualizzare il ricambio? Indica il numero: ");
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc);
				}
				input = scan.nextLine();
				System.out.println("Lista ricambi");
				for(int i=0; i<linPro.getListMacc().get(Integer.parseInt(input)).listRic.size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc+", Ricambio: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).desRic+", Quantità: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).quantita);
				}
				goExit(linPro);
			case "4":
				System.out.println("---INSERISCI RICAMBI---");
				System.out.println();
				System.out.println("Di quale macchinario vuoi inserire il ricambio? Indica il numero: ");
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc);
				}
				input = scan.nextLine();
				System.out.println("Indica la descrizione del ricambio:");
				input2 = scan.nextLine();
				System.out.println("Indica la quantità del ricambio:");
				input3 = scan.nextLine();
				Ricambio ric = new Ricambio(input2, Integer.parseInt(input3));
				linPro.getListMacc().get(Integer.parseInt(input)).addListRic(ric);
				System.out.println("Ricambio aggiunto con successo");
				goExit(linPro);
			case "5":
				System.out.println("---MODIFICA RICAMBI---");
				System.out.println();
				System.out.println("Di quale macchinario vuoi modificare il ricambio? Indica il numero: ");
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc);
				}
				input = scan.nextLine();
				System.out.println("Quale ricambio vuoi modificare? Indica il numero:");
				if (linPro.getListMacc().get(Integer.parseInt(input)).listRic.size()==0) {
					System.out.println("Lista vuota");
					goExit(linPro);
				}
				for(int i=0; i<linPro.getListMacc().get(Integer.parseInt(input)).listRic.size(); i++) {
					System.out.println(i+". Ricambio: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).desRic+", Quantità: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).quantita);
				}
				input2 = scan.nextLine();
				System.out.println("Indica la nuova quantità del ricambio:");
				input3 = scan.nextLine();
				linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(Integer.parseInt(input2)).setQuantita(Integer.parseInt(input3));
				System.out.println("Quantità del ricambio modificata con successo");
				goExit(linPro);
			case "6":
				System.out.println("---VISUALIZZA SEGNALAZIONI---");
				System.out.println();
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					for(int j=0; j<linPro.getListMacc().get(i).listSeg.size(); j++) {
						System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc+", Segnalazione: "+linPro.getListMacc().get(i).listSeg.get(j).desSeg);
					}
				}
				goExit(linPro);
			default:
				System.out.println("Operazione non valida");
				goExit(linPro);
		}
		scan.close();	
	}
	
	@SuppressWarnings("deprecation")
	private static void goJobOper(String oper, Linea_produzione linPro) {
		Scanner scan = new Scanner(System.in);
		String input, input2, input3;
		
		switch(oper) {
			case "1":
				System.out.println("---VISUALIZZA MANUTENZIONE ODIERNA---");
				System.out.println();
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					for(int j=0; j<linPro.getListMacc().get(i).listMan.size(); j++) {
						Date now=new Date();
						if(linPro.getListMacc().get(i).listMan.get(j).getData().getDay()==now.getDay() && !linPro.getListMacc().get(i).listMan.get(j).getCompletata())
							System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc+", "+linPro.getListMacc().get(i).listMan.get(j).toString());
					}
				}
				goExit(linPro);
			case "2":
				System.out.println("---SEGNALA GUASTO---");
				System.out.println();
				System.out.println("Quale macchinario si è guastato? Indica il numero: ");
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc);
				}
				input = scan.nextLine();
				System.out.println("Indica il motivo della segnalazione: ");
				input2 = scan.nextLine();
				Segnalazione seg=new Segnalazione(input2);
				linPro.getListMacc().get(Integer.parseInt(input)).addListSeg(seg);
				System.out.println("Segnalazione inserita con successo:\n"+seg.toString());
				goExit(linPro);
			case "3":
				System.out.println("---COMPLETA MANUTENZIONE---");
				System.out.println();
				System.out.println("Di quale macchinario vuoi completare la manutenzione? Indica il numero: ");
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc);
				}
				input = scan.nextLine();
				System.out.println("Lista manutenzioni");
				if (linPro.getListMacc().get(Integer.parseInt(input)).listMan.size()==0) {
					System.out.println("Lista vuota");
					goExit(linPro);
				}
				for(int i=0; i<linPro.getListMacc().get(Integer.parseInt(input)).listMan.size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc+", "+linPro.getListMacc().get(Integer.parseInt(input)).listMan.toString());
				}
				System.out.println("Quale manutenzione vuoi completare? Indica il numero:");
				input2 = scan.nextLine();
				System.out.println("Quale ricambio hai utilizzato? Indica il numero:");
				System.out.println("Lista ricambi");
				for(int i=0; i<linPro.getListMacc().get(Integer.parseInt(input)).listRic.size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc+", Ricambio: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).desRic+", Quantità: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).quantita);
				}
				input3 = scan.nextLine();
				linPro.getListMacc().get(Integer.parseInt(input)).listMan.get(Integer.parseInt(input2)).setCompletata();
				linPro.getListMacc().get(Integer.parseInt(input)).listMan.get(Integer.parseInt(input2)).setRicUtil(linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(Integer.parseInt(input3)));
				System.out.println("Manutenzione completata con successo");
				goExit(linPro);
			case "4":
				System.out.println("---VISUALIZZA RICAMBI---");
				System.out.println();
				System.out.println("Di quale macchinario vuoi visualizzare il ricambio? Indica il numero: ");
				for(int i=0; i<linPro.getListMacc().size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc);
				}
				input = scan.nextLine();
				System.out.println("Lista ricambi");
				for(int i=0; i<linPro.getListMacc().get(Integer.parseInt(input)).listRic.size(); i++) {
					System.out.println(i+". ID: "+linPro.getListMacc().get(i).id+", Descrizione: "+linPro.getListMacc().get(i).desMacc+", Ricambio: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).desRic+", Quantità: "+linPro.getListMacc().get(Integer.parseInt(input)).listRic.get(i).quantita);
				}
				goExit(linPro);
			default:
				System.out.println("Operazione non valida");
				goExit(linPro);
		}
		scan.close();		
	}

	private static void goExit(Linea_produzione linPro) {
		Scanner scan = new Scanner(System.in);
		String input,cod;
		System.out.println("Vuoi fare un'altra operazione? (S/N)");
		input=scan.nextLine();
		if(input.equals("S") || input.equals("s")) {
			System.out.println("Inserisci di nuovo il codice di accesso: ");
			cod = scan.nextLine();
			if(goAuth(cod)) {
				input = scan.nextLine();
				goJobAdmin(input,linPro);
			} else {
				input = scan.nextLine();
				goJobOper(input,linPro);
			}
		} else {
			System.exit(0);
		}
		scan.close();	
	}
	
}
