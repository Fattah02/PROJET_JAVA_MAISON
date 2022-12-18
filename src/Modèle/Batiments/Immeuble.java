package Modèle.Batiments;

import Modèle.Batiment;
import Modèle.Personne;

import java.util.ArrayList;
import java.util.List;

/*Création de la classe Immeuble qui est une extension de la classe batiment qui contient les caractéristiques de l'immeuble*/
public class Immeuble extends Batiment {

    public int nbAppart;
    public List<Personne> locataire;
    public double impot_local_immeuble;
    /*Son constructeur contenant les différentes varibales*/
    public Immeuble(int nbA, String addr, double surfacehab,Personne propio) {
        proprietaire=propio;
        adresse = addr;
        nbAppart = nbA;
        locataire = new ArrayList<Personne>();
        surfaceH = surfacehab;
        Type="Immeuble";
        impot_local_immeuble = TAUXA*surfaceH;
    }

    /*Création de la fonction toString qui permet l'affichage */
    @Override
    public String toString() {

        return "Immeuble : \n Locataire :"+locataire+"\nAdresse :"+adresse+"\nImpots locaux :"+impot_local_immeuble+"\n Nombre d'appartements :"+nbAppart+"\n surafce habitable = "+surfaceH+"\n";
    }






}