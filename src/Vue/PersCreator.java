package Vue;

import Modèle.Batiment;
import Modèle.Batiments.Hotel;
import Modèle.Batiments.Immeuble;
import Modèle.Batiments.Magasin;
import Modèle.Personne;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PersCreator {
    public Personne displayPersBuild() {
        JTextField field1 = new JTextField("Doe");
        JTextField field2 = new JTextField("John");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nom :"));
        panel.add(field1);
        panel.add(new JLabel("Prenom :"));
        panel.add(field2);
        int res = JOptionPane.showConfirmDialog(null, panel, "Ajout de Personne",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            Personne result=new Personne(field1.getText(),field2.getText());
            return result;
        } else {
            System.out.println("Annulation");
            return null;
        }
    }
    public void displayLocBuild(List<Personne> persons,String[] personnes,List<Batiment> batiments,int type) {
        if(batiments.size()>0) {
            String[] choices=new String[batiments.size()];
            for(int i=0;i<batiments.size();i++){
                choices[i]=""+batiments.get(i).getType()+" au: "+batiments.get(i).getAdresse();
            }
            JComboBox<String> combo = new JComboBox<>(choices);
            JComboBox<String> combopers = new JComboBox<>(personnes);
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Institutions :"));
            panel.add(combo);
            panel.add(combopers);
            int result = JOptionPane.showConfirmDialog(null, panel, "Choix de l'hébergement",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String[] rooms;
                JComboBox<String> combo2 ;
                if(type==0) {
                    Hotel h=(Hotel) batiments.get(combo.getSelectedIndex());
                    rooms = new String[h.getNbfreerooms()];
                    combo2=new JComboBox<>(getfreerooms(h));
                    System.out.println("Batiment choisit :\n"+h.toString());
                }
                else if(type==1) {
                    Hotel h=(Hotel) batiments.get(combo.getSelectedIndex());
                    rooms = new String[h.getNbfreesuits()];
                    combo2=new JComboBox<>(getfreerooms(h));
                    System.out.println("Batiment choisit :\n"+h.toString());
                }
                else {
                    Immeuble im=(Immeuble) batiments.get(combo.getSelectedIndex());
                    rooms=new String[im.getNbfreerooms()];
                    combo2=new JComboBox<>(getfreeappart(im));
                    System.out.println("Batiment choisit :\n"+im.toString());
                }

                JPanel panel2 = new JPanel(new GridLayout(0, 1));
                panel2.add(new JLabel("Disponibilités :"));
                panel2.add(combo2);
                int result2 = JOptionPane.showConfirmDialog(null, panel2, "Choix de l'hébergement",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result2 == JOptionPane.OK_OPTION) {
                    if(type==1 || type==0){
                        Hotel hot=(Hotel) batiments.get(combo.getSelectedIndex());
                        hot.setLocataire(persons.get(combopers.getSelectedIndex()),combo2.getSelectedIndex());
                        System.out.println("Nouveau locataire au numero:"+combo2+"\n");
                    }
                    else {
                        Immeuble i=(Immeuble)  batiments.get(combo.getSelectedIndex());
                        i.setLocataire(persons.get(combopers.getSelectedIndex()),combo2.getSelectedIndex());
                        System.out.println("Nouveau locataire créé\n-------------------------------------------------");
                    }
                    return;
                }else{
                    System.out.println("Annulation");
                    return;
                }

            }
            else{
                System.out.println("Annulation");
                return;
            }
        }else{
            System.out.println("Annulation : pas d'hebergement disponibles");
            return;
        }
    }

    private String[] getfreerooms(Hotel h){
        String[] result=new String[h.getNbChambre()];
        int compteur=0;
        for(int i=0;i<h.getNbChambre();i++){
            if(h.isdisponible(i)){
                result[compteur]="Chambre "+i;
                compteur+=1;
            }
        }
        return result;
    }
    private String[] getfreesuits(Hotel h){
        String[] result=new String[h.getNbChambre()];
        int compteur=0;
        for(int i=h.getNbChambre();i<(h.getNbChambre()+h.getNbSuites());i++){
            if(h.isdisponible(i)){
                result[compteur]="Suite "+i;
                compteur+=1;
            }
        }
        return result;
    }
    private String[] getfreeappart(Immeuble h){
        String[] result=new String[h.getNbAppart()];
        int compteur=0;
        for(int i=0;i<h.getNbAppart();i++){
            if(h.isdisponible(i)){
                result[compteur]="Appartement "+i;
                compteur+=1;
            }
        }
        return result;
    }
}
