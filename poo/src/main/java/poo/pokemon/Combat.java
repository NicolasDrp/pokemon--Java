package poo.pokemon;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Combat {

	private Dresseur dresseur1;
	private Dresseur dresseur2;
	Scanner scanner = new Scanner(System.in);

	public Combat(Dresseur dresseurJoueur, Dresseur dresseurIA) {
		this.dresseur1 = dresseurJoueur;
		this.dresseur2 = dresseurIA;
	}

	public void CommencerCombat() {
		boolean aGagner = false;
		Pokemon dernierPokemonAttaque = null; // keep track of last Pokemon that attacked
		while (!aGagner) {
			//choisir d'attquer ou de changer de pokemon
			Pokemon poke1 = choixAction(dresseur1);
			if (poke1 == null && dernierPokemonAttaque == null) {
				System.out.println("Vous devez choisir un Pokémon pour attaquer !");
				continue;
			} else if (poke1 != null && dernierPokemonAttaque != null && poke1.equals(dernierPokemonAttaque)) {
				System.out.println("Vous ne pouvez pas attaquer avec le même Pokémon deux fois de suite !");
				continue;
			} else if (poke1 == null) {
				poke1 = dernierPokemonAttaque;
			}

			// on choisit un pokemon
			Pokemon poke2 = choisirPokemon(dresseur2);

			// tant que les poke sont pas morts
			while (poke1.getPv() > 0 && poke2.getPv() > 0) {

				// ajouter choix , attaquer ou changer de pokemon pour attaquer
				dernierPokemonAttaque = poke1; // update last Pokemon that attacked

				poke2 = poke1.laBagarre(poke2);

				if (poke2.getPv() <= 0) {
					System.out.println("Le " + poke2.getNom() + " de " + dresseur2.getNom() + " est KO !");
					poke2.setKo(true);
					break;
				}

				poke1 = poke2.laBagarre(poke1);

				if (poke1.getPv() <= 0) {
					System.out.println("Le " + poke1.getNom() + " de " + dresseur1.getNom() + " est KO !");
					poke1.setKo(true);
					break;
				}
			}
			if (!PokemonVivant(dresseur1)) {
				System.out.println("Le combat est terminé ! . " + dresseur2.getNom() + " gagne");
				aGagner = true;
			} else if (!PokemonVivant(dresseur2)) {
				System.out.println("Le combat est terminé ! . " + dresseur1.getNom() + " gagne");
				aGagner = true;
			}
		}
	}
	
//	public void CommencerCombat() {
//		boolean aGagner = false;
//		while (!aGagner) {
//			//choisir d'attquer ou de changer de pokemon
//			choixAction(dresseur1);
//			
//			
//			// on choisit un pokemon
//			Pokemon poke1 = choisirPokemon(dresseur1);
//
//			// on choisit un pokemon
//			Pokemon poke2 = choisirPokemon(dresseur2);
//
//			// tant que les poke sont pas morts
//			while (poke1.getPv() > 0 && poke2.getPv() > 0) {
//
//				// ajouter choix , attaquer ou changer de pokemon pour attaquer
//
//				poke2 = poke1.laBagarre(poke2);
//
//				if (poke2.getPv() <= 0) {
//					System.out.println("Le " + poke2.getNom() + " de " + dresseur2.getNom() + " est KO !");
//					poke2.setKo(true);
//					break;
//				}
//
//				poke1 = poke2.laBagarre(poke1);
//
//				if (poke1.getPv() <= 0) {
//					System.out.println("Le " + poke1.getNom() + " de " + dresseur1.getNom() + " est KO !");
//					poke1.setKo(true);
//					break;
//				}
//			}
//			if (!PokemonVivant(dresseur1)) {
//				System.out.println("Le combat est terminé ! . " + dresseur2.getNom() + " gagne");
//				aGagner = true;
//			} else if (!PokemonVivant(dresseur2)) {
//				System.out.println("Le combat est terminé ! . " + dresseur1.getNom() + " gagne");
//				aGagner = true;
//			}
//
//		}
//	}

	private Pokemon choixAction(Dresseur dresseur) {
		int choix = 0;
		while (choix <=0 || choix >2) {
			try {
				System.out.print("1 ou 2");
				choix = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrée invalide , entrez un nombre entier ex(1,99)");
				scanner.nextLine();
			}
		}
		if (choix == 1) {
			return choisirPokemon(dresseur);
		} else {
			return null;
		}
	}
//	private void choixAction(Dresseur dresseur) {
//		int choix = 0;
//		while (choix <=0 || choix >2) {
//			try {
//				System.out.print("");
//				choix = scanner.nextInt();
//				scanner.nextLine();
//			} catch (InputMismatchException e) {
//				System.out.println("Entrée invalide , entrez un nombre entier ex(1,99)");
//				scanner.nextLine();
//			}
//		}
//		if (choix == 1) {
//			choisirPokemon(dresseur);
//		}
//	}
	
	/**
	 * @param dresseur
	 * @return
	 * 
	 * Permet de choisir avec quel pokemon attaquer ou continuer
	 */
	private Pokemon choisirPokemon(Dresseur dresseur) {
		List<Pokemon> equipe = dresseur.getEquipe();
		try {
			System.out.println("\033[0;33m" + dresseur.getNom() + ", choisissez un Pokémon : \033[0m");
			int i;
			for (i = 0; i < equipe.size(); i++) {
				if (!equipe.get(i).isKo()) {
					System.out.println("\033[0;36m" + (i + 1) + ". " + equipe.get(i).getNom() + " (PV : \033[0;32m"
							+ equipe.get(i).getPv() + "\033[0m)" + " (ATK : \033[0;31m" + equipe.get(i).getAttaque()
							+ "\033[0m)" + " (Type : \033[0;35m" + equipe.get(i).getType() + "\033[0m)"
							+ " (NIV : \033[0;34m" + equipe.get(i).getNiveau() + "\033[0m)");
				}
			}
			System.out.println("\033[0;36m"+(i+1)+". Annuler");
			int choix = scanner.nextInt();
			return equipe.get(choix - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private Pokemon changerPokemon(Dresseur dresseur) {
		List<Pokemon> equipe = dresseur.getEquipe();
		try {
			System.out.println("\033[0;33m" + dresseur.getNom() + ", choisissez un Pokémon : \033[0m");
			int i;
			for (i = 0; i < equipe.size(); i++) {
				if (!equipe.get(i).isKo()) {
					System.out.println("\033[0;36m" + (i + 1) + ". " + equipe.get(i).getNom() + " (PV : \033[0;32m"
							+ equipe.get(i).getPv() + "\033[0m)" + " (ATK : \033[0;31m" + equipe.get(i).getAttaque()
							+ "\033[0m)" + " (Type : \033[0;35m" + equipe.get(i).getType() + "\033[0m)"
							+ " (NIV : \033[0;34m" + equipe.get(i).getNiveau() + "\033[0m)");
				}
			}
			System.out.println("\033[0;36m"+(i+1)+". Annuler");
			int choix = scanner.nextInt();
			return equipe.get(choix - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	private Pokemon choisirPokemon(Dresseur dresseur) {
//		List<Pokemon> equipe = dresseur.getEquipe();
//		try {
//			System.out.println("\033[0;33m" + dresseur.getNom() + ", choisissez un Pokémon : \033[0m");
//
//			for (int i = 0; i < equipe.size(); i++) {
//				if (!equipe.get(i).isKo()) {
//					System.out.println("\033[0;36m" + (i + 1) + ". " + equipe.get(i).getNom() + " (PV : \033[0;32m"
//							+ equipe.get(i).getPv() + "\033[0m)" + " (ATK : \033[0;31m" + equipe.get(i).getAttaque()
//							+ "\033[0m)" + " (Type : \033[0;35m" + equipe.get(i).getType() + "\033[0m)"
//							+ " (NIV : \033[0;34m" + equipe.get(i).getNiveau() + "\033[0m)");
//				}
//			}
//			int choix = scanner.nextInt();
//			return equipe.get(choix - 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * @param dresseur
	 * @return
	 * 
	 *         Permet de verifier si un pokemon est encore vivant dans l'équipe du
	 *         dresseur
	 */
	private boolean PokemonVivant(Dresseur dresseur) {
		List<Pokemon> equipe = dresseur.getEquipe();
		for (int i = 0; i < equipe.size(); i++) {
			if (!equipe.get(i).isKo()) {
				return true;
			}
		}
		return false;
	}
}