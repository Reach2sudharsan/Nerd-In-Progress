/*
The program below outputs multiplication tables for the given numbers below.
 */

/*
The class below is the runner class.
 */
public class MultTableRunner {
    public static void main(String[] args) {
        MultTable run1 = new MultTable(5, 5);
        run1.printTable();
        System.out.println();
        System.out.println();

        MultTable run2 = new MultTable(3, 7);
        run2.printTable();
        System.out.println();
        System.out.println();

        MultTable run3 = new MultTable(1, 6);
        run3.printTable();
        System.out.println();
        System.out.println();

        MultTable run4 = new MultTable(9, 9);
        run4.printTable();
        System.out.println();
        System.out.println();

        MultTable run5 = new MultTable(7, 8);
        run5.printTable();
    }
}

/*
The class below has the method required for this program to work.
 */
class MultTable {
    private int number;
    private int stop;

    public MultTable(int n, int s) {
        number = n;
        stop = s;
    }

    public void printTable() {
        System.out.println("multiplication table for " + number);
        for (int i = 1; i <= stop; i++) {
            System.out.println(i + "\t  " + number*i);
        }
    }
}
