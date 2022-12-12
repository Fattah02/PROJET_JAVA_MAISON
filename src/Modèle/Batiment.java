package Modèle;

/**
 * 
 */
public abstract class Batiment {
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
    public void setProprio(Personne pers){
        proprietaire=pers;
    }
}