package Vue;

import Modèle.Batiment;
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
    public Personne displayLocBuild(String[] personnes,List<Batiment> batiments) {
        if(batiments.size()>0) {
            String[] choices=new String[batiments.size()];
            for(int i=0;i<batiments.size();i++){
                choices[i]=""+batiments.get(i).getType()+" au: "+batiments.get(i).getAdresse();
            }
            JComboBox<String> combo = new JComboBox<>(choices);
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Disponibilités :"));
            panel.add(combo);
            int result = JOptionPane.showConfirmDialog(null, panel, "Choix de l'hébergement",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                return null;
            }
            else{
                return null;
            }
        }else{
            System.out.println("Annulation : pas d'hebergement disponibles");
            return null;
        }
    }
}
