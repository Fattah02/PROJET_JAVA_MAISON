package Modèle.Instruments.Corde;


import Modèle.Instruments.Corde.Piano;

/*Création de la classe Piano_a_queue qui est une extension de la classe piano*/
public class Piano_a_queue extends Piano {
    public String taille;
    /*Son constructeur avec les différentes variables*/
    public Piano_a_queue(String name, int buy_price, int vente_price, String size, int longe, int larg, int nombre_touche){
        prix_achat = buy_price;
        prix_vente = vente_price;
        logueur = longe;
        largeur = larg;
        nom = name;
        taille = size;
        nbTouches = nombre_touche;



    }
    /*La fonction toString qui permet l'affichage*/
    @Override
    public String toString() {
        return "Piano à queue: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n taille:"+taille+"nombre de touches"+nbTouches+"\n";
    }

}

