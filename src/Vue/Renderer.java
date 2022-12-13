package Vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer extends JFrame{
    private JButton bcbat;
    private JButton bcpers;
    private JButton bpbat;
    private JButton bppers;
    private JButton bpinstru;
    private TabPane tp;
    private JScrollPane scrollFrame;
    private Pan pan;
    public Renderer(){
        pan=new Pan();
        this.setResizable(false);
        this.setSize(900,600);
        this.setVisible(true);
        this.setTitle("City Manager");
        this.add(pan);
        pan.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bcbat=new JButton("Créer un batiment");
        bcbat.setBounds(675,50,200,30);
        pan.add(bcbat);
        bcpers=new JButton("Ajouter une personne");
        bcpers.setBounds(675,100,200,30);
        pan.add(bcpers);
        bpbat=new JButton("Afficher les batiments");
        bpbat.setBounds(5,0,200,30);
        pan.add(bpbat);
        bppers=new JButton("Afficher les Personnes");
        bppers.setBounds(225,0,200,30);
        pan.add(bppers);
        bpinstru=new JButton("Afficher les Instruments");
        bpinstru.setBounds(445,0,200,30);
        pan.add(bpinstru);
        JLabel lab=new JLabel("Créer:");
        lab.setBounds(700,10,200,30);
        pan.add(lab);
        lab=new JLabel("Modifier:");
        lab.setBounds(700,175,200,30);
        pan.add(lab);
        lab=new JLabel("Filtrer:");
        lab.setBounds(700,375,200,30);
        pan.add(lab);
        tp = new TabPane();
        tp.setPreferredSize(new Dimension( 650,565));
        scrollFrame = new JScrollPane(tp);
        tp.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension( 800,300));
        scrollFrame.setBounds(0,36,650,565);
        scrollFrame.getVerticalScrollBar().setUnitIncrement(15);
        scrollFrame.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pan.add(scrollFrame);

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

    public JButton getBpbat() {
        return bpbat;
    }

    public JButton getBpinstru() {
        return bpinstru;
    }

    public JButton getBppers() {
        return bppers;
    }
}
