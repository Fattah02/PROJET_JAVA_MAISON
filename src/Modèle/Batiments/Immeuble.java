package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Personne;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Immeuble extends Batiment {

    public int nbAppart;
    public List<Personne> locataire;
    public double impot_local_immeuble;

    public Immeuble(int nbA, String addr, double surfacehab,Personne propio) {
        proprietaire=propio;
        adresse = addr;
        nbAppart = nbA;
        locataire = new ArrayList<Personne>();
        surfaceH = surfacehab;
        Type="Immeuble";
        impot_local_immeuble = TAUXA*surfaceH;
    }





    @Override
    public String toString() {

        return "Immeuble : \n Locataire :"+locataire+"\nAdresse :"+adresse+"\nImpots locaux :"+impot_local_immeuble+"\n Nombre d'appartements :"+nbAppart+"\n surafce habitable = "+surfaceH+"\n";
    }






}