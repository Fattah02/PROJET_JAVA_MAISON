package Modèle.Instruments.Corde;


import Modèle.Instruments.Corde.Piano;

/**
 *
 */
public class Piano_a_queue extends Piano {
    public String taille;
    public Piano_a_queue(String name, int buy_price, int vente_price, String size, int longe, int larg, int nombre_touche){
        prix_achat = buy_price;
        prix_vente = vente_price;
        logueur = longe;
        largeur = larg;
        nom = name;
        taille = size;
        nbTouches = nombre_touche;



    }
    @Override
    public String toString() {
        return "Piano à queue: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n taille:"+taille+"nombre de touches"+nbTouches+"\n";
    }

}

