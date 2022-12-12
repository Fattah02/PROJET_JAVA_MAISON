package Vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TabPane extends JPanel {
    private List<List<String>> lines=new ArrayList<>();
    private Scrollbar sc;
    TabPane(){
        //sc=new Scrollbar(HORIZONTAL_SCROLLBAR_ALWAYS,0,1,0,10);
        //this.add(sc);
        this.setLayout(null);
    }

    public void refresh(List<String> columns,List<List<String>> Lines){
        lines=Lines;
        this.repaint();
        JLabel lab;
        String l="";
        JPanel p;
        this.removeAll();
        if(Lines.size()>0) {
            for (int i = 0; i < Lines.size() + 1; i++) {
                l += i + "|";
                p = new JPanel();
                p.setLayout(null);
                p.setBounds(0, 30 * i, this.getWidth(), 30);
                if (i % 2 == 1) {
                    p.setBackground(Color.gray);
                }
                for (int y = 0; y < Lines.get(0).size(); y++) {
                    if (i != 0) {
                        lab = new JLabel(Lines.get(i - 1).get(y));
                        lab.setBounds(10 + y * 100, 0, 100, 30);
                        p.add(lab);
                        l += Lines.get(i - 1).get(y) + "|";
                    } else {
                        lab = new JLabel(columns.get(y));
                        p.setBackground(new Color( 92, 112, 202 ));
                        lab.setBounds(10 + y * 100, 0, 100, 30);
                        p.add(lab);
                        l += columns.get(y) + "|";
                    }
                }
                this.add(p);
                System.out.println(l);
                l = "";
            }
        }
    }

}
