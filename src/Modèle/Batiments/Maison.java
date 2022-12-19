package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Personne;

/*Création de la classe Maison qui est une extension de la classe batiment qui contient les caractéristiques de la Maison*/
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
    /*Son constructeur contenant les différentes varibales*/
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
    /*Création de la fonction toString qui permet l'affichage */
    public String toString() {
        return "Maison : \nProprietaire : "+proprietaire+"|\nAdresse : "+adresse+"|\nImpots locaux : "+impot_local_Maison+"$/mois|\nNombre de pieces : "+nbPiece+"|\nSurface habitable : "+surfaceH+"|\nSurface du Jardin : "+surfaceJ+"\n";
    }
}