package Jeu;


public class Echiquier {

	/**
	 * Création d'un tableau 'plateau' de 64 case pour configurer l'échiquier
	 * Création d'un tableau de charactere afin d'aligner les mettre au tableau
	 * */
	public Case plateau[]= new Case[64];
	char [] alphabet = { ' ',' ','a','b', 'c','d','e','f','g','h'};

	// Constructeur de l'Echiquier
	/**
	 * Constructeur de l'échiquier
	 * Création d'un tableau de charactere afin d'aligner les mettre au tableau
	 * */
	public Echiquier() {
		for (int pos=0;pos<64;pos++)
			this.plateau[pos]=new Case(pos);
	}

	// Setter d'une Case associee au plateau de jeu
	public void setCase(Case b,int position) {
		this.plateau[position]=b;
	}

	// Getter d'une Case associ�e au plateau de jeu
	public Case[] getPlateau() {
		return plateau;
	}

	/**
	 * Affichage de l'Echiquier
	 * la premiere boucle sert a afficher les lettre pour que les joueurs puissent se repérer
	 * la deuxieme boucle affiche le tableau de jeu et les numéro sur le coté du plateau pour se repérer
	 * la troisieme affiche aussi les lettres en dessous du tableau pour se repérer
	 * */
	public String toString(){

		String a="\n";
		int i, g, h;

		for(h=0;h<1;++h) {
			for(int j = 0 ; j < alphabet.length ; j++) {
				a=a +" "+ (alphabet[j]);
			}
			a=a+"\n";
		}

		for ( i=0;i<8;i++)
		{
			a= a +" "+ (8 - i)+" |";
			for ( g=0;g<8;g++)
			{
				a= a + " " + (plateau[(i*8) + g]).toString();

			}
			a=a+ " | "+ (8 - i)+ " \n";
		}

		for(int j=0;j< alphabet.length;j++) {
			a=a +" "+ (alphabet[j])+"";
		}
		return a + "\n";
	}

}		