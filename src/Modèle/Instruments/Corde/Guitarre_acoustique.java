package Modèle.Instruments.Corde;

import Modèle.Instruments.Corde.Guitare;

/**
 *
 */
public class Guitarre_acoustique extends Guitare {
    public boolean droitier;
    public int val_tirant;
    public Guitarre_acoustique(String name, int buy_price, int vente_price, int longe, int larg,boolean droite_gauche,int tirant, int nombre_corde){
        prix_achat = buy_price;
        prix_vente = vente_price;
        logueur = longe;
        largeur = larg;
        nom = name;
        droitier = droite_gauche;
        val_tirant = tirant;
        nbr_cordes = nombre_corde;
    }
    @Override
    public String toString() {
        return "Guitare acoustique: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n nombres de cordes :"+nbr_cordes+"\n Droitier :"+droitier+" \n valeur tirant "+val_tirant+"\n";
    }
}