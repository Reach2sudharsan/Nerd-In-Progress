public class CardTestOne {

}

class Card
{
    public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
            "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

    private String suit;
    private int face;


    //constructors
    public Card() {
        this.suit = " ";
        this.face = 0;
    }
    public Card(String suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    //set methods
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setFace(int face) {
        this.face = face;
    }

    //get methods
    public String getSuit() {
        return suit;
    }

    public int getValue()
    {
        return face;
    }


    //equals method



    public String toString()
    {
        return FACES[face] + " of " + getSuit() + " | value = " + getValue();
    }
}




class BlackJackCard extends Card
{

    //constructors
    public BlackJackCard() {
        super();
    }

    public BlackJackCard(String suit, int face) {
        super(suit, face);
    }

    public int getValue()
    {
        //override the Card getValue to build BlackJack logic
        //enables you to build the value for the game into the card
        //this makes writing the whole program a little easier
        return 0;
    }
}

