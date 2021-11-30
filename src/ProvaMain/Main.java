package ProvaMain;

import java.time.LocalDate;
import java.util.Date;

import Model.Acquisto;
import Model.Borsa;
import Model.Giocatore;
import Model.Listino;
import Model.Societa;

public class Main {

	public static void main(String[] args) {
		Borsa b=new Borsa("Paperopoli");
		Listino l =b.getListino();
		Societa ibm=new Societa("IBM",10.0f);
		l.addSocieta(ibm);
		
		Societa oracle=new Societa("Oracle",12.0f);
		b.getListino().addSocieta(oracle);
		
		Giocatore g = new Giocatore("Paperone",1000f);
		g.acquista(3, LocalDate.now(), ibm.getPrezzoAzione(), ibm);
		g.acquista(2, LocalDate.now(), oracle.getPrezzoAzione(), oracle);
		System.out.println("Il capitale di "+g.getNome()+" ora vale "+g.getCapitale());

		//IBM guadagna il 20%
		ibm.setPrezzo(ibm.getPrezzoAzione()*1.2f);
		g.calcolaCapitale();
		
		System.out.println("Il capitale di "+g.getNome()+" ora vale "+g.getCapitale());
		
		
		

	}

}
