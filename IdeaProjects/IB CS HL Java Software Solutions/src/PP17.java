import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class PP17 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Programming Project 17");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PP17Panel());
        frame.pack();
        frame.setVisible(true);
    }
}

class PP17Panel extends JPanel {
    private Circle light;
    private JButton button;
    private boolean red;
    private boolean yellow;
    private boolean green;
    private Color color;

    public PP17Panel() {
        red = true;
        yellow = false;
        green = false;
        color = Color.RED;
        light = new Circle(40, color, 20, 0);
        setBackground(Color.black);
        button = new JButton("Change Light");
        button.addActionListener(new ButtonListener());
        button.setSize(new Dimension(100,30));
        setPreferredSize(new Dimension(300, 200));
        add(button);
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        light.setColor(Color.YELLOW);
        light.draw(page);
        if (red) {
            light.setColor(Color.RED);
            light.draw(page);
        }

        if (yellow) {
            light.setColor(Color.YELLOW);
            light.draw(page);
        }

        if (green) {
            light.setColor(Color.GREEN);
            light.draw(page);
        }
    }

    private class ButtonListener implements ActionListener
    {

        public void actionPerformed(ActionEvent event)
        {
            if (red) {
                red = false;
                yellow = true;
                color = Color.YELLOW;
                repaint();
            }
            else if (yellow) {
                yellow = false;
                green = true;
                color = Color.YELLOW;
                repaint();
            }
            else if (green) {
                green = false;
                red = true;
                color = Color.RED;
                repaint();
            }
        }
    }
}

