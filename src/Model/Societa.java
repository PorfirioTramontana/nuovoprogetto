package Model;

public class Societa {

	private String nome;
	private float prezzoAzione;

	public Societa(String string, float f) {
		nome=string;
		prezzoAzione=f;
	}

	public String getNome() {
		return nome;
	}

	public float getPrezzoAzione() {
		return prezzoAzione;
	}

	public void setPrezzo(float f) {
		prezzoAzione=f;
		
	}

}
