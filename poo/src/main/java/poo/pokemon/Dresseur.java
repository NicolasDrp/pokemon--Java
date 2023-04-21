package poo.pokemon;

import java.util.ArrayList;
import java.util.List;

public class Dresseur {

	private String nom;
	private List<Pokemon> equipe;

	public Dresseur(String nom) {
		this.nom = nom;
		this.equipe = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Pokemon> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Pokemon> equipe) {
		this.equipe = equipe;
	}

}
