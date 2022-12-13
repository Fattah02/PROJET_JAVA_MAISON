package Modèle.Batiments;

import Modèle.Personne;

import java.util.List;

/**
 * 
 */
public class Hotel_CinqE extends Hotel{
    public Hotel_CinqE(int nbE, int nbPiscines ,int nbSuite, int nbroom, List<Personne> loc, String addr, double surfacehab, Personne proprio, double Tauxa, double Tauxb) {
        nbEtoile=nbE;
        nbChambre=nbroom;
        locataires=loc;
        adresse=addr;
        surfaceH=surfacehab;
        proprietaire=proprio;
        TAUXA=Tauxa;
        TAUXB=Tauxb;
        impot_local_Hotel=Tauxa*surfacehab;
        nbPiscine=nbPiscines;
        nbSuites=nbSuite;
        Type="Hotel(*****)";
    }


    @Override
    public String toString() {
        return "Hotel : \nProprietaire : "+proprietaire+"\nAdresse : "+adresse+"\nNombres d\'etoiles : "+nbEtoile+"\nNombre de Spas : "+nbSpas+"Impots locaux : "+impot_local_Hotel+"$/mois\nNombre de Chambres : "+nbChambre+"\nSurface Habitable : "+surfaceH+"\n";
    }

}