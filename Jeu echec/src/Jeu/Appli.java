package Jeu;


/**
 * Modélise un plateau de jeu dans le jeu de l'échiquier.
 * @author  Rami BEN YEDDER, Maxime
 * @version 4.0
 */

import java.util.Random;

public class Appli {

	public static void main(String[] args) {

		Echiquier a = new Echiquier();

		Joueur j1 = new Joueur(true);
		Joueur j2 = new Joueur();

		Partie pa1 = new Partie(j1, j2, a);
		Jeu game = new Jeu(pa1);

		// Choix du nom des Joueurs et de l'activation de l'aide
		j1.choixNom();
		j2.choixNom();

		System.out.println("Nom du Joueur 1 : '" + j1.getNom() + "' est le joueur Blanc");
		System.out.println("Nom du Joueur 2 : '" + j2.getNom() + "' est le joueur Noir");
		System.out.println("Le joueur Blanc commence ");
		System.out.println("Les pions du joueur Blanc sont affiché en majuscule et les pions du joueur Noir en minuscule");



		// mettre le roi aleatoirement

		Random rand = new Random();

		int n = rand.nextInt(64);
		Case caseTourBlanc = new Case(n);
		caseTourBlanc.setP(j1.getPiece()[0]);
		a.setCase(caseTourBlanc, n);

		n = rand.nextInt(64);
		Case caseRoiBlanc = new Case(n);
		caseRoiBlanc.setP(j1.getPiece()[1]);
		a.setCase(caseRoiBlanc, n);

		n = rand.nextInt(64);
		Case caseTourNoir = new Case(n);
		caseTourNoir.setP(j2.getPiece()[0]);
		a.setCase(caseTourNoir, n);

		n = rand.nextInt(64);
		Case caseRoiNoir = new Case(n);
		caseRoiNoir.setP(j2.getPiece()[1]);
		a.setCase(caseRoiNoir, n);

		// affiche l'échiquier avec les piece disposé aléatoirement a chaque fois
		System.out.print(a);
		j1.choixPieceADeplacer();
		System.out.print(a);

	}


}





