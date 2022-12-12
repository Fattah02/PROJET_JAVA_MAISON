package Controller;

import Modèle.Batiment;
import Modèle.Personne;
import Vue.BatCreator;
import Vue.PersCreator;
import Vue.Renderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {
    private List<Personne> personnes;
    private List<Batiment> batiments;
    private List<JButton> buttons;
    private Vue.Renderer ren;
    private BatCreator bCreator;
    private PersCreator pCreator;
    private int menuNumber=1;
    public Controller(List<Batiment> bat, Renderer rend){
        batiments=bat;
        ren=rend;
        buttons=new ArrayList<JButton>();
        personnes=new ArrayList<Personne>();
        buttons.add(rend.getBcpers());
        buttons.add(rend.getBcbat());
        initialiselisteners();
        bCreator=new BatCreator();
        pCreator=new PersCreator();
        repaintmenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttons.get(0)){
            System.out.println("Creation d'une personne");
            Personne per=pCreator.displayPersBuild();
            if(per!=null && !containsperson(per)) {
                personnes.add(per);
                System.out.println("Nouvelle personne :\n" + personnes.get(personnes.size() - 1).toString() + "\n-------------------------------------------------");
                repaintmenu();
            }
            else {System.out.println("Personne deja existante ou annulation");}
        }
        if(e.getSource()==buttons.get(1) && personnes.size()>0){
            System.out.println("Creation d'un batiment");
            String[] optionsToChoose = {"Maison", "Hotel", "Magazin", "Immeuble"};
            String choosenbat = (String) JOptionPane.showInputDialog(
                    null,
                    "Type de batiment",
                    "Choisir un type",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    optionsToChoose[0]);
            newbat(choosenbat);
        }

    }

    private void initialiselisteners(){
        for(int i=0;i<buttons.size();i++){
            buttons.get(i).addActionListener(this);
        }
    }

    private void newbat(String choosenbat){
        try {
            System.out.println("Batiment choisit: " + choosenbat+"\n");
            if (choosenbat.equals("Maison")) {
               batiments.add(bCreator.displayHouseBuild(personnes));
               System.out.println("Nouveau batiment : \n"+batiments.get(batiments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (choosenbat.equals("Hotel")) {
                batiments.add(bCreator.displayHotelBuild(personnes));
                System.out.println("Nouveau batiment : \n"+batiments.get(batiments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (choosenbat.equals("Magasin")) {

            }
            if (choosenbat.equals("Immeuble")) {

            }
            repaintmenu();
        }catch(NullPointerException error){
            System.out.println("Anunulation");
        }
    }

    private void repaintmenu(){
        if(menuNumber==0){

        } else if (menuNumber==1) {
            List<String> col=new ArrayList<String>();
            List<String> data;
            List<List<String>> lines=new ArrayList<List<String>>();
            col.add("Nom");
            col.add("Prénom");
            for(int i=0;i<personnes.size();i++){
                data=new ArrayList<String>();
                data.add(personnes.get(i).getNom());
                data.add(personnes.get(i).getPrenom());
                lines.add(data);
            }
            ren.Printtab(col,lines);
        }else {

        }
    }

    private boolean containsperson(Personne pers){
        for (int i=0;i<personnes.size();i++){
            if(personnes.get(i).equals(pers)){
                //en commentaire pour le dev
                //return true;
            }
        }
        return false;
    }
}
