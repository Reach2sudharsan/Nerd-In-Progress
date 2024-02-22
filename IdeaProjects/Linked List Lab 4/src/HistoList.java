import java.util.*;
import static java.lang.System.*;

public class HistoList
{
    private HistoNode front;

    public HistoList( )
    {
        front = null;
    }

    //addLetter will add a new node to the front for let if let does not exist
    //addLetter will bump up the count if let already exists
    public void addLetter(char let)
    {
        HistoNode temp = this.front;
        int count = 0;

        while (temp != null) {
            if (temp.getLetter() == let) {
                temp.setLetterCount(temp.getLetterCount()+1);
                count = count+1;
            }
            temp = temp.getNext();
        }

        if (count == 0){
            HistoNode newNode = new HistoNode(let, count+1, this.front);
            this.front = newNode;
        }
    }

    //returns the index pos of let in the list if let exists
    public int indexOf(char let)
    {
        HistoNode temp = this.front;
        int count = 0;
        while (temp != null) {
            if (temp.getLetter() == let) {
                return count;
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }

    //returns a reference to the node at spot
    private HistoNode nodeAt(int spot)
    {
        HistoNode current=this.front;
        int i = 0;
        while (i < spot) {
            current = current.getNext();
            i++;
        }
        return current;
    }

    //returns a string will all values from list
    public String toString()
    {
        String output = "";
        HistoNode temp = this.front;
        while (temp != null) {
            output += temp.getLetter() + "-" + temp.getLetterCount() + " ";
            temp = temp.getNext();
        }
        return output;
    }
}