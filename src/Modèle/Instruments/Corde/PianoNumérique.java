package Modèle.Instruments.Corde;

import Modèle.Instruments.Corde.Piano;

/*Création de la classe PianoNumérique qui est une extension de la classe piano*/
public class PianoNumérique extends Piano {
    public boolean toucherLourd;
    public double qualiteEchantillonnage;

    /*Son constructeur avec les différentes variables*/
    public PianoNumérique(String name, int buy_price, int vente_price, int longe, int larg, int nombre_touche, Boolean type_toucher, Double qual_ech) {
        prix_achat = buy_price;
        prix_vente = vente_price;
        logueur = longe;
        largeur = larg;
        nom = name;
        nbTouches = nombre_touche;
        toucherLourd = type_toucher;
        qualiteEchantillonnage = qual_ech;

    }
    /*La fonction toString qui permet l'affichage*/
    @Override
    public String toString() {
        return "Piano numérique: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n type de toucher:"+toucherLourd+" \n nombre de touches"+nbTouches+" \n qualité d'echantillonnage :"+qualiteEchantillonnage+"\n";
    }


}