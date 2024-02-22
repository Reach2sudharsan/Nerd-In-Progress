import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
The class right below creates an invisible ball that will randomly turn invisible for random durations of time.
 */
public class InvisibleBall extends Ball
{

    //constructors
    public InvisibleBall()
    {
        super();
    }

    public InvisibleBall(int x, int y)
    {
        super(x,y);
    }

    public InvisibleBall(int x, int y, int wid, int ht)
    {
        super(x,y, wid, ht);
    }

    public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
    {
        super(x,y, wid, ht, xSpd, ySpd);
    }

    public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
    {
        super(x,y, wid, ht, col, xSpd, ySpd);
    }

    public Color invisible()
    {
        int randomNum = (int)(Math.random() *10);
        if (randomNum < 5) {
            return Color.WHITE;
        }
        return getColor();
    }

    public void moveAndDraw(Graphics window)
    {
        setColor(invisible());
        super.moveAndDraw(window);
    }
}

