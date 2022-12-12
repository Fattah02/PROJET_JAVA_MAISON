
import Controller.Controller;
import Modèle.Batiment;
import Vue.Renderer;

import java.util.*;

/**
 * 
 */
public class Main {
    private static Renderer rend;
    private static List<Batiment> batiments;


    /**
     * Default constructor
     */
    public static void main(String[] args) {
        rend=new Renderer();
        batiments=new ArrayList<Batiment>();

        new Controller(batiments,rend);

    }


    /**
     * 
     */
    public void createBatiment() {
        // TODO implement here
    }


}