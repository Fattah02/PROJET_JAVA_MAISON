package Vue;

import Modèle.Batiments.*;
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

    public void updatePers(List<Personne> pers){
        int compt=0;
        personnes=new String[pers.size()];
        for (Personne p:pers) {
            personnes[compt]=p.toString();
            compt++;
        }
    }
}
