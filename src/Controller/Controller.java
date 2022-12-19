package Controller;

import Modèle.Batiment;
import Modèle.Batiments.Hotel;
import Modèle.Batiments.Hotel_CinqE;
import Modèle.Batiments.Immeuble;
import Modèle.Instrument;
import Modèle.Personne;
import Vue.BatCreator;
import Vue.PersCreator;
import Vue.Renderer;
import Vue.instru_creator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {
    private List<Personne> personnes;
    private String[] pers;
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
        instruments=new ArrayList<Instrument>();
        buttons.add(rend.getBcpers());
        buttons.add(rend.getBcbat());
        buttons.add(rend.getBcinstr());
        buttons.add(rend.getBLoc());


        buttons.add(rend.getBInfo());
        buttons.add(rend.getBfilter());


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
            System.out.println("Creation d'un Instrument");
            String[] optionsToChoose = {"Guitarre acoustique","Guitarre Electrique","Piano à queue","Piano Droit","Piano Numérique","Clarinette","Flute traversière","Hautbois"};
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
        if(e.getSource()==buttons.get(3) && personnes.size()>0){
            System.out.println("Ajout d'un locataire");
            String[] optionsToChoose = new String[]{"Chambre d'hotel","Suite d'hotel","Appartement"};
            String choosenloc = (String) JOptionPane.showInputDialog(
                    null,
                    "Types :",
                    "Choisir un type de location",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    optionsToChoose[0]);
            updatePers(personnes);
            if(choosenloc.equals("Chambre d'hotel")){
                pCreator.displayLocBuild(personnes,pers,getdispHotels(),0);
            }else if(choosenloc.equals("Suite d'hotel")){
                pCreator.displayLocBuild(personnes,pers,getdispHotelssuits(),1);
            }else{
                pCreator.displayLocBuild(personnes,pers,getChambres(),2);
            }
            repaintmenu();
        }

        if(e.getSource()==buttons.get(4)){
            if(ren.getComboinfo()==0 && personnes.size()>0){
                System.out.println("Selectioner une personne");
                updatePers(personnes);
                JComboBox<String> combo = new JComboBox<>(pers);
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Personnes :"));
                panel.add(combo);
                int result = JOptionPane.showConfirmDialog(null, panel, "Choix de la personne",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    JPanel panel2 = new JPanel(new GridLayout(0, 1));
                    panel2.add(new JLabel("Nom : "+personnes.get(combo.getSelectedIndex()).getNom()));
                    panel2.add(new JLabel("Prénom : "+personnes.get(combo.getSelectedIndex()).getPrenom()));
                    int res=JOptionPane.showConfirmDialog(null,panel2,"Informations",JOptionPane.OK_CANCEL_OPTION);
                }
            }
            else if(ren.getComboinfo()==1 && batiments.size()>0){
                System.out.println("Selectioner un batiment");
                String[] bat=new String[batiments.size()];
                for(int i=0;i<batiments.size();i++){
                    bat[i]=batiments.get(i).getType()+" au "+batiments.get(i).getAdresse();
                }
                JComboBox<String> combo = new JComboBox<>(bat);
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Batiments :"));
                panel.add(combo);
                int result = JOptionPane.showConfirmDialog(null, panel, "Choix du batiment",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    JPanel panel2 = new JPanel(new GridLayout(0, 1));
                    panel2.add(new JLabel(batiments.get(combo.getSelectedIndex()).toString()));
                    int res=JOptionPane.showConfirmDialog(null,panel2,"Informations",JOptionPane.OK_CANCEL_OPTION);
                }
            }
            else{

            }
        }
        if(e.getSource()==buttons.get(5)){
            System.out.println("Changement de filtre ...");
            menuNumber=ren.getCombofilt();
            repaintmenu();
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
                Batiment b=bCreator.displayHouseBuild(personnes);
                if(!isadressoccupied(b.getAdresse())) {
                    batiments.add(b);
                    System.out.println("Nouveau batiment : \n" + batiments.get(batiments.size() - 1).toString() + "\n-------------------------------------------------");
                }
                else{
                    System.out.println("Adresse deja occupee\nAnnulation\n-------------------------------------------------");
                }
            }
            if (choosenbat.equals("Hotel")) {
                Batiment b=bCreator.displayHotelBuild(personnes);
                if(!isadressoccupied(b.getAdresse())) {
                    batiments.add(b);
                    System.out.println("Nouveau batiment : \n" + batiments.get(batiments.size() - 1).toString() + "\n-------------------------------------------------");
                }
                else{
                    System.out.println("Adresse deja occupee\nAnnulation\n-------------------------------------------------");
                }
            }
            if (choosenbat.equals("Magasin")) {
                Batiment b=bCreator.displayMagasinBuild(personnes);
                if(!isadressoccupied(b.getAdresse())) {
                    batiments.add(b);
                    System.out.println("Nouveau batiment : \n" + batiments.get(batiments.size() - 1).toString() + "\n-------------------------------------------------");
                }
                else{
                    System.out.println("Adresse deja occupee\nAnnulation\n-------------------------------------------------");
                }
            }
            if (choosenbat.equals("Immeuble")) {
                Batiment b=bCreator.displayImmeubleBuild(personnes);
                if(!isadressoccupied(b.getAdresse())) {
                    batiments.add(b);
                    System.out.println("Nouveau batiment : \n" + batiments.get(batiments.size() - 1).toString() + "\n-------------------------------------------------");
                }
                else{
                    System.out.println("Adresse deja occupee\nAnnulation\n-------------------------------------------------");
                }
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
                instruments.add(Vue.instru_creator.displayHautboisBuild(getShops()));
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Guitarre_acoustique")) {
                instruments.add(Vue.instru_creator.displayGuitarre_acoustiqueBuild(getShops()));
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("PianoDroit")) {
                instruments.add(Vue.instru_creator.displayPianoDroitBuild(getShops()));
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Guitarre_Electrique")) {
                instruments.add(Vue.instru_creator. displayGuitarre_ElecBuild(getShops()) );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Piano_a_queue")) {
                instruments.add(Vue.instru_creator. displayPiano_a_queueBuild(getShops()) );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("PianoNumérique")) {
                instruments.add(Vue.instru_creator.  displayPianoNumériqueBuild(getShops()) );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Clarinette")) {
                instruments.add(Vue.instru_creator. displayClarinetteBuild(getShops()) );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }
            if (chooseninstru.equals("Flutetraversière")) {
                instruments.add(Vue.instru_creator.displayFluteTraversièreBuild(getShops()) );
                System.out.println("Nouveau instrument : \n"+instruments.get(instruments.size()-1).toString()+"\n-------------------------------------------------");
            }


            repaintmenu();
        }catch(NullPointerException error){
            System.out.println("Anunulation");
        }

    }

    private void repaintmenu(){
        if(menuNumber==1){
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
        } else if (menuNumber==0) {
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
        }else if(menuNumber==2){
            System.out.println("Selectioner une personne");
            updatePers(personnes);
            JComboBox<String> combo = new JComboBox<>(pers);
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Personnes :"));
            panel.add(combo);
            int result = JOptionPane.showConfirmDialog(null, panel, "Choix de la personne",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                List<String> col=new ArrayList<String>();
                List<String> data;
                List<List<String>> lines=new ArrayList<List<String>>();
                col.add("Type");
                col.add("Propriétaire");
                col.add("Adresse");
                col.add("Surface");
                for(int i=0;i<batiments.size();i++){
                    if(batiments.get(i).getProprietaire().equals(personnes.get(combo.getSelectedIndex()))){
                        data=new ArrayList<String>();
                        data.add(batiments.get(i).getType());
                        data.add(""+batiments.get(i).getProprietaire());
                        data.add(batiments.get(i).getAdresse());
                        data.add(""+batiments.get(i).getSurfaceH());
                        lines.add(data);
                    }
                }
                ren.Printtab(col,lines);
            }
        }
        else if(menuNumber==3){
            List<String> col=new ArrayList<String>();
            List<String> data;
            List<List<String>> lines=new ArrayList<List<String>>();
            col.add("Numérot");
            col.add("Adresse");
            List<Batiment> imm=getChambres();
            for(int i=0;i<imm.size();i++){
               String[] rooms= getoccupiedappart((Immeuble) imm.get(i));
               for(int y=0;y<rooms.length;y++){
                   if(rooms[y]!=null) {
                       data = new ArrayList<String>();
                       data.add(rooms[y]);
                       data.add(imm.get(i).getAdresse());
                       lines.add(data);
                   }
               }
            }
            ren.Printtab(col,lines);
        }
        else if(menuNumber==4){
            System.out.println("Selectioner un hotel");
            List<Batiment> hl=getHotels();
            String[] h=new String[hl.size()];
            for(int i=0;i<hl.size();i++){
                h[i]=hl.get(i).getType()+" au: "+hl.get(i).getAdresse();
            }
            JComboBox<String> combo = new JComboBox<>(h);
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Hotels :"));
            panel.add(combo);
            int result = JOptionPane.showConfirmDialog(null, panel, "Choix de l'hotel",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                List<String> col = new ArrayList<String>();
                List<String> data;
                List<List<String>> lines = new ArrayList<List<String>>();
                col.add("Numerot");
                col.add("type de chambre");
                Hotel hot=(Hotel) hl.get(combo.getSelectedIndex());
                for (int i = 0; i < (hot.getNbChambre()+hot.getNbSuites()); i++) {
                    if (hot.isdisponible(i)) {
                        data = new ArrayList<String>();
                        data.add(""+i);
                        if(i<hot.getNbChambre()){
                            data.add("Chambre");
                        }else{
                            data.add("Suite");
                        }
                        lines.add(data);
                    }
                }

                ren.Printtab(col, lines);
            }
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
    private boolean isadressoccupied(String addr){
        System.out.println("Verification adresse : "+addr);
        for(int i=0;i<batiments.size();i++){
            if(batiments.get(i).getAdresse().trim().equals(addr.trim())){
                return true;
            }
        }
        return false;
    }
    public void updatePers(List<Personne> persons){
        int compt=0;
        pers=new String[persons.size()];
        for (Personne p:persons) {
            pers[compt]=p.toString();
            compt++;
        }
    }
    public List<Batiment> getdispHotels(){
        List<Batiment> hotels=new ArrayList<>();
        for(int i=0;i<batiments.size();i++){
            if(batiments.get(i).getType().equals("Hotel(*****)") || batiments.get(i).getType().equals("Hotel(****)") || batiments.get(i).getType().equals("Hotel(*-***)")){
                Hotel h=(Hotel)batiments.get(i);
                if(h.hasaroom()){
                hotels.add(batiments.get(i));}
            }
        }
        return hotels;
    }
    public List<Batiment> getdispHotelssuits(){
        List<Batiment> hotels=new ArrayList<>();
        for(int i=0;i<batiments.size();i++){
            if(batiments.get(i).getType().equals("Hotel(*****)")){
                Hotel_CinqE h=(Hotel_CinqE)batiments.get(i);
                if(h.hasasuit()){
                    hotels.add(batiments.get(i));}
            }
        }
        return hotels;
    }
    public List<Batiment> getChambres(){
        List<Batiment> imm=new ArrayList<>();
        for(int i=0;i<batiments.size();i++){
            if(batiments.get(i).getType().equals("Immeuble")){
                Immeuble im=(Immeuble) batiments.get(i);
                if(im.hasaroom()){
                    imm.add(batiments.get(i));
                }
            }
        }
        return imm;
    }

    private String[] getoccupiedappart(Immeuble h){
        String[] result=new String[h.getNbAppart()];
        int compteur=0;
        for(int i=0;i<h.getNbAppart();i++){
            if(!h.isdisponible(i)){
                result[compteur]=""+i;
                compteur+=1;
            }
        }
        return result;
    }

    public List<Batiment> getHotels(){
        List<Batiment> hotels=new ArrayList<>();
        for(int i=0;i<batiments.size();i++){
            if(batiments.get(i).getType().equals("Hotel(*****)") || batiments.get(i).getType().equals("Hotel(****)") || batiments.get(i).getType().equals("Hotel(*-***)")){
                hotels.add(batiments.get(i));
            }
        }
        return hotels;
    }

    public List<Batiment> getShops(){
        List<Batiment> hotels=new ArrayList<>();
        for(int i=0;i<batiments.size();i++){
            if(batiments.get(i).getType().equals("Magasin")){
                hotels.add(batiments.get(i));
            }
        }
        return hotels;
    }
}
