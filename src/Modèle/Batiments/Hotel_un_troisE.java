package Modèle.Batiments;

import Modèle.Personne;

import java.util.List;

/*Création de la classe Hotel_un_troisE qui est une extension de la classe Hotel contenant les caractéristiques d'un hotel 3 étoiles*/
public class Hotel_un_troisE extends Hotel {
    /*Son constructeur contenant les différentes varibales*/
    public Hotel_un_troisE(int nbE, int nbroom, List<Personne> loc, String addr, double surfacehab, Personne proprio, double Tauxa, double Tauxb) {
        nbEtoile=nbE;
        nbChambre=nbroom;
        locataires=new Personne[nbroom];
        adresse=addr;
        surfaceH=surfacehab;
        proprietaire=proprio;
        TAUXA=Tauxa;
        TAUXB=Tauxb;
        impot_local_Hotel=Tauxa*surfacehab;
        Type="Hotel(*-***)";
    }

    /*Création de la fonction toString qui permet l'affichage */
    @Override
    public String toString() {
        return "Hotel : \nProprietaire : "+proprietaire+"\nAdresse : "+adresse+"\nNombres d\'etoiles : "+nbEtoile+"\nImpots locaux : "+impot_local_Hotel+"$/mois\nNombre de Chambres : "+nbChambre+"\nSurface Habitable : "+surfaceH+"\n";
    }
}
