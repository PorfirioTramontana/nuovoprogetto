package Model;

import java.util.ArrayList;

public class Listino {
	private ArrayList<Societa> societa;
	
	Listino() {
		societa=new ArrayList<Societa>();
	}
	
	public void addSocieta(Societa s) {
		//TODO Verificare che la societa non sia già presente
		societa.add(s);
	}

	/**
	 * @return the societa
	 */
	public ArrayList<Societa> getSocieta() {
		return societa;
	}
	
}
