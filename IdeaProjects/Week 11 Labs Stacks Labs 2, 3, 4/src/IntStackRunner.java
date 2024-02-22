import java.util.ArrayList;

public class IntStackRunner {
    public static void main(String[] args) {
        IntStack run = new IntStack();
        System.out.println(run);

        run.push(1);
        run.push(2);
        run.push(3);
        System.out.println(run);

        run.pop();
        System.out.println(run);

        System.out.println(run.isEmpty());

        System.out.println(run.peek());
    }
}

class IntStack
{
    private ArrayList<Integer> listOfInts;

    public IntStack(){
        listOfInts = new ArrayList<>();
    }

    public void push(int item){
        listOfInts.add(item);
    }

    public int pop(){
        if (listOfInts.size() >= 1) {
            return listOfInts.remove(listOfInts.size()-1);
        }
        return 0;
    }

    public boolean isEmpty(){
        if (listOfInts.size() >= 1) {
            return false;
        }
        return true;
    }

    public int peek(){
        if (listOfInts.size() >= 1) {
            return listOfInts.get(listOfInts.size()-1);
        }
        return 0;
    }

    public String toString(){
        return "" + listOfInts;
    }
}

