/*
The program below is a blackjack program that prints the
suits and faces based on card details given.
 */
import static java.lang.System.*;

/*
The class below is the runner class.
 */
public class CardRunner
{
    public static void main( String args[] )
    {
		Card one = new Card("SPADES", 9);
		out.println(one.getSuit());
		out.println(one.getFace());

		Card two = new Card("DIAMONDS", 1);
		out.println(two);
		two.setFace(3);
		out.println(two);

		Card three = new Card("CLUBS", 4);
		out.println(three);

		Card four = new BlackJackCard("SPADES", 1);
		out.println(four);

		Card five = new BlackJackCard("HEARTS", 13);
		out.println(five);

		Card six = new BlackJackCard("HEARTS", 11);
		out.println(six);

		Card seven = new BlackJackCard("CLUBS", 12);
		out.println(seven);

    }
}

/*
The class below has the methods required for the program to work.
 */
class Card
{
    public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
            "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

    //instance variables
    private String suit;
    private int face;

    //constructors

    public Card ()
    {
        this.suit = "";
        this.face = 0;
    }

    public Card( String s, int f)
    {
        suit = s;
        face = f;
    }

    // modifiers
    public void setFace( int f)
    {
        face = f;
    }

    public void setSuit( String s)
    {
        suit = s;
    }

    //accessors
    public String getSuit()
    {
        return suit;
    }

    public int getFace()
    {
        return face;
    }

    //toString
    public String toString()
    {
        return FACES[face] + " of " + suit;
    }
}

/*
The class below is a child class of the Card class.
 */
class BlackJackCard extends Card
{
    private String suit;
    private int value;

    public BlackJackCard(String suit, int face)
    {
        this.suit = suit;
        this.value = face;
    }

    public int getValue()
    {
        if (Card.FACES[value].equals("ACE"))
        {
            value = 11;
        }

        else if (Card.FACES[value].equals("JACK"))
        {
            value = 10;
        }

        else if (Card.FACES[value].equals("QUEEN"))
        {
            value = 10;
        }

        else if (Card.FACES[value].equals("KING"))
        {
            value = 10;
        }
        return value;
    }

    public String getSuit()
    {
        return suit;
    }

    public String toString() {
        return Card.FACES[value] + " of " + getSuit() + " \n" + getValue() ;
    }
}
