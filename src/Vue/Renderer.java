package Vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer extends JFrame{
    private JButton bcbat;
    private JButton bcpers;
    private JButton bfilter;
    private JButton binfo;
    private JButton bcinstr;
    private JButton bcloc;
    private TabPane tp;
    private JScrollPane scrollFrame;
    private JComboBox<String> combofilt;
    private JComboBox<String> comboinfo;
    private Pan pan;
    public Renderer(){
        pan=new Pan();
        this.setResizable(false);
        this.setSize(900,600);
        this.setTitle("Residance Manager");
        this.add(pan);
        pan.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        bcbat=new JButton("Créer un batiment");
        bcbat.setBounds(675,50,200,30);
        pan.add(bcbat);
        bcpers=new JButton("Ajouter une personne");
        bcpers.setBounds(675,100,200,30);
        pan.add(bcpers);
        bcinstr = new JButton("Ajouter un instrument");
        bcinstr.setBounds(675,150,200,30);
        pan.add(bcinstr);
        bcloc=new JButton("Ajouter un Locataire");
        bcloc.setBounds(675,200,200,30);
        pan.add(bcloc);

        combofilt=new JComboBox<>(new String[]{"Personnes","Batiments","biens d'une personne","Appartements loués","chambres libres d'un hotel","suites libres d'un hotel"});
        combofilt.setBounds(675,410,200,30);
        pan.add(combofilt);
        bfilter=new JButton("Ok");
        bfilter.setBounds(750,450,50,30);
        pan.add(bfilter);
        comboinfo=new JComboBox<>(new String[]{"Personnes","Batiments","Instruments"});
        comboinfo.setBounds(675,300,150,30);
        pan.add(comboinfo);
        binfo=new JButton("Ok");
        binfo.setBounds(825,300,50,30);
        pan.add(binfo);


        JLabel lab=new JLabel("Créer:");
        lab.setBounds(700,10,200,30);
        pan.add(lab);
        lab=new JLabel("Informations:");
        lab.setBounds(700,250,200,30);
        pan.add(lab);
        lab=new JLabel("Filtrer:");
        lab.setBounds(700,375,200,30);
        pan.add(lab);
        tp = new TabPane();
        tp.setPreferredSize(new Dimension( 650,600));
        scrollFrame = new JScrollPane(tp);
        tp.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension( 800,600));
        scrollFrame.setBounds(0,0,650,600);
        scrollFrame.getVerticalScrollBar().setUnitIncrement(15);
        pan.add(scrollFrame);
        this.setVisible(true);
    }
    public void Printtab(List<String> columns,List<List<String>> Lines){
        tp.refresh(columns,Lines);
        int val=scrollFrame.getVerticalScrollBar().getValue();
        if(Lines.size()>16){
            tp.setPreferredSize(new Dimension(650,535+30*(Lines.size()-16)));
        }else{
            tp.setPreferredSize(new Dimension(650,535));
        }
        scrollFrame.getVerticalScrollBar().setValue(val-1);
        scrollFrame.getVerticalScrollBar().setValue(val+1);
        scrollFrame.getVerticalScrollBar().setValue(val);
        System.out.println("\n-------------------------------------------------");
    }

    public JButton getBcbat() {
        return bcbat;
    }
    public JButton getBcpers() {
        return bcpers;
    }
    public JButton getBcinstr(){
        return bcinstr;
    }

    public JButton getBfilter() {
        return bfilter;
    }

    public JButton getBInfo() {
        return binfo;
    }

    public JButton getBLoc() {
        return bcloc;
    }

    public String getCombofilt() {
        String[] choices=new String[]{"Personnes","Batiments","biens d'une personne","Appartements loués","chambres libres d'un hotel","suites libres d'un hotel"};
        return choices[combofilt.getSelectedIndex()];
    }

    public String getComboinfo() {
        String[] choices=new String[]{"Personnes","Batiments","Instruments"};
        return choices[comboinfo.getSelectedIndex()];
    }
}
