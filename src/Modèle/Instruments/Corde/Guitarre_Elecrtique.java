package Modèle.Instruments.Corde;

import Modèle.Instruments.Corde.Guitare;

/*Création de la classe guitarre électrique qui est une extension de la classe Guitare*/
public class Guitarre_Elecrtique extends Guitare {
    public boolean ampli;
    public boolean pedale;

    /*Son constructeur avec les différentes variables*/
    public Guitarre_Elecrtique(String name, int buy_price, int vente_price, int longe,int nombre_corde, int larg,boolean amplificateur, boolean effet_sonore_pedales) {
        prix_achat = buy_price;
        prix_vente = vente_price;
        logueur = longe;
        largeur = larg;
        nom = name;
        nbr_cordes = nombre_corde;
        ampli = amplificateur;
        pedale = effet_sonore_pedales;
    }
    /*La fonction toString qui permet l'affichage*/
    public String toString() {
        return "Guitare électrique: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n nombres de cordes :"+nbr_cordes+"\n présence d'amplificateur :"+ampli+" \n effet sonor pédale "+pedale+"\n";
    }


}