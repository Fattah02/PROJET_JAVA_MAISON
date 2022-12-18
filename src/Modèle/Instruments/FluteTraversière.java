package Modèle.Instruments;

import Modèle.Batiments.Instrument_a_vent;

import java.util.*;

/**
 *
 */
public class FluteTraversière extends Instrument_a_vent {

    public int diametre;
    public FluteTraversière(String name, int buy_price, int vente_price,String type_instru, int diameter) {
        nom = name;
        prix_achat = buy_price;
        prix_vente = vente_price;
        type1 = type_instru;
        diametre = diameter;
    }
    @Override
    public String toString(){
        return "Clarinette :\n prix d'achat :"+prix_achat+"\n prix de vente :"+prix_vente+"\n son diametre :"+diametre+"\n son type :"+type1+"\n";
    }


}