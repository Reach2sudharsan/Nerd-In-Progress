import java.util.List;

public class HistoList
{
    private ListNode front;

    public HistoList( )
    {
        this.front = null;
    }


    //ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
    //IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
    public void add(Object obj)
    {
        if (this.front != null && !(obj.getClass() == ((ThingCount)(this.front.getValue())).getThing().getClass())) {
            throw new RuntimeException("both objects are not of the same type");
        }

        ListNode temp = this.front;
        int count = 0;
        ThingCount objc = new ThingCount(obj, count);

        while (temp != null) {
            if (((ThingCount)(temp.getValue())).getThing().equals(obj)) {
                ((ThingCount)(temp.getValue())).setCount(((ThingCount)(temp.getValue())).getCount()+1);
                temp.setValue((temp.getValue()));
                count = count+1;
            }
            temp = temp.getNext();
        }

        if (count == 0){
            objc.setCount(count+1);
            ListNode newNode = new ListNode(objc, this.front);
            this.front = newNode;
        }
    }

    //RETURNS THE INDEX POSITION OF LET IN THE LIST
    public int indexOf(Object obj)
    {
        int spot = 0;
        ListNode temp = this.front;
        while (temp != null) {
            if (((ThingCount)(temp.getValue())).getThing().equals(obj)) {
                return spot;
            }
            spot++;
            temp = temp.getNext();
        }
        return -1;
    }

    //RETURNS A REFERENCE TO THE NODE AT SPOT
    private ListNode nodeAt(int spot)
    {
        ListNode current=front;
        int count = 0;
        while (current != null && count != spot) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    //RETURNS THE LIST AS A BIG STRING
    public String toString()
    {
        String output = "";
        ListNode temp = this.front;
        while (temp != null) {
            output += temp.getValue() + " ";
            temp = temp.getNext();
        }
        return output;
    }
}
