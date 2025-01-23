package kolokwium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel implements MouseListener {

    private int startx, starty;

    final int frameBorderSize=14;

    DrawPanel(){

        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.addMouseListener(this);
        this.setSize(400,400);

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }
    private void startMoving(JLabel rectangle) {
        new Thread(() -> {
            while (true) {
                try {
                    int x = rectangle.getX();
                    int y = rectangle.getY();
                    int width= rectangle.getWidth();

                    if(x<=400-width-frameBorderSize) {
                        rectangle.setLocation(x + 1, y);
                        rectangle.getParent().repaint();
                        Thread.sleep(50);
                    }
                    else{
                        rectangle.setLocation(0,y);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startx = e.getX();
        starty = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endx = e.getX();
        int endy = e.getY();

        int x = Math.min(startx,endx);
        int y = Math.min(starty,endy);
        int width = Math.abs(startx-endx);
        int height = Math.abs(starty-endy);

        JLabel rectangle = new JLabel();
        rectangle.setBackground(Color.red);
        rectangle.setBounds(x,y,width,height);
        rectangle.setOpaque(true);

        this.add(rectangle);
        this.repaint();

        startMoving(rectangle);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
