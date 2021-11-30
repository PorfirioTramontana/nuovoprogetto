package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Giocatore {
	private float capitale;
	private float liquidita;
	private String nome;
	
	private ArrayList<Acquisto> acquisto=null; 
	
	public Giocatore(String n, Float c){
		nome=n;
		capitale = c;
		liquidita=capitale;
		acquisto=new ArrayList<Acquisto>();
	}
	
	public void calcolaCapitale() {
		capitale = liquidita;
		for (Acquisto a:acquisto) {
			capitale += (a.getQuantita()*a.getSocieta().getPrezzoAzione());
		}
	}
	
	public float getCapitale() {
		return capitale;
	}
	public float getLiquidita() {
		return liquidita;
	}
	public String getNome() {
		return nome;
	}

	public void setLiquidita(float f) {
		liquidita=f;
		
	}

	public void acquista(int i, LocalDate now, float prezzo, Societa societa) {
		//TODO : verifica che la liquidita sia sufficiente
		Acquisto a = new Acquisto (i, now, prezzo, societa,this);
		acquisto.add(a);
		calcolaCapitale();
	}

	public ArrayList getListaAcquisti() {
		return acquisto;
	}
	
}
