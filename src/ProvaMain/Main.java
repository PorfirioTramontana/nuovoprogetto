package ProvaMain;

import java.time.LocalDate;
import java.util.Date;

import Model.Acquisto;
import Model.Azione;
import Model.Borsa;
import Model.Giocatore;
import Model.Listino;
import Model.Societa;

public class Main {

	public static void main(String[] args) {
		Borsa b=new Borsa();
		Listino l =b.getListino();
		Societa ibm=new Societa("IBM");		
		l.addSocieta(ibm);
		Azione azioneIbm = new Azione(ibm,10.0f);
		
		Societa oracle=new Societa("Oracle");
		b.getListino().addSocieta(oracle);
		Azione azioneOracle = new Azione(oracle, 12.0f);
		
		Giocatore g = new Giocatore("Paperone",1000f);
		g.acquista(3, LocalDate.now(), azioneIbm.getPrezzo(), azioneIbm);
		g.acquista(2, LocalDate.now(), azioneOracle.getPrezzo(), azioneOracle);
		System.out.println("Il capitale di "+g.getNome()+" ora vale "+g.getCapitale());

		//IBM guadagna il 20%
		azioneIbm.setPrezzo(azioneIbm.getPrezzo()*1.2f);
		g.calcolaCapitale();
		
		System.out.println("Il capitale di "+g.getNome()+" ora vale "+g.getCapitale());
		
		
		

	}

}
