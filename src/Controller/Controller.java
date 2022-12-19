package Controller;

import Modèle.Batiment;
import Modèle.Instrument;
import Modèle.Personne;
import Vue.BatCreator;
import Vue.PersCreator;
import Vue.Renderer;
import Vue.instru_creator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {
    private List<Personne> personnes;
    private List<Batiment> batiments;
    private List<Instrument>instruments;
    private List<JButton> buttons;
    private Vue.Renderer ren;
    private BatCreator bCreator;
    private instru_creator instru_creator;
    private PersCreator pCreator;

    private int menuNumber=1;
    public Controller(List<Batiment> bat, Renderer rend){
        batiments=bat;
        ren=rend;
        buttons=new ArrayList<JButton>();
        personnes=new ArrayList<Personne>();
        buttons.add(rend.getBcpers());
        buttons.add(rend.getBcbat());
        buttons.add(rend.getBpbat());
        buttons.add(rend.getBppers());
        buttons.add(rend.getBpinstru());
        buttons.add(rend.getBcinstr());

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
            String[] optionsToChoose = {"Maison", "Hotel", "Magasin", "Immeuble"};
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
        if(e.getSource()==buttons.get(2)){
            menuNumber=0;
            System.out.println("Affichage des Batiments");
            repaintmenu();
        }
        if(e.getSource()==buttons.get(3)){
            menuNumber=1;
            System.out.println("Affichage des personnes");
            repaintmenu();
        }
        if(e.getSource()==buttons.get(4)){
            menuNumber=2;
            System.out.println("Affichage des Instruments");
            repaintmenu();
        }
        if(e.getSource()==buttons.get(5)){
            System.out.println("Creation d'un batiment");
            String[] optionsToChoose = {"Guitarre_acoustique","Guitarre_Electrique","Piano_a_queue","PianoDroit","PianoNumérique","Clarinette","Flutetraversière","Hautbois"};
            String chooseninstru = (String) JOptionPane.showInputDialog(
                    null,
                    "Différentes instruments",
                    "Choisir un instrument",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    optionsToChoose[0]);
            newinst(chooseninstru);


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
                batiments.add(bCreator.displayMagasinBuild(personnes));
                System.out.println("Nouveau batiment : \n"+batiments.get(batiments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (choosenbat.equals("Immeuble")) {
                batiments.add(bCreator.displayImmeubleBuild(personnes));
                System.out.println("Nouveau batiment : \n"+batiments.get(batiments.size()-1).toString()+"\n-------------------------------------------------");
            }
            repaintmenu();
        }catch(NullPointerException error){
            System.out.println("Anunulation");
        }
    }
    private void newinst(String chooseninstru){
        try {
            System.out.println("Instrument choisi: " + chooseninstru+"\n");
            if (chooseninstru.equals("Hautbois")) {
                instruments.add(Vue.instru_creator.displayHautboisBuild());
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Guitarre_acoustique")) {
                instruments.add(Vue.instru_creator.displayGuitarre_acoustiqueBuild());
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("PianoDroit")) {
                instruments.add(Vue.instru_creator.displayPianoDroitBuild());
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Guitarre_Electrique")) {
                instruments.add(Vue.instru_creator. displayGuitarre_ElecBuild() );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Piano_a_queue")) {
                instruments.add(Vue.instru_creator. displayPiano_a_queueBuild() );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("PianoNumérique")) {
                instruments.add(Vue.instru_creator.  displayPianoNumériqueBuild() );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Clarinette")) {
                instruments.add(Vue.instru_creator. displayClarinetteBuild() );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Flutetraversière")) {
                instruments.add(Vue.instru_creator.displayFluteTraversièreBuild() );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }


            repaintmenu();
        }catch(NullPointerException error){
            System.out.println("Anunulation");
        }

    }

    private void repaintmenu(){
        if(menuNumber==0){
            List<String> col=new ArrayList<String>();
            List<String> data;
            List<List<String>> lines=new ArrayList<List<String>>();
            col.add("Type");
            col.add("Propriétaire");
            col.add("Adresse");
            col.add("Surface");
            for(int i=0;i<batiments.size();i++){
                data=new ArrayList<String>();
                data.add(batiments.get(i).getType());
                data.add(""+batiments.get(i).getProprietaire());
                data.add(batiments.get(i).getAdresse());
                data.add(""+batiments.get(i).getSurfaceH());
                lines.add(data);
            }
            ren.Printtab(col,lines);
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
