package Model;

import java.time.LocalDate;
import java.util.Date;

public class Acquisto {
	private int quantita;
	private LocalDate istante;
	private float prezzoAcquisto;
	
	private Societa societa;
	private Giocatore acquirente;
	
	public Acquisto(int q, LocalDate localDate, float p, Societa a, Giocatore g){
		acquirente = g;
		societa = a;
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
	public Societa getSocieta() {
		return societa;
	}
	public Giocatore getAcquirente() {
		return acquirente;
	}


	
}
