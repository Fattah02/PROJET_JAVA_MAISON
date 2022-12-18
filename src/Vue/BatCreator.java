package Vue;

import Modèle.Batiments.*;
import Modèle.Instruments.Corde.*;
import Modèle.Instruments.Vent.Clarinette;
import Modèle.Instruments.Vent.FluteTraversière;
import Modèle.Instruments.Vent.Hautbois;
import Modèle.Personne;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BatCreator {
    private double tauxA=5.6;
    private double tauxB=1.5;
    private String[] personnes;
    public Maison displayHouseBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("1");
        JTextField field2 = new JTextField("test");
        JTextField field3 = new JTextField("0.0");
        JTextField field4 = new JTextField("15.0");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Nombre de Pieces :"));
        panel.add(field1);
        panel.add(new JLabel("Adresse :"));
        panel.add(field2);
        panel.add(new JLabel("Surface Habitable :"));
        panel.add(field3);
        panel.add(new JLabel("Surface Jardin :"));
        panel.add(field4);
        int result = JOptionPane.showConfirmDialog(null, panel, "Création de Maison",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Maison res;
            try {
                Double sh=Double.parseDouble(field3.getText());
                Double sj=Double.valueOf(field4.getText());

                res = new Maison(Integer.parseInt(field1.getText()), field2.getText(),sh,sj,pers.get(combo.getSelectedIndex()), tauxA, tauxB);
            }catch(NumberFormatException error){
                System.out.println("Format des nombres incorrect");
                return null;
            }
            return res;
        } else {
            return null;
        }
    }

    public Hotel displayHotelBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JComboBox<String> combo2 = new JComboBox<>(new String[]{"1 Etoile","2 Etoiles","3 Etoiles","4 Etoiles","5 Etoiles"});
        JTextField field1 = new JTextField("1");
        JTextField field2 = new JTextField("test");
        JTextField field3 = new JTextField("0");
        JTextField field4 = new JTextField("0");
        JTextField field5 = new JTextField("150.0");
        JTextField field6 = new JTextField("2");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Nombre d\'etoiles"));
        panel.add(combo2);
        panel.add(new JLabel("Nombre de Chambres :"));
        panel.add(field1);
        panel.add(new JLabel("Adresse :"));
        panel.add(field2);
        panel.add(new JLabel("Nombre de spas (**** ou *****) :"));
        panel.add(field3);
        panel.add(new JLabel("Nombre de piscines (***** :"));
        panel.add(field4);
        panel.add(new JLabel("Nombre de Suites :"));
        panel.add(field6);
        panel.add(new JLabel("Surface Habitable :"));
        panel.add(field5);
        int result = JOptionPane.showConfirmDialog(null, panel, "Création d\'Hotel",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Hotel res=null;
            if(combo2.getSelectedIndex()==3){
                res=new Hotel_QuatreE(
                        combo2.getSelectedIndex()+1,
                        Integer.parseInt(field3.getText()),
                        Integer.parseInt(field1.getText()),
                        new ArrayList<Personne>(),
                        field2.getText(),
                        Double.parseDouble(field5.getText()),
                        pers.get(combo.getSelectedIndex()),
                        tauxA,tauxB);

            }else if(combo2.getSelectedIndex()==4){
                res=new Hotel_CinqE(
                        combo2.getSelectedIndex()+1,
                        Integer.parseInt(field4.getText()),
                        Integer.parseInt(field6.getText()),
                        Integer.parseInt(field1.getText()),
                        new ArrayList<Personne>(),
                        field2.getText(),
                        Double.parseDouble(field5.getText()),
                        pers.get(combo.getSelectedIndex()),
                        tauxA,tauxB);
            }
            else{
                res=new Hotel_un_troisE(
                        combo2.getSelectedIndex()+1,
                        Integer.parseInt(field1.getText()),
                        new ArrayList<Personne>(),
                        field2.getText(),
                        Double.parseDouble(field5.getText()),
                        pers.get(combo.getSelectedIndex()),
                        tauxA,tauxB);
            }
            return res;
        } else {
            return null;
        }
    }
    public Immeuble displayImmeubleBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("1");
        JTextField field2 = new JTextField("test");
        JTextField field3 = new JTextField("10");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Nombre d'appartements :"));
        panel.add(field1);
        panel.add(new JLabel("Adresse :"));
        panel.add(field2);
        panel.add(new JLabel("Surface Habitable :"));
        panel.add(field3);
        int result = JOptionPane.showConfirmDialog(null, panel, "Création de magasin",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new Immeuble(Integer.parseInt(field1.getText()),field2.getText(),Double.parseDouble(field3.getText()),pers.get(combo.getSelectedIndex()));
        }
        else{
            return null;
        }
    }
    public Magasin displayMagasinBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("1");
        JTextField field2 = new JTextField("exemple");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Surface Habitalbe :"));
        panel.add(field1);
        panel.add(new JLabel("Adresse :"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Création de magasin",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new Magasin(pers.get(combo.getSelectedIndex()),Double.parseDouble(field1.getText()),field2.getText());
        }
        else{
            return null;
        }
    }
    public Guitarre_acoustique displayGuitarre_acoustiqueBuild(List<Personne> pers){
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("10");
        JTextField field2 = new JTextField("5");
        JTextField field3 = new JTextField("20");
        JTextField field4 = new JTextField("oui");
        JTextField field5 = new JTextField("1");
        JTextField field6 = new JTextField("6");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Prix d'achat :"));
        panel.add(field1);
        panel.add(new JLabel("Prix de vente :"));
        panel.add(field2);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field3);
        panel.add(new JLabel("droitier ?"));
        panel.add(field4);
        panel.add(new JLabel("valeur du tirant :"));
        panel.add(field5);
        panel.add(new JLabel("nombres de cordes"));
        panel.add(field6);

        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            /*return new Guitarre_acoustique(pers.get(combo.getSelectedIndex()),Double.parseDouble();*/
            return null;

        }
        else{
            return null;
        }

    }

    public Guitarre_Elecrtique displayGuitarre_ElecBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("10");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("70");
        JTextField field4 = new JTextField("40");
        JTextField field5 = new JTextField("Super Strat");
        JTextField field6 = new JTextField("6");
        JTextField field7 = new JTextField("oui");
        JTextField field8 = new JTextField("non");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Prix d'achat :"));
        panel.add(field1);
        panel.add(new JLabel("Prix de vente :"));
        panel.add(field2);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field3);
        panel.add(new JLabel("Sa largeur"));
        panel.add(field4);
        panel.add(new JLabel("Son nom :"));
        panel.add(field5);
        panel.add(new JLabel("nombres de cordes"));
        panel.add(field6);
        panel.add(new JLabel("Présence d'un amplificateur?"));
        panel.add(field7);
        panel.add(new JLabel("Présence des pédales d'effets sonores?"));
        panel.add(field8);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
           /* return new Guitarre_Elecrtique(Integer.parseInt(field1.getText()));*/
            return null;

        }
        else{
            return null;
        }

    }


    public Piano_a_queue displayPiano_a_queueBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("10");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("70");
        JTextField field4 = new JTextField("40");
        JTextField field5 = new JTextField("YAMAHA GB1");
        JTextField field6 = new JTextField("1/2");
        JTextField field7 = new JTextField("88");


        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Prix d'achat :"));
        panel.add(field1);
        panel.add(new JLabel("Prix de vente :"));
        panel.add(field2);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field3);
        panel.add(new JLabel("Sa largeur"));
        panel.add(field4);
        panel.add(new JLabel("Son nom :"));
        panel.add(field5);
        panel.add(new JLabel("Sa taille"));
        panel.add(field6);
        panel.add(new JLabel("Nombre de touches :"));
        panel.add(field7);



        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            /* return new Piano_a_queue(Integer.parseInt(field1.getText()));*/
            return null;

        }
        else{
            return null;
        }

    }

    public PianoDroit displayPianoDroitBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("10");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("70");
        JTextField field4 = new JTextField("40");
        JTextField field5 = new JTextField("YAMAHA U1");
        JTextField field6 = new JTextField("oui");
        JTextField field7 = new JTextField("88");
        JTextField field8 = new JTextField("non");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Prix d'achat :"));
        panel.add(field1);
        panel.add(new JLabel("Prix de vente :"));
        panel.add(field2);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field3);
        panel.add(new JLabel("Sa largeur"));
        panel.add(field4);
        panel.add(new JLabel("Son nom :"));
        panel.add(field5);
        panel.add(new JLabel("Des cordes droites ?"));
        panel.add(field6);
        panel.add(new JLabel("Nombre de touches :"));
        panel.add(field7);
        panel.add(new JLabel("Doté d'un silencieux"));
        panel.add(field8);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            /* return new PianoDroit(Integer.parseInt(field1.getText()));*/
            return null;

        }
        else{
            return null;
        }

    }



    public PianoNumérique displayPianoNumériqueBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("10");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("70");
        JTextField field4 = new JTextField("40");
        JTextField field5 = new JTextField("Kawai");
        JTextField field6 = new JTextField("88");
        JTextField field7 = new JTextField("non");
        JTextField field8 = new JTextField("2");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Prix d'achat :"));
        panel.add(field1);
        panel.add(new JLabel("Prix de vente :"));
        panel.add(field2);
        panel.add(new JLabel("Sa longueur"));
        panel.add(field3);
        panel.add(new JLabel("Sa largeur"));
        panel.add(field4);
        panel.add(new JLabel("Son nom :"));
        panel.add(field5);
        panel.add(new JLabel("Nombre de touches :"));
        panel.add(field6);
        panel.add(new JLabel("Toucher lourd ?"));
        panel.add(field7);
        panel.add(new JLabel("Qualité d'échantillonage"));
        panel.add(field8);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            /* return new PianoNumérique(Integer.parseInt(field1.getText()));*/
            return null;

        }
        else{
            return null;
        }

    }

    public Clarinette displayClarinetteBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("cor de basset");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("30");
        JTextField field4 = new JTextField("25");
        JTextField field5 = new JTextField("Clarinette en ut");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
        panel.add(new JLabel("Son nom:"));
        panel.add(field1);
        panel.add(new JLabel("Prix d'achat' :"));
        panel.add(field2);
        panel.add(new JLabel("Prix de vente"));
        panel.add(field3);
        panel.add(new JLabel("Sa taille"));
        panel.add(field4);
        panel.add(new JLabel("Son type :"));
        panel.add(field5);


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            /* return new Clarinette(Integer.parseInt(field1.getText()));*/
            return null;

        }
        else{
            return null;
        }

    }

    public FluteTraversière displayFluteTraversièreBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("Traverso");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("30");
        JTextField field4 = new JTextField("Picollo");
        JTextField field5 = new JTextField("26");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
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


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            /* return new FluteTraversière(Integer.parseInt(field1.getText()));*/
            return null;

        }
        else{
            return null;
        }

    }


    public Hautbois displayHautboisBuild(List<Personne> pers) {
        updatePers(pers);
        JComboBox<String> combo = new JComboBox<>(personnes);
        JTextField field1 = new JTextField("cor de basset");
        JTextField field2 = new JTextField("20");
        JTextField field3 = new JTextField("30");
        JTextField field4 = new JTextField("le bois de rose");
        JTextField field5 = new JTextField("hautbois baroque");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Propriétaire :"));
        panel.add(combo);
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


        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un Guitare Acoustique",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            /* return new Hautbois(Integer.parseInt(field1.getText()));*/
            return null;

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
