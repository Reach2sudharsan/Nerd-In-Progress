import java.util.ArrayList;

public class IntQueueRunner {
    public static void main(String[] args) {
        IntQueue run = new IntQueue();
        run.add(5);
        run.add(7);
        run.add(9);
        System.out.println(run);
        System.out.println(run.isEmpty());
        System.out.println(run.remove());
        System.out.println(run.peek());
        System.out.println(run.remove());
        System.out.println(run.remove());
        System.out.println(run.isEmpty());
        System.out.println(run);
    }
}

class IntQueue
{
    private ArrayList<Integer> listOfInts;

    public IntQueue(){
        listOfInts = new ArrayList<>();
    }

    public void add(int item){
        listOfInts.add(item);
    }

    public int remove(){
        return listOfInts.remove(0);
    }

    public boolean isEmpty(){
        return listOfInts.isEmpty();
    }

    public int peek(){
        return listOfInts.get(0);
    }

    public String toString(){
        return listOfInts + "";
    }
}

