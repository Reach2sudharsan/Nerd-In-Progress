import java.util.List;

import static java.lang.System.*;

public class ListFunHouseTwo
{
    private ListNode theList;

    public ListFunHouseTwo()
    {
        this.theList = new ListNode();
    }

    public void add(Comparable data)
    {
        if (this.theList.getValue() == null) {
            this.theList.setValue(data);
        }
        else {
            this.theList = new ListNode(data, this.theList);
        }
    }

    //this method will return the number of nodes present in list
    public int nodeCount()
    {
        int i=0;
        ListNode temp = this.theList;
        while (temp != null) {
            i++;
            temp = temp.getNext();
        }
        return i;
    }

    //this method will create a new node with the same value as the first node and add this
    //new node at the front of the list.  Once finished, the first node will occur twice.
    public void doubleFirst()
    {
        ListNode newNode = new ListNode(this.theList.getValue(), this.theList);
        this.theList = newNode;
    }

    //this method will create a new node with the same value as the last node and add this
    //new node at the end.  Once finished, the last node will occur twice.
    public void doubleLast()
    {
        ListNode prev = null;
        ListNode temp = this.theList;
        while (temp != null) {
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(new ListNode(prev.getValue(), null));
    }

    //method skipEveryOther will remove every other node
    public void skipEveryOther()
    {
        //ListNode temp = new ListNode(this.theList.getValue(), )
        if (nodeCount() <= 2) {
            ListNode temp = new ListNode(this.theList.getValue(), null);
            this.theList = temp;
        }

        else {
            ListNode temp = this.theList;
            int i = 0;
            while (i < nodeCount()) {
                temp = new ListNode(temp.getValue(), temp.getNext().getNext());
                temp = temp.getNext();
                i += 1;
            }
            this.theList = temp;
        }
    }

    //this method will set the value of every xth node in the list
    public void setXthNode(int x, Comparable value)
    {
        int i = 0;
        ListNode temp = this.theList;
        while (i < x) {
            i++;
            temp = temp.getNext();
        }
        temp.setValue(value);
    }

    //this method will remove every xth node in the list
    public void removeXthNode(int x)
    {
        int count = 1;
        ListNode last=null;
        ListNode temp= theList;
        while(temp != null){
            if(count%x==0) {
                last.setNext(temp.getNext());
            }
            else {
                count++;
            }
            last=temp;
            temp=temp.getNext();
        }
    }

    //this method will return a String containing the entire list
    public String toString()
    {
        String output="";

        ListNode temp = this.theList;
        while (temp != null) {
            output += temp.getValue() + " ";
            temp = temp.getNext();
        }
        return output;
    }
}
