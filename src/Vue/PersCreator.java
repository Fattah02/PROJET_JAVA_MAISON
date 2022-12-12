package Vue;

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
        int res = JOptionPane.showConfirmDialog(null, panel, "Ajout de Modèle.Personne",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            Personne result=new Personne(field1.getText(),field2.getText());
            return result;
        } else {
            System.out.println("Annulation");
            return null;
        }
    }
}
