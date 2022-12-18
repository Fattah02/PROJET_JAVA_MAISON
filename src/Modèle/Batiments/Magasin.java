package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Instrument;
import Modèle.Personne;

import java.util.ArrayList;
import java.util.List;

/*Création de la classe Magasin qui est une extension de la classe batiment qui contient les caractéristiques du magasin*/
public class Magasin extends Batiment {

    /**
     * 
     */
    public List<Instrument> produits;

    /**
     * 
     */
    public Double impot_local_Magasin;



    /*Création de la fonction toString qui permet l'affichage */
    public String toString() {
        return "Magasin : \n les produits :"+produits+"\n le propriétaire"+proprietaire+"\n la surafce habitable :"+surfaceH+"\n Impots locaux"+impot_local_Magasin+"\n adresse :"+adresse+"\ntype :"+Type+"\n";
    }


    /**
     * @param prop
     */
    /*Son constructeur contenant les différentes varibales*/
    public Magasin( Personne prop,Double surfaceh,String addr) {
        produits=new ArrayList<Instrument>();
        proprietaire=prop;
        surfaceH=surfaceh;
        impot_local_Magasin=TAUXA*surfaceH;
        adresse=addr;
        Type="Magasin";
    }

}