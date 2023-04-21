package poo.pokemon;

public class Pokemon {

	private String nom;
	private String type;
	private int pv;
	private int attaque;
	private int niveau;
	private boolean ko;

	public Pokemon(String nom, String type, int pv, int attaque, int niveau) {
		this.nom = nom;
		this.type = type;
		this.pv = pv;
		this.attaque = attaque;
		this.niveau = niveau;
		this.setKo(false);
	}

	public Pokemon laBagarre(Pokemon a) {
		System.out
				.println(nom + " (PV : " + pv + ") fais la bagarre contre " + a.getNom() + " (PV : " + a.getPv() + ")");
		int degat = (int) (Math.random() * ((attaque - 1) + 1)) + 1;
		int pvrestant = a.getPv() - degat;
		a.setPv(pvrestant);
		return a;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public boolean isKo() {
		return ko;
	}

	public void setKo(boolean ko) {
		this.ko = ko;
	}

}
