package Jeu;

import java.util.ArrayList;

public abstract class Piece {

	protected int CasePlace;				// Numero de la case associee a la Piece
	private boolean etat;					// sert a savoir si une piece est toujours en jeu ou si elle a était manger par l'adversaire

	protected ArrayList<Integer> deplacement = new ArrayList<Integer>();


	public ArrayList<Integer> getDeplacement() {  return deplacement; }

	// Constructeur de la Piece sans arguments
	public Piece () { this.etat=true; }

	/**
	 * Contructeur d'une pieces avec arguements
	 * @param c pour avoir le numéro de la pieces
	 * */
	public Piece(int c) {
		this.etat=true;
		this.CasePlace=c;
	}

	// Getter de l'etat de la Piece
	public boolean isEtat() {
		return etat;
	}

	/**
	 * Sert a savoir l'état d'une piece si elle est toujours en jeu ou hors jeu
	 * @param etat
	 * */
	public void setEtat(boolean etat) {
		this.etat = etat;
		if (etat==false)
			this.CasePlace=65;
	}

	// Getter du numero de la case associee a la Piece
	public int isCase() {
		return CasePlace;
	}

	// Setter du numero de la case associee a la Piece
	public void setCase(int c) {
		this.CasePlace = c;
	}

	public abstract void deplacer(Partie pa, Joueur blanc);
}
