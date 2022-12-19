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
    protected int nbfreerooms;
    protected int nbfreesuits;

    public int getNbfreerooms() {
        return nbfreerooms;
    }
    public int getNbfreesuits() {
        return nbfreerooms;
    }

    public boolean hasaroom(){
        for(int i=0;i<(nbChambre);i++){
            if(locataires[i]==null){
                return true;
            }
        }
        return false;
    }
    public boolean isdisponible(int room_number){
        if(locataires[room_number]==null){
            return true;
        }else {
            return false;
        }
    }

    public void setLocataire(Personne locataire,int room) {
        this.locataires[room] = locataire;
        try {
            nbfreerooms=0;
            for (int i = 0; i < nbChambre; i++) {
                if(locataires[i]==null){
                    nbfreerooms+=1;
                }
            }
            if(nbSuites<0) {
                nbfreesuits = 0;
                for (int i = nbChambre; i < (nbChambre + nbSuites); i++) {
                    if (locataires[i] == null) {
                        nbfreesuits += 1;
                    }
                }
            }
        }catch (NullPointerException error){}
    }

    public int getNbChambre() {
        return nbChambre;
    }

    public int getNbSuites() {
        return nbSuites;
    }
}