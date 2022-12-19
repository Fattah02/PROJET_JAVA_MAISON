package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Personne;

import java.util.ArrayList;
import java.util.List;

/*Création de la classe Immeuble qui est une extension de la classe batiment qui contient les caractéristiques de l'immeuble*/
public class Immeuble extends Batiment {

    private int nbAppart;
    private Personne[] locataires;
    private double impot_local_immeuble;
    private int nbfreerooms;

    /*Son constructeur contenant les différentes varibales*/
    public Immeuble(int nbA, String addr, double surfacehab,Personne propio) {
        proprietaire=propio;
        adresse = addr;
        nbAppart = nbA;
        locataires = new Personne[nbAppart];
        surfaceH = surfacehab;
        Type="Immeuble";
        impot_local_immeuble = TAUXA*surfaceH;
        nbfreerooms=nbAppart;
    }

    /*Création de la fonction toString qui permet l'affichage */
    @Override
    public String toString() {

        return "Immeuble : \n Locataire :"+locataires+"|\nAdresse :"+adresse+"|\nImpots locaux :"+impot_local_immeuble+"|\n Nombre d'appartements :"+nbAppart+"|\n surafce habitable = "+surfaceH+"\n";
    }

    public int getNbAppart() {
        return nbAppart;
    }

    public boolean hasaroom(){
        for(int i=0;i<(nbAppart);i++){
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
            for (int i = 0; i < nbAppart; i++) {
                if(locataires[i]==null){
                    nbfreerooms+=1;
                }
            }
        }catch (NullPointerException error){}
    }

    public int getNbfreerooms() {
        return nbfreerooms;
    }
}