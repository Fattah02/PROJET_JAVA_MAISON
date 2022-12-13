package Modèle;

/**
 * 
 */
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
    public void setProprio(Personne pers){
        proprietaire=pers;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

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