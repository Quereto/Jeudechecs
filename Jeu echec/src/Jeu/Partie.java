package Jeu;


// Classe Partie

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

    private Joueur j1;
    private Joueur j2;
    private Echiquier echiquierPartie;


    // Constructeur
    public Partie(Joueur j1, Joueur j2, Echiquier echiquierPartie) {
        this.j1 = j1;
        this.j2 = j2;
        this.echiquierPartie = echiquierPartie;
    }

    // Getter du Joueur 1 de la Partie
    public Joueur getJ1() {
        return this.j1;
    }

    // Setter du Joueur 1 de la Partie
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    // Getter du Joueur 2 de la Partie
    public Joueur getJ2() {
        return this.j2;
    }

    // Setter du Joueur 1 de la Partie
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

    // Getter de l'Echiquier de la Partie
    public Echiquier getEchiquierPartie() {
        return this.echiquierPartie;
    }

    // Setter de l'Echiquier de la Partie
    public void setEchequierPartie(Echiquier echiquierPartie) {
        this.echiquierPartie = echiquierPartie;
    }


    // Méthode pour déplacer une pièce
    /**
     * On regarde tous les déplacements possibles pour toutes les pieces
     * @param p prends une pieces en parametre pour voir check ses déplacements possible
     * @pram blanc pour savoir quels joueurs est entrain de jouer
     * */

    public void deplacementPossible(Piece p, Joueur blanc) {
        ArrayList<Integer> deplacementPossible = new ArrayList<Integer>();
        ArrayList<Integer> deplacement = p.getDeplacement();
        int somme = 0;
        Case c = echiquierPartie.getPlateau()[p.isCase()];

        boolean nopresent = true;
        int pos = 0;


        // Si le déplacement sort en dehors de l'échiquier
        if (c.getNumCase() + deplacement.get(pos + somme) < 0 || c.getNumCase() + deplacement.get(pos + somme) >= 64) {
            nopresent = false;
        } else {
            if (echiquierPartie.getPlateau()[c.getNumCase() + deplacement.get(pos + somme)].isEtatCase() == true) {
                for (int pos2 = 0; pos2 < 16; pos2++) {
                    // Si le déplacement est sur une pièce nous appartient
                    if (echiquierPartie.getPlateau()[c.getNumCase() + deplacement.get(pos + somme)].getNumCase() == blanc.getPiece()[pos2].isCase()) {
                        System.out.println(blanc.getPiece()[pos2].isCase());
                        nopresent = false;
                    }
                }

                // Si le déplacement est sur une pièce adverse on peut la capturer mais on ne peut pas aller plus loin
                if (nopresent == true) {
                    nopresent = false;
                    deplacementPossible.add(deplacement.get(pos + somme));
                }
            }
        }

        // Si le déplacement n'est sur aucune pièce on peut aller plus loin
        if (nopresent == true) {
            deplacementPossible.add(deplacement.get(pos + somme));
        }

        pos++;
    }

    // On affiche les différents déplacements possibles
    //remplacer ca par les case en surbrillance et les listener de deplacements

    /**
     * On regarde tous les déplacements possibles pour toutes les pieces
     * @param deplacementPossible on utilise une arraylist afin d'enregistrer tous les déplacements possible
     *@param p prends une pieces en parametre pour voir check ses déplacements possible
     *         cette fonction sert a voir si le déplacements de la pieces que le joueur souhaite déplacer est valide
     * */

    public int ChoixDuDeplacement(ArrayList<Integer> deplacementPossible,Piece p){
        for (int pos1=0;pos1<deplacementPossible.size();pos1++){
            System.out.println("Choix "+pos1+" : ");
            System.out.println(p.isCase()+deplacementPossible.get(pos1));
        }
        if (deplacementPossible.size()==0){return 0;}
        Scanner sc=new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * On regarde tous les déplacements possibles pour toutes les pieces
     * @param deplacementChoisi
     *@param p prends une pieces en parametre
     * */

    public void deplacementChoisi(int deplacementChoisi,Piece p){
        Case c=echiquierPartie.getPlateau()[p.isCase()];

        if (echiquierPartie.getPlateau()[deplacementChoisi].isEtatCase()==false) {
            echiquierPartie.getPlateau()[deplacementChoisi].setEtatCase(true);
            echiquierPartie.getPlateau()[deplacementChoisi].setP(c.getP());
            echiquierPartie.getPlateau()[c.getNumCase()].getP().setCase(deplacementChoisi);
            echiquierPartie.getPlateau()[c.getNumCase()].setP(null);
            echiquierPartie.getPlateau()[c.getNumCase()].setEtatCase(false);
        }
        else
        {
            echiquierPartie.getPlateau()[deplacementChoisi].getP().setEtat(false);
            echiquierPartie.getPlateau()[deplacementChoisi].getP().setCase(65);
            echiquierPartie.getPlateau()[deplacementChoisi].setEtatCase(true);
            echiquierPartie.getPlateau()[deplacementChoisi].setP(c.getP());
            echiquierPartie.getPlateau()[deplacementChoisi].getP().setCase(deplacementChoisi);
            echiquierPartie.getPlateau()[c.getNumCase()].setP(null);
            echiquierPartie.getPlateau()[c.getNumCase()].setEtatCase(false);
        }
        p.setCase(deplacementChoisi);
    }
}

