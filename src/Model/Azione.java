package Model;

public class Azione {
	private float prezzo;
	private Societa societa;

	public Azione(Societa s, Float p) {
		societa=s;
		prezzo = p;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	Societa getSocieta() {
		return societa;
	}
	
}
