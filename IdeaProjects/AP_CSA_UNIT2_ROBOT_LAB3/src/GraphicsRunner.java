/*
The program below is supposed to print a robot using Java graphics.
 */

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class GraphicsRunner extends JFrame {

    private static final int width = 800;
    private static final int height = 600;

    public GraphicsRunner() {
        super("Graphics Runner");
        setSize(width, height);
        getContentPane().add(new Robot());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        GraphicsRunner run = new GraphicsRunner();



    }


}

class Robot extends Canvas {
    public Robot() {
        setSize(800, 600);
        setBackground(Color.GREEN); //white
        setVisible(true);
    }

    public void paint(Graphics window) {
        window.setColor(Color.BLACK);
        window.drawString("Robot LAB ", 35, 35);
        head(window);
        upperBody(window);
        lowerBody(window);
    }

    public void head(Graphics window) {
        window.setColor(Color.YELLOW);
        window.fillOval(300, 100, 200, 100);
    }

    public void upperBody(Graphics window) {
        window.setColor(Color.YELLOW);
        window.fillRect(340,140,120,100);

        window.setColor(Color.BLACK);
        window.fillRect(350, 130, 20, 20);
        window.fillRect(430, 130, 20, 20);
        window.drawArc(350, 160, 100, 20, 0, -180);

        window.setColor(Color.BLUE);
        window.fillRect(190, 200, 150, 20);
        window.fillRect(460, 200, 150, 20);


    }

    public void lowerBody(Graphics window) {
        window.setColor(Color.ORANGE);
        window.fillRect(340, 200,20, 200);
        window.fillRect(440, 200,20, 200);
    }

}

