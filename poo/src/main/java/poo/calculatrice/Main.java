package poo.calculatrice;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donne un nombre");
		double nombre1 = sc.nextDouble();
		System.out.println("Bon toutou , un deuxieme maintenant");
		double nombre2 = sc.nextDouble();

		Calculatrice calcul = new Calculatrice();
		double resultatAddition = calcul.somme(nombre1, nombre2);
		double resultatSoustraction = calcul.soustraction(nombre1, nombre2);
		double resultatMultiplication = calcul.multiplication(nombre1, nombre2);
		double resultatDivision = calcul.division(nombre1, nombre2);
		double resultatModulo = calcul.modulo(nombre1, nombre2);

		System.out.println("Vu qut'es con , jvais t'dire , l'addition fait " + resultatAddition);
		System.out.println("Vu qut'es con , jvais t'dire , la soustraction fait " + resultatSoustraction);
		System.out.println("Vu qut'es con , jvais t'dire , la multiplication fait " + resultatMultiplication);
		System.out.println("Vu qut'es con , jvais t'dire , la division fait " + resultatDivision);
		System.out.println("Vu qut'es con , jvais t'dire , le modulo fait " + resultatModulo);
	
		sc.close();
	}
}
