package Vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pan extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(650,0,650,600);
        g.drawLine(650,250,950,250);
        g.drawLine(650,350,950,350);
    }
}
