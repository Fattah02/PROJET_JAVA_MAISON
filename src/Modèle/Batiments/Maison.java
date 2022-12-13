package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Personne;

/**
 * 
 */
public class Maison extends Batiment {

    /**
     * 
     */
    public int nbPiece;

    /**
     * 
     */
    public double surfaceJ;

    /**
     * 
     */
    public double impot_local_Maison;

    /**
     * @param nbP
     */
    public Maison(int nbP, String addr, double surfacehab, double surfacejardin, Personne proprio, double Tauxa, double Tauxb) {
        adresse=addr;
        surfaceH=surfacehab;
        surfaceJ=surfacejardin;
        proprietaire=proprio;
        TAUXA=Tauxa;
        TAUXB=Tauxb;
        nbPiece=nbP;
        impot_local_Maison=TAUXA*surfaceH+TAUXB*surfaceJ;
        Type="Maison";
    }

    /**
     *
     */
    public String toString() {
        return "Maison : \nProprietaire : "+proprietaire+"\nAdresse : "+adresse+"\nImpots locaux : "+impot_local_Maison+"$/mois\nNombre de pieces : "+nbPiece+"\nSurface habitable : "+surfaceH+"\nSurface du Jardin : "+surfaceJ+"\n";
    }
}