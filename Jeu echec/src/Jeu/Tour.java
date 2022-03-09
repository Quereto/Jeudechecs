package Jeu;

public class Tour extends Piece{
    boolean estBlanc = false;

    public Tour() {
        super();
    }

    public Tour(boolean estBlanc) {
        super();
        this.estBlanc = estBlanc;
    }

    public String toString(){
        String str = "T";
        if(!estBlanc)
            str = "t";

        return str;
    }

    /**
     * Sert a déplacer la tour selon le joueurs
     * @param pa
     * @param blanc
     * */
    @Override
    public void deplacer (Partie pa, Joueur blanc){
        this.deplacement.clear();
        int d = CasePlace;


        boolean droite = true;
        boolean gauche = false;


        //  vérifie si la piece et tout a gauche ou tout a droite
        if(d%8==0){
            gauche =false;
        }

        if (d % 8 == 7) {
            droite = false;
        }

        // fait en sorte que les pieces ne sortent pas de l'échiquier
        for (int pos=1; pos<=8; pos++) {
            this.deplacement.add(-8*pos);
        }
        for (int pos=1; pos<=8; pos++) {
            this.deplacement.add(8*pos);

        }
    }
}
