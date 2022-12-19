package Vue;

import Modèle.Instruments.Corde.Guitarre_acoustique;
import Modèle.Personne;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Modèle.Instruments.Corde.*;
import Modèle.Instruments.Vent.Clarinette;
import Modèle.Instruments.Vent.FluteTraversière;
import Modèle.Instruments.Vent.Hautbois;
import Modèle.Personne;


public class instru_creator {
    protected String nom = "name";
    protected int prix_achat=0;
    protected int prix_vente=0;
    private String[] personnes;



    public static Guitarre_acoustique displayGuitarre_acoustiqueBuild(){
        JTextField field0 = new JTextField("Takamine");
        JTextField field1 = new JTextField("10");
        JTextField field2 = new JTextField("5");
        JTextField field3 = new JTextField("20");
        JTextField field4 = new JTextField("10");
        JTextField field5 = new JTextField("oui");
        JTextField field6 = new JTextField("1");
        JTextField field7 = new JTextField("6");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom :"));
        panel.add(field0);
        panel.add(new JLabel("Prix d'achat :"));
        panel.add(field1);
        panel.add(new JLabel("Prix de vente :"));
        panel.add(field2);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field3);
        panel.add(new JLabel("Sa largeur"));
        panel.add(field4);
        panel.add(new JLabel("Droitier?"));
        panel.add(field5);
        panel.add(new JLabel("valeur du tirant (1 à 3) :"));
        panel.add(field6);
        panel.add(new JLabel("nombres de cordes"));
        panel.add(field7);

        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
           return new Guitarre_acoustique(field0.getText(),Integer.parseInt(field1.getText()),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),Integer.parseInt(field4.getText()),Boolean.parseBoolean(field5.getText()),Integer.parseInt(field6.getText()),Integer.parseInt(field7.getText()));


        }
        else{
            return null;
        }

    }



    public static Guitarre_Elecrtique displayGuitarre_ElecBuild() {


        JTextField field1 = new JTextField("Super Strat");
        JTextField field2 = new JTextField("10");
        JTextField field3 = new JTextField("20");
        JTextField field4 = new JTextField("70");
        JTextField field5 = new JTextField("40");
        JTextField field6 = new JTextField("6");
        JTextField field7 = new JTextField("oui");
        JTextField field8 = new JTextField("non");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom :"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat :"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente"));
        panel.add(field3);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field4);
        panel.add(new JLabel("Sa largeur :"));
        panel.add(field5);
        panel.add(new JLabel("nombres de cordes"));
        panel.add(field6);
        panel.add(new JLabel("Présence d'un amplificateur?"));
        panel.add(field7);
        panel.add(new JLabel("Présence des pédales d'effets sonores?"));
        panel.add(field8);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Electrique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new Guitarre_Elecrtique(field1.getText(),Integer.getInteger(field2.getText()),Integer.getInteger(field3.getText()),Integer.getInteger(field4.getText()),Integer.getInteger(field5.getText()),Integer.getInteger(field6.getText()),Boolean.getBoolean(field7.getText()),Boolean.getBoolean(field8.getText()));

        }
        else{
            return null;
        }

    }


    public static Piano_a_queue displayPiano_a_queueBuild() {


        JTextField field1 = new JTextField("YAMAHA GB1");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("30");
        JTextField field4 = new JTextField("60");
        JTextField field5 = new JTextField("40");
        JTextField field6 = new JTextField("1/2");
        JTextField field7 = new JTextField("88");


        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom :"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat':"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente"));
        panel.add(field3);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field4);
        panel.add(new JLabel("Sa largeur :"));
        panel.add(field5);
        panel.add(new JLabel("Sa taille"));
        panel.add(field6);
        panel.add(new JLabel("Nombre de touches :"));
        panel.add(field7);

        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Piano à queue",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new Piano_a_queue(field1.getText(),Integer.getInteger(field2.getText()),Integer.getInteger(field3.getText()),field4.getText(),Integer.getInteger(field5.getText()),Integer.getInteger(field6.getText()),Integer.getInteger(field7.getText()));

        }
        else{
            return null;
        }

    }


    public static PianoDroit displayPianoDroitBuild() {

        JTextField field1 = new JTextField("YAMAHA U1");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("70");
        JTextField field4 = new JTextField("40");
        JTextField field5 = new JTextField("10");
        JTextField field6 = new JTextField("oui");
        JTextField field7 = new JTextField("88");
        JTextField field8 = new JTextField("non");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom :"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat':"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente"));
        panel.add(field3);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field4);
        panel.add(new JLabel("Sa largeur:"));
        panel.add(field5);
        panel.add(new JLabel("Des cordes droites ?"));
        panel.add(field6);
        panel.add(new JLabel("Nombre de touches :"));
        panel.add(field7);
        panel.add(new JLabel("Doté d'un silencieux"));
        panel.add(field8);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Piano droit",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new PianoDroit(field1.getText(),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),Integer.parseInt(field4.getText()),Integer.parseInt(field5.getText()),Boolean.parseBoolean(field6.getText()),Integer.parseInt(field7.getText()),Boolean.parseBoolean(field8.getText()));


        }
        else{
            return null;
        }

    }



    public static PianoNumérique displayPianoNumériqueBuild() {


        JTextField field1 = new JTextField("Kawai");
        JTextField field2 = new JTextField("100");
        JTextField field3 = new JTextField("120");
        JTextField field4 = new JTextField("40");
        JTextField field5 = new JTextField("15");
        JTextField field6 = new JTextField("88");
        JTextField field7 = new JTextField("non");
        JTextField field8 = new JTextField("2");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom :"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat':"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente"));
        panel.add(field3);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field4);
        panel.add(new JLabel("Sa largeur:"));
        panel.add(field5);
        panel.add(new JLabel("Nombre de touches :"));
        panel.add(field6);
        panel.add(new JLabel("Toucher lourd ?"));
        panel.add(field7);
        panel.add(new JLabel("Qualité d'échantillonage"));
        panel.add(field8);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Piano numérique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new PianoNumérique(field1.getText(),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),Integer.parseInt(field4.getText()),Integer.parseInt(field5.getText()),Integer.parseInt(field6.getText()),Boolean.parseBoolean(field7.getText()),Double.parseDouble(field8.getText()));


        }
        else{
            return null;
        }

    }



    public static Clarinette displayClarinetteBuild() {


        JTextField field1 = new JTextField("cor de basset");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("30");
        JTextField field4 = new JTextField("Clarinette en ut");
        JTextField field5 = new JTextField("25");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom:"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat' :"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente"));
        panel.add(field3);
        panel.add(new JLabel("Son type"));
        panel.add(field4);
        panel.add(new JLabel("Sa taille :"));
        panel.add(field5);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter une Clarinette",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new Clarinette(field1.getText(),Integer.parseInt(field2.getText()),Integer.getInteger(field3.getText()),field4.getText(),Integer.getInteger(field5.getText()));

        }
        else{
            return null;
        }

    }



    public static FluteTraversière displayFluteTraversièreBuild() {

        JTextField field1 = new JTextField("Traverso");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("30");
        JTextField field4 = new JTextField("Picollo");
        JTextField field5 = new JTextField("26");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom:"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat' :"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente"));
        panel.add(field3);
        panel.add(new JLabel("Son type"));
        panel.add(field4);
        panel.add(new JLabel("Son diamètre :"));
        panel.add(field5);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Flute traversière",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new FluteTraversière(field1.getText(),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),field4.getText(),Integer.parseInt(field5.getText()));


        }
        else{
            return null;
        }

    }


    public static Hautbois displayHautboisBuild() {
        JTextField field1 = new JTextField("cor de basset");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("30");
        JTextField field4 = new JTextField("le bois de rose");
        JTextField field5 = new JTextField("hautbois baroque");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Son nom:"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat' :"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente :"));
        panel.add(field3);
        panel.add(new JLabel("Type de bois :"));
        panel.add(field4);
        panel.add(new JLabel("Son type :"));
        panel.add(field5);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Hautbois",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new Hautbois(field1.getText(),Integer.parseInt(field2.getText()),Integer.parseInt(field3.getText()),field4.getText(),field5.getText());

        }
        else{
            return null;
        }

    }


    public void updatePers(List<Personne> pers){
        int compt=0;
        personnes=new String[pers.size()];
        for (Personne p:pers) {
            personnes[compt]=p.toString();
            compt++;
        }
    }
}
