package Modèle.Instruments.Corde;

import Modèle.Instruments.Corde.Guitare;

/*Création de la classe guitarre acoustique qui est une extension de la classe Guitare*/
public class Guitarre_acoustique extends Guitare {
    public boolean droitier;
    public int val_tirant;
    /*Son constructeur avec les différentes variables*/
    public Guitarre_acoustique( int buy_price, int vente_price, int longe, int larg,boolean droite_gauche,int tirant, int nombre_corde){

        prix_achat = buy_price;
        prix_vente = vente_price;
        logueur = longe;
        largeur = larg;

        droitier = droite_gauche;
        val_tirant = tirant;
        nbr_cordes = nombre_corde;
    }
    /*La fonction toString qui permet l'affichage*/
    @Override
    public String toString() {
        return "Guitare acoustique: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n nombres de cordes :"+nbr_cordes+"\n Droitier :"+droitier+" \n valeur tirant "+val_tirant+"\n";
    }
}