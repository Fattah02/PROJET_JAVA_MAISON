package Modèle;

import java.util.*;

/**
 * 
 */
public class Personne {

    /**
     *
     */
    public String nom;

    /**
     *
     */
    public String prenom;

    /**
     * Default constructor
     */
    public Personne(String name,String surname) {
        nom=name;
        prenom=surname;
    }
    @Override
    public String toString(){
        return nom+" "+prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}