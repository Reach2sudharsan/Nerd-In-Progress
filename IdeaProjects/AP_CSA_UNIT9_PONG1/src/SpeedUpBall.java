import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
The class right below will create a speeding ball that will speed up everytime it collides with a wall or a paddle.
 */
public class SpeedUpBall extends Ball
{
    //instance variables

    public SpeedUpBall()
    {
        super();
    }

    public SpeedUpBall(int x, int y)
    {
        super(x,y);
    }


    public SpeedUpBall(int x, int y, int xSpd, int ySpd)
    {
        super(x,y, xSpd, ySpd);
    }

    public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
    {
        super(x,y, wid, ht, xSpd, ySpd);
    }


    public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
    {
        super(x,y, wid, ht, col, xSpd, ySpd);
    }

    public void setXSpeed( int xSpd )
    {
        super.setXSpeed(xSpd);
    }

    public void setYSpeed( int ySpd )
    {
        super.setYSpeed(ySpd);
    }
}
