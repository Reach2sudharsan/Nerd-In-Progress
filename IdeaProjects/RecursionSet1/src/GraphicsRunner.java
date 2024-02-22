import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;


public class GraphicsRunner extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public GraphicsRunner()
    {
        super("Graphics Runner");
        setSize(WIDTH,HEIGHT);

        getContentPane().add(new RecursiveBoxes());

        setVisible(true);
    }

    public static void main( String args[] )
    {
        GraphicsRunner run = new GraphicsRunner();
    }
}


class RecursiveBoxes extends JPanel
{
    public RecursiveBoxes()
    {
        setSize(640,480);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public void paintComponent( Graphics window )
    {
        super.paintComponent(window);
        window.setColor(Color.BLACK);
        window.drawString("Drawing Boxes Using Recursion ",20,80);
        drawBoxes(window,10,10);
    }

    public void drawBoxes(Graphics window, int x, int y)
    {
        if( x < 100 && y < 100)
        {
            window.setColor( Color.blue );
            window.drawRect( 90+x, 90+y, 20+x, 20+x );
            for(int i = 0; i < 20000000; i++) { } //pauses the program a tad
            drawBoxes(window, x+10, y+10);
        }
    }
}