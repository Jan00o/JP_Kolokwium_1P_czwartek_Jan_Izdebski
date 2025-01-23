package kolokwium;

import javax.swing.*;

public class MyFrame extends JFrame {
    DrawPanel drawPanel = new DrawPanel();
    MyFrame(){
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(drawPanel);

        this.setVisible(true);


    }
}
