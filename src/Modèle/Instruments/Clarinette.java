import Modèle.Batiments.Instrument_a_vent;
import Modèle.Instrument;

import java.util.*;

/**
 *
 */
public class Clarinette extends Instrument_a_vent {




    public int taille;

    public Clarinette(String name, int buy_price, int vente_price,String type_instru, int size) {
        nom = name;
        prix_achat = buy_price;
        prix_vente = vente_price;
        taille = size;
        type2= type_instru;
    }
    @Override
    public String toString(){
        return "Clarinette :\n prix d'achat :"+prix_achat+"\n prix de vente :"+prix_vente+"\n sa taille :"+taille+"\n son type :"+type2+"\n";
    }


}