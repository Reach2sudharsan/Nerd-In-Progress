/*
The program right below is supposed to launch a pong game between two users. It uses
a block, a pong ball, and two pong paddles.
 */
import static java.lang.System.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.util.Random;

/*
The class right below is the runner class for the pong window.
 */
public class Tester extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Tester()
    {
        super("PONG TESTER");
        setSize(WIDTH,HEIGHT);

        getContentPane().add(new BlockTestTwo());

        //uncomment when you are ready to test the Ball
        getContentPane().add(new BallTestTwo());

        PaddleTestTwo padTest = new PaddleTestTwo();
        ((Component)padTest).setFocusable(true);
        getContentPane().add(padTest);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        Tester run = new Tester();
    }
}

/*
The class right below is used to create a block.
 */
class Block
{
    private int xPos;  		//x position of the block
    private int yPos;  		//y position of the block
    private int width;		//width of the block
    private int height;		//height of the block

    private Color color;	//color of the block

    public Block(){
        this.xPos = 100;
        this.yPos = 150;
        this.width = 10;
        this.height = 10;
        this.color = new Color(0,0,0);
    }

    //add other Block constructors
    public Block(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = new Color(0,0,0);

    }

    public Block(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = new Color(0,0,0);
    }

    public Block(int xPos, int yPos, int width, int height, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {
        return this.xPos;
    }

    public int getY() {
        return this.yPos;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Color getColor() {
        return this.color;
    }

    public void setX(int xPos) {
        this.xPos = xPos;
    }

    public void setY(int yPos) {
        this.yPos = yPos;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //other modifiers not shown
    public void draw(Graphics window)
    {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col)
    {
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public boolean equals(Object obj)
    {
        Block object = (Block)obj;
        return (this.xPos == object.xPos) &&
                (this.yPos == object.yPos) &&
                (this.width == object.width) &&
                (this.height == object.height);
    }

    //other accessors not shown
    public String toString() {
        return xPos + " " + yPos + " " + width + " " + height + "\n" + color;
    }
}

/*
The class right below tests a created block.
 */
class BlockTestOne
{
    public static void main( String args[] )
    {
        Block one = new Block();
        out.println(one);

        Block two = new Block(50,50,30,30);
        out.println(two);

        Block three = new Block(350,350,15,15,Color.RED);
        out.println(three);

        Block four = new Block(450,50,20,60, Color.GREEN);
        out.println(four);

        out.println(one.equals(two));
        out.println(one.equals(one));
    }
}

/*
The class right below is used to test a created block.
 */
class BlockTestTwo extends Canvas
{
    public BlockTestTwo()
    {
        setBackground(Color.WHITE);
    }

    public void paint(Graphics window)
    {
        Block one = new Block();
        one.draw(window);

        Block two = new Block(50,50,30,30);
        two.draw(window);

        Block three = new Block(350,350,15,15,Color.RED);
        three.draw(window);

        two.draw(window, Color.white);//comment this

        Block four = new Block(450,50,20,60, Color.GREEN);
        four.draw(window);

        //add more test cases
        Block five = new Block(500,60,40,80, Color.BLUE);
        five.draw(window);

        Block six = new Block(400,40,40,80, Color.ORANGE);
        six.draw(window);
    }
}

/*
The class right below is used to create a pong ball.
 */
class Ball extends Block
{
    private int xSpeed;
    private int ySpeed;

    public Ball(){
        super(200,200, 10, 10);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int xPos, int yPos) {
        super(xPos, yPos, 10, 10);
        this.xSpeed = 3;
        this.ySpeed = 1;
    }

    public Ball(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
        this.xSpeed = 3;
        this.ySpeed = 1;
    }

    public Ball(int xPos, int yPos, int width, int height, Color color) {
        super(xPos, yPos, width, height, color);
        this.xSpeed = 3;
        this.ySpeed = 1;
    }

    //add other Ball constructors
    public Ball(int xPos, int yPos, int width, int height, int xSpeed, int ySpeed) {
        super(xPos, yPos, width, height);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public Ball(int xPos, int yPos, int width, int height, Color color, int xSpeed, int ySpeed) {
        super(xPos, yPos, width, height, color);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    //set methods
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void moveAndDraw(Graphics window)
    {
//draw a white ball at
//old ball location
        draw(window, Color.WHITE);

        setX(getX()+xSpeed);
        setY(getY()+ySpeed);
        //setY

        //draw ball at new location
        draw(window, Color.GREEN);
    }

    //equals method
    public boolean equals(Object obj)
    {
        Ball object = (Ball)obj;
        return (super.equals(obj)) &&
                (this.xSpeed == object.xSpeed) &&
                (this.ySpeed == object.ySpeed) ;
    }

    //get methods
    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public String toString(){
        return super.toString() + " " + xSpeed + " " + ySpeed;
    }

}

/*
The class right below is used to test a created pong ball.
 */
class BallTestOne
{
    public static void main( String args[] )
    {
        Ball one = new Ball();
        out.println(one);

        Ball two = new Ball(100,90);
        out.println(two);

        Ball three = new Ball(100,100,30,50);
        out.println(three);

        Ball four = new Ball(100,100,30,50,Color.BLUE);
        out.println(four);

        Ball five = new Ball(100,100,30,50,Color.BLUE,5,6);
        out.println(five);

        //x, y, wid, ht, color, xSpd, ySpd
        Ball six = new Ball(100,100,30,50,Color.blue,5,6);
        out.println(six);

        InvisibleBall invisibleBall = new InvisibleBall(100,100,30,50,Color.WHITE,5,6);
        out.println(invisibleBall);

        out.println(five.equals(four));

        out.println(five.equals(five));
    }
}

/*
The class right below is used to test a created pong ball.
 */
class BallTestTwo extends Canvas implements Runnable
{
    private Ball ball;

    public BallTestTwo()
    {
        setBackground(Color.WHITE);
        setVisible(true);

        //instantiate a new Ball
        this.ball = new Ball(20,20, 30, 30, Color.BLACK);

        //test the Ball thoroughly

        //test all constructors

        new Thread(this).start();
    }

    public void update(Graphics window)
    {
        paint(window);
    }

    public void paint(Graphics window)
    {
        ball.moveAndDraw(window);

        if(!(ball.getX()>=10 && ball.getX()<=550))
        {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if(!(ball.getY()>=10 && ball.getY()<=450))
        {
            ball.setYSpeed(-ball.getYSpeed());
        }
    }

    public void run()
    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(19);
                repaint();
            }
        }catch(Exception e)
        {
        }
    }
}

/*
The class right below is used to create pong paddles.
 */
class Paddle extends Block
{
    private int speed;

    public Paddle()
    {
        super(10,10, 10, 10);
        speed =5;
    }

    //add other Paddle constructors
    public Paddle(int xPos, int yPos) {
        super(xPos, yPos, 10, 10);
        this.speed = 5;
    }
    public Paddle(int xPos, int yPos, int speed) {
        super(xPos, yPos, 10, 10);
        this.speed = speed;
    }

    public Paddle(int xPos, int yPos, int width, int height, int speed) {
        super(xPos, yPos, width, height);
        this.speed = speed;
    }

    public Paddle(int xPos, int yPos, int width, int height, Color color, int speed) {
        super(xPos, yPos, width, height, color);
        this.speed = speed;
    }

    public void setSpeed(int s)
    {
        this.speed = s;
    }

    public void moveUpAndDraw(Graphics window)
    {
        draw(window, Color.WHITE);

        //setX(getX()+getSpeed());
        setY(getY()+getSpeed());

        draw(window, Color.BLACK);
    }

    public void moveDownAndDraw(Graphics window)
    {
        draw(window, Color.WHITE);

        //setX(getX()-getSpeed());
        setY(getY()-getSpeed());

        draw(window, Color.BLACK);
    }

    public int getSpeed()
    {
        return this.speed;
    }

    public String toString() {
        return super.toString() + " " + speed;
    }
}

/*
The class right below is used to test created pong paddles.
 */
class PaddleTestOne
{
    public static void main( String args[] )
    {
        Paddle one = new Paddle();
        out.println(one);

        Paddle two = new Paddle(100,90);
        out.println(two);

        Paddle three = new Paddle(100,100,30);
        out.println(three);

        Paddle four = new Paddle(100,100,30,50,8);
        out.println(four);

        Paddle five = new Paddle(100,100,30,20, Color.GREEN,6);
        out.println(five);

        out.println(five.equals(four));
        out.println(five.equals(five));
    }
}

/*
The class right below is used to test created pong paddles.
 */
class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;		//keeps track of what keys are pressed

    public PaddleTestTwo()
    {
        //set up all game variables

        //instantiate a Ball
        this.ball = new Ball();

        //instantiate a left Paddle
        this.leftPaddle = new Paddle();

        //instantiate a right Paddle
        this.rightPaddle = new Paddle();

        keys = new boolean[5];

        //set up the Canvas
        setBackground(Color.WHITE);
        setVisible(true);

        this.addKeyListener(this);
        new Thread(this).start();
    }

    public void update(Graphics window)
    {
        paint(window);
    }

    public void paint(Graphics window)
    {
        ball.moveAndDraw(window);
        leftPaddle.draw(window);

        if(!(ball.getX()>=10 && ball.getX()<=550))
        {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if(!(ball.getY()>=10 && ball.getY()<=450))
        {
            ball.setYSpeed(-ball.getYSpeed());
        }

        if(keys[0] == true)
        {
            //move left paddle up and draw it on the window
            leftPaddle.moveUpAndDraw(window);
        }
        if(keys[1] == true)
        {
            //move left paddle down and draw it on the window
            leftPaddle.moveDownAndDraw(window);

        }
        if(keys[2] == true)
        {
            rightPaddle.moveUpAndDraw(window);
        }
        if(keys[3] == true)
        {
            rightPaddle.moveDownAndDraw(window);
        }
    }

    public void keyPressed(KeyEvent e)
    {
        switch(toUpperCase(e.getKeyChar()))
        {
            case 'W' : keys[0]=true; break;
            case 'Z' : keys[1]=true; break;
            case 'I' : keys[2]=true; break;
            case 'M' : keys[3]=true; break;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        switch(toUpperCase(e.getKeyChar()))
        {
            case 'W' : keys[0]=false; break;
            case 'Z' : keys[1]=false; break;
            case 'I' : keys[2]=false; break;
            case 'M' : keys[3]=false; break;
        }
    }

    public void keyTyped(KeyEvent e)
    {
        //no code needed here
    }

    public void run()
    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(8);
                repaint();
            }
        }catch(Exception e)
        {
        }
    }
}

/*
The class right below helps set up the actual game.
 */
class Pong extends Canvas implements KeyListener, Runnable {
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;
    private int leftScore;
    private int rightScore;

    public Pong() {
        //set up all variables related to the game
        this.ball = new Ball();
        this.leftPaddle = new Paddle(5, 10, 5, 10, 100);
        this.rightPaddle = new Paddle(720, 10, 5, 10, 100);
        leftPaddle.setColor(new Color(0x803380));
        rightPaddle.setColor(new Color(0xff83ff));
        this.leftScore = 0;
        this.rightScore = 0;

        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);        //starts the key thread to log key strokes
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        //see if ball hits left wall or right wall
        if (!(ball.getX() >= 10 && ball.getX() <= 780)) {
            ball.setXSpeed(0);
            ball.setYSpeed(0);
        }

        //see if the ball hits the top or bottom wall
        if (!(ball.getY() >= 10 && ball.getY() <= 580)) {
            ball.setYSpeed(-ball.getYSpeed());
        }

        //see if the ball hits the left paddle
        if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getXSpeed())
                && (ball.getY() >= leftPaddle.getY() && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()) ||
                (ball.getY() + ball.getHeight() >= leftPaddle.getY()) && ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight()) {
            if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())) {
                ball.setYSpeed(-ball.getYSpeed());
            }
            else {
                ball.setXSpeed(-ball.getXSpeed());
            }
        }

        //see if the ball hits the right paddle
        if (ball.getX() >= rightPaddle.getX() + rightPaddle.getWidth() + Math.abs(ball.getXSpeed()) &&
                (ball.getY() <= rightPaddle.getY() && ball.getY() >= rightPaddle.getY() + rightPaddle.getHeight()) ||
                (ball.getY() + ball.getHeight() <= rightPaddle.getY()) && ball.getY() + ball.getHeight() >
                        rightPaddle.getY() + rightPaddle.getHeight()) {
            if (ball.getX() >= rightPaddle.getX() + rightPaddle.getWidth() - Math.abs(ball.getXSpeed())) {
                ball.setYSpeed(-ball.getYSpeed());
            }
            else {
                ball.setXSpeed(-ball.getXSpeed());
            }
        }

        //see if the paddles need to be moved
        if (leftPaddle.getY() < 0)
            leftPaddle.setY(0);

        if (rightPaddle.getY() < 0)
            rightPaddle.setY(0);

        if (leftPaddle.getY() > 500)
            leftPaddle.setY(500);

        if (rightPaddle.getY() > 500)
            rightPaddle.setY(500);

        twoDGraph.drawImage(back, null, 0, 0);

        twoDGraph.setColor(new Color(0x800080));
        twoDGraph.drawRect(2, 2, 730, 557);
        twoDGraph.drawString("Leftscore: " + Integer.toString(leftScore), 20, 520);
        twoDGraph.drawString("Rightscore: " + Integer.toString(rightScore), 20, 550);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}












