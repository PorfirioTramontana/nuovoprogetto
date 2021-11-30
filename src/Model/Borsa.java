package Model;

public class Borsa {
	private String citta="New York";
	private Listino listino;
	
	public Borsa() {
		listino = new Listino();
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Listino getListino() {
		return listino;
	}
}
