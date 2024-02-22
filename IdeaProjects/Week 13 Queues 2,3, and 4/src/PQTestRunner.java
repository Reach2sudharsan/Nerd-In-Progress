import java.util.*;

public class PQTestRunner {
    public static void main(String[] args) {
        PQTest p1 = new PQTest(new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven")));
        System.out.println(p1);
        System.out.println(p1.getMin());
        p1.getNaturalOrder();

        System.out.println("\n");

        PQTest p2 = new PQTest(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "one", "two", "three", "four", "five")));
        System.out.println(p2);
        System.out.println(p2.getMin());
        p2.getNaturalOrder();

        System.out.println("\n");

        PQTest p3 = new PQTest(new ArrayList<>(Arrays.asList("a", "p", "h", "j", "e", "f", "m", "c", "i", "d", "k", "l", "g", "n", "o", "b")));
        System.out.println(p3);
        System.out.println(p3.getMin());
        p3.getNaturalOrder();
    }
}

class PQTest {
    private Queue<String> queue;

    public PQTest(ArrayList<String> strings) {
        queue = new PriorityQueue<>();
        for (String s: strings) {
            queue.add(s);
        }
    }

    public void getNaturalOrder() {
        ArrayList<String> sortedQue = new ArrayList<>(queue);
        Collections.sort(sortedQue);
        for (String s: sortedQue) {
            System.out.print(s + " ");
        }
    }

    public String getMin() {
        return queue.peek();
    }

    public String toString() {
        return queue + " ";
    }
}
