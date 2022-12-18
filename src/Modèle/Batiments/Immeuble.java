package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Personne;

/**
 *
 */
public class Immeuble extends Batiment {

    public int nbAppart;
    public Personne[] locataire;
    public double impot_local_immeuble;

    public Immeuble(int nbA, String addr, double surfacehab, Personne[] loc, double Tauxa, double Tauxb) {
        adresse = addr;
        nbAppart = nbA;
        locataire = loc;
        surfaceH = surfacehab;
        TAUXA = Tauxa;
        TAUXB = Tauxb;
        impot_local_immeuble = TAUXA*surfaceH;
    }





    @Override
    public String toString() {

        return "Immeuble : \n Locataire :"+locataire+"\nAdresse :"+adresse+"\nImpots locaux :"+impot_local_immeuble+"\n Nombre d'appartements :"+nbAppart+"\n surafce habitable = "+surfaceH+"\n";
    }






}