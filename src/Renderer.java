import javax.swing.*;

public class Renderer {
    private JFrame frame;
    private JButton bcHouse;
    Renderer(){
        frame=new JFrame();
        frame.setSize(900,500);
        frame.setVisible(true);
        frame.setLayout(null);
        JLabel lab=new JLabel("Créer des batiments:");
        lab.setBounds(700,10,200,30);
        bcHouse=new JButton("Maison");
        bcHouse.setBounds(700,50,150,30);
        frame.add(bcHouse);
        frame.add(lab);

    }
}
