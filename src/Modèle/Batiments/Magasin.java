package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Instrument;
import Modèle.Personne;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Magasin extends Batiment {

    /**
     * 
     */
    public List<Instrument> produits;

    /**
     * 
     */
    public Double impot_local_Magasin;



    /**
     * 
     */
    public String toString() {
        // TODO implement here
        return null;
    }


    /**
     * @param prop
     */
    public Magasin( Personne prop,Double surfaceh,String addr) {
        produits=new ArrayList<Instrument>();
        proprietaire=prop;
        surfaceH=surfaceh;
        impot_local_Magasin=TAUXA*surfaceH;
        adresse=addr;
        Type="Magasin";
    }

}