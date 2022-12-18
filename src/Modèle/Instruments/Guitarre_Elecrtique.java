package Modèle.Instruments;

import java.util.*;

/**
 *
 */
public class Guitarre_Elecrtique extends Guitare {
    public boolean ampli;
    public boolean pedale;

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
    public String toString() {
        return "Guitare électrique: \nprix d'achat  : "+prix_achat+"\nprix de vente : "+prix_vente+"\n sa longueur "+logueur+"\n sa largeur : "+largeur+"\n nombres de cordes :"+nbr_cordes+"\n présence d'amplificateur :"+ampli+" \n effet sonor pédale "+pedale+"\n";
    }


}