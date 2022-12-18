package Modèle;

/*Création de la classe Batiment qui est la première classe abstraite des toutes les résidences conetnant toutes les caractéristiques communes(adresse, suarface habitable etc..)*/
public abstract class Batiment {
    protected String Type;
    /**
     * 
     */
    protected String adresse;

    /**
     * 
     */
    protected double surfaceH;

    /**
     * 
     */
    protected Personne proprietaire;

    /**
     * 
     */
    protected double TAUXA = 5.6;

    /**
     * 
     */
    protected double TAUXB = 1.5;
    /**
     * @param pers
     */
    /*Les setter et getter pour récuperer le propriétaire de chaque batiment*/
    public void setProprio(Personne pers){
        proprietaire=pers;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }
    /*Les fonctions pour retourner la surface habitable, l'adresse et le type des différents batiments*/
    public double getSurfaceH() {
        return surfaceH;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getType() {
        return Type;
    }
}