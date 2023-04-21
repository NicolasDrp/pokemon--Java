package poo.pokemon;

public class Main {

	public static void main(String[] args) {

		Pokemon eau = new Pokemon("pokeeau", "eau", 200, 40, 5);
		Pokemon feu = new Pokemon("pokefeu", "feu", 100, 49, 3);
		Pokemon plante = new Pokemon("pokeplante", "plante", 150, 31, 1);

		Pokemon eau2 = new Pokemon("pokeeau", "eau", 200, 40, 5);
		Pokemon feu2 = new Pokemon("pokefeu", "feu", 100, 49, 3);
		Pokemon plante2 = new Pokemon("pokeplante", "plante", 150, 31, 1);
		
		Dresseur sarace = new Dresseur("Sarace");
		Dresseur tomace = new Dresseur("Thomace");

		tomace.getEquipe().add(eau);
		tomace.getEquipe().add(feu);
		tomace.getEquipe().add(plante);

		sarace.getEquipe().add(eau2);
		sarace.getEquipe().add(feu2);
		sarace.getEquipe().add(plante2);

		Combat choix = new Combat(tomace, sarace);

		choix.CommencerCombat();

	}

}
