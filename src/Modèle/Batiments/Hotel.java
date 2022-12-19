package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Personne;

import java.util.*;

/*Création de la classe Hotel qui est une classe abstraite et une extension de la classe Batiment contenant les différents attributs (nombre de chambres, de piscines etc....)*/
public abstract class Hotel extends Batiment {
    protected int nbChambre=1;
    protected int nbSpas=0;
    protected int nbPiscine=0;
    protected Personne[] locataires;
    protected double impot_local_Hotel=0;
    protected int nbEtoile=1;
    protected int nbSuites=0;

    public boolean hasaroom(){
        for(int i=0;i<(nbChambre);i++){
            if(locataires[i]==null){
                return true;
            }
        }
        return false;
    }
}