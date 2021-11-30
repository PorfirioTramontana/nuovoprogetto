package Model;

import java.time.LocalDate;
import java.util.Date;

public class Acquisto {
	private int quantita;
	private LocalDate istante;
	private float prezzoAcquisto;
	
	private Azione azione;
	private Giocatore acquirente;
	
	public Acquisto(int q, LocalDate localDate, float p, Azione a, Giocatore g){
		acquirente = g;
		azione = a;
		quantita = q;
		istante = localDate;
		prezzoAcquisto = p;
		//aggiorno la liquidita dopo l'acquisto
		g.setLiquidita(g.getLiquidita()-quantita*prezzoAcquisto);
	}
	
	public int getQuantita() {
		return quantita;
	}
	public LocalDate getIstante() {
		return istante;
	}
	public float getPrezzoAcquisto() {
		return prezzoAcquisto;
	}
	public Azione getAzione() {
		return azione;
	}
	public Giocatore getAcquirente() {
		return acquirente;
	}

	
}
