package Modèle.Instruments.Vent;

import Modèle.Instrument;
import Modèle.Instruments.Instrument_a_vent;

/*Création de la classe FluteTraversière qui est une extension de la classe Instruments à vents*/
public class FluteTraversière extends Instrument_a_vent {

    public int diametre;

    /*Son constructeur avec les différentes variables*/
    public FluteTraversière(String name, int buy_price, int vente_price,String type_instru, int diameter) {
        nom = name;
        prix_achat = buy_price;
        prix_vente = vente_price;
        type = type_instru;
        diametre = diameter;
    }
    /*La fonction toString qui permet l'affichage*/
    @Override
    public String toString(){
        return "Modèle.Instruments.Vent.Clarinette :\n prix d'achat :"+prix_achat+"\n prix de vente :"+prix_vente+"\n son diametre :"+diametre+"\n son type :"+type+"\n";
    }


}