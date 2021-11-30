package Controller;

import java.time.LocalDate;
import java.util.ArrayList;

import Model.Acquisto;
import Model.Borsa;
import Model.Giocatore;
import Model.Listino;
import Model.Societa;

public class Controller {
	Borsa b;
	Listino l;
	Giocatore g;
	
	public void nuovaBorsa(String citta) {
		b=new Borsa(citta);
		l =b.getListino();	
	}

	public String getCittaBorsa() {
		if (b==null)
			return "";
		else
			return b.getCitta();
	}

	public String nuovaSocieta(String nomeSocieta, String prezzoAzione) {
		// TODO Verificare che la societa non esista già
		float p;
		String errore="OK";
		try {
			p=Float.parseFloat(prezzoAzione);
			l.addSocieta(new Societa(nomeSocieta,p));
		}catch (NumberFormatException e) {
			errore=new String("Il prezzo non è un numero valido");
		}
		
		return errore;
	}

	public ArrayList getListinoSocietaPrezzo() {
		ArrayList a = new ArrayList();
		if (l.getSocieta()!=null)
			for (Societa s:l.getSocieta()) {
				a.add(s.getNome());
				a.add(s.getPrezzoAzione());
			}
		else 
			a=null;
		return a;
	}

	public boolean cercaSocieta(String nomeSocieta) {
		boolean trovato=false;
		for (Societa s:l.getSocieta())
			if (s.getNome().contentEquals(nomeSocieta)) {
				trovato=true;
			}
		return trovato;
	}

	public void setPrezzoAzione(String societa, float nuovoPrezzo) {
		for (Societa s:l.getSocieta())
			if (s.getNome().contentEquals(societa)) {
				s.setPrezzo(nuovoPrezzo);
			}		
	}

	public void nuovoGiocatore(String nomeGiocatore) {
		// TODO Controllare anche se il giocatore esiste già
		//assumo 1000 come dotazione iniziale
		g= new Giocatore(nomeGiocatore,1000.0f);
		
	}

	public boolean acquista(String nomeSocieta, int quantita) {
		boolean ok=true;
		// TODO Verificare che ci sia disponibilita
		for (Societa s:l.getSocieta())
			if (s.getNome().contentEquals(nomeSocieta)) {
				//verifica
				if (ok) {
					System.out.println("Capitale attuale : "+ g.getCapitale());
					g.acquista(quantita, LocalDate.now(), s.getPrezzoAzione(), s);
					System.out.println("Capitale dopo l'acquisto : "+ g.getCapitale());
					if(g.getLiquidita()<0) 
					    throw new RuntimeException("Errore: non avevi soldi per questo acquisto");
					return true;
				}
			}
		return false;
	}

	public String getNomeGiocatore() {
		return g.getNome();
	}

	public ArrayList getListaAcquisti() {
		return g.getListaAcquisti();
	}

	public String getBilancio() {
		g.calcolaCapitale();
		return ((Float)g.getCapitale()).toString();
	}


}
