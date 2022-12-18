package Modèle.Instruments.Vent;
import Modèle.Instrument;
import Modèle.Instruments.Instrument_a_vent;

/*Création de la classe Hautbois qui est une extension de la classe Instruments à vents*/
public  class Hautbois extends Instrument_a_vent {
    public String typeBois;

    /*Son constructeur avec les différentes variables*/
    public Hautbois(String name, int buy_price, int vente_price, String type_materiel, String type_instru){
        nom = name;
        prix_achat = buy_price;
        prix_vente = vente_price;
        typeBois = type_materiel;
        type = type_instru;
    }
    /*La fonction toString qui permet l'affichage*/
    @Override
    public String toString(){
        return "Hautbois :\n prix d'achat :"+prix_achat+"\n prix de vente :"+prix_vente+"\n type de bois utilisé :"+typeBois+"\n type de l'instrument :"+type+"\n";
    }







}
