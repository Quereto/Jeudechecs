package Jeu;


import java.util.Scanner;

// Classe Joueur

public class Joueur {

    boolean estBlanc = false;               // les blancs = false et les noirs = true
    private String nom;						// Nom du Joueur
    private Piece piece[]= new Piece[2];	// Création d'un tableau comportant ^2 pieces


    // Constructeur du Joueur
    public Joueur() {
        this.piece[0]=new Tour(estBlanc);
        this.piece[1]=new Roi(estBlanc);

    }

    public Joueur(boolean estBlanc) {
        this.piece[0]=new Tour(estBlanc);
        this.piece[1]=new Roi(estBlanc);
        this.estBlanc = estBlanc;

    }

    // Getter du nom du Joueur
    public String getNom() {
        return this.nom;
    }

    // Setter du nom du Joueur
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter de la Piece associée au Joueur
    public Piece[] getPiece() {
        return this.piece;
    }

    // Setter de la Piece associée au Joueur
    public void setPiece(Piece[] piece) {
        this.piece = piece;
    }

    // Choix du nom du Joueur
    public void choixNom() {
        System.out.println("Nom du Joueur");
        Scanner sc = new Scanner(System.in);
        String n=sc.nextLine();
        this.nom=n;
    }


    public int choixPieceADeplacer(){
        System.out.println(this.nom+ " piece a deplacer? selectionner un nombre");
        int pos;
        do{
            for (pos=0;pos<2;pos++)
                if(piece[pos].isEtat()==true){System.out.println(pos+"."+piece[pos]);}
            Scanner sc=new Scanner(System.in);
            pos=sc.nextInt();}
        while(piece[pos].isEtat()!=true);
        return pos;

    }

}
