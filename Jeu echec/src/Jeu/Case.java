package Jeu;

public class Case {

	private int NumCase;			// Numero de la case
	private boolean EtatCase;		// Etat de la case : occupee (true) ou libre (false)
	private Piece p;				// Objet Piece



	/**
	 * Constructeur de la Case
	 * @pram numero Prend en parametre le numéro de la case afin d'initialiser la case comme vide
	 * */

	public Case(int numero) {
		this.NumCase=numero;
		this.EtatCase=false;
	}

	// Getter de la Piece associee a la Case

	public Piece getP() {
		return this.p;
	}

	// Setter de la Piece associee a la Case
	public void setP(Piece pie) {
		this.p = pie;
		this.EtatCase=true;
	}

	// Getter du numero de la Case
	public int getNumCase() {
		return this.NumCase;
	}

	// Setter du numero de la Case
	public void setNumCase(int numCase) {
		this.NumCase = numCase;
	}

	// Getter de l'etat de la Case
	public boolean isEtatCase() {
		return this.EtatCase;
	}

	// Setter de l'etat de la Case
	public void setEtatCase(boolean etatCase) {
		this.EtatCase = etatCase;
		if (etatCase==false){this.p=null;};
	}


	/**
	 * Methode qui affiche une piece sur la case si elle est occupé ou non
	 * */
	public String toString() {

		if (EtatCase==false)
			return ".";
		else
			return p.toString();
	}
}
