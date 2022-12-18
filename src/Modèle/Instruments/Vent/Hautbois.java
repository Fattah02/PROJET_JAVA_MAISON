package Modèle.Instruments.Vent;
import Modèle.Instrument;
import Modèle.Instruments.Instrument_a_vent;


public  class Hautbois extends Instrument_a_vent {
    public String typeBois;
    public Hautbois(String name, int buy_price, int vente_price, String type_materiel, String type_instru){
        nom = name;
        prix_achat = buy_price;
        prix_vente = vente_price;
        typeBois = type_materiel;
        type = type_instru;
    }
    @Override
    public String toString(){
        return "Hautbois :\n prix d'achat :"+prix_achat+"\n prix de vente :"+prix_vente+"\n type de bois utilisé :"+typeBois+"\n type de l'instrument :"+type+"\n";
    }







}
