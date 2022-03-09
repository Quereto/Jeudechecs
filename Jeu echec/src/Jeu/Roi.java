package Jeu;

public class Roi extends Piece {

	private boolean estBlanc = false;
	// Constructeur du Roi
	public Roi() {
		super();				// Permet de manipuler les données de la "superclasse"
	}

	public Roi(boolean estBlanc) {
		super();				// Permet de manipuler les données de la "superclasse"
		this.estBlanc = estBlanc;
	}

	// Méthode pour l'affichage du Roi sur la case
	public String toString() {
		String str = "R";
		if(!estBlanc)
			str = "r";

		return str;
	}

	/**
	 * Sert a déplacer le roi selon le joueur
	 * @param pa
	 * @param blanc
	 * */
	@Override
	public void deplacer(Partie pa,Joueur blanc){
		this.deplacement.clear();

		int w=CasePlace;

		boolean droite = true, ddroite = true, mdroite = true, gauche = true, dgauche = true, mgauche = true;

		// Ajout de 8 valeurs par défaut dans la liste du nombre des directions possibles
		for (int i=0; i<8; i++) {
		}

		// Si la pièce est à gauche de l'échiquier
		if (w%8==0) {
			gauche = false;
			mgauche = false;
			dgauche = false;
		}

		// Si la pièce est à droite de l'échiquier
		if (w%8==7) {
			droite = false;
			mdroite = false;
			ddroite = false;
		}

		if (droite==true) {
			this.deplacement.add(1);
		}

		if (gauche==true) {
			this.deplacement.add(-1);
		}

		// Ajoute les déplacements vers le haut et le bas
		// L'interdiction de sortir de l'échiquier est géré plus bas (pos<0 et pos>64)

		this.deplacement.add(-8);

		this.deplacement.add(8);


		// Ajoute les déplacements vers les différentes diagonales

		// Diagonale descendante droite
		if (mdroite==true) {
			this.deplacement.add(9);
		}

		// Diagonale descendante gauche
		if (mgauche==true) {
			this.deplacement.add(7);
		}

		// Diagonale montante droite
		if (ddroite==true) {
			this.deplacement.add(-9);
		}

		// Diagonale montante gauche
		if (dgauche==true) {
			this.deplacement.add(-7);

		}

		// Si la pièce est à gauche de l'échiquier
		if (w%8==0) {
			mgauche=false; dgauche=false;
		}

		// Si la pièce est à droite de l'échiquier
		if (w%8==7) {
			mdroite=false; ddroite=false;
		}
	}

}