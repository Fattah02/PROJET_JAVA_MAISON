package Modèle.Instruments.Corde;


import Modèle.Instruments.Corde.Piano;

/*Création de la classe PianoDroit qui est une extension de la classe piano*/
public class PianoDroit extends Piano {
    public Boolean cordes_droites;
    public Boolean silence;

    /*Son constructeur avec les différentes variables*/
    public PianoDroit(String name, int buy_price, int vente_price, int longe, int larg, Boolean cordes, int nombre_touche, Boolean silencieux){
        prix_achat = buy_price;
        prix_vente = vente_price;
        logueur = longe;
        largeur = larg;
        nom = name;
        cordes_droites = cordes;
        nbTouches = nombre_touche;
        silence = silencieux;

    }
    /*La fonction toString qui permet l'affichage*/
    @Override
    public String toString() {
        return "Piano Droit: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n silencieux:"+silence+"nombre de touches"+nbTouches+"cordes droites :"+cordes_droites+"\n";
    }

}