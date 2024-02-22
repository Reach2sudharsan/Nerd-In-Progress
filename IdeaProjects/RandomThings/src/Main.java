import java.util.Scanner;

public class Main {
    public String[] keywords = {"print", "intVar", "input"};

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        System.out.print("");
        String enter = obj.nextLine();

        while (!enter.equals("done")) {
            System.out.print("");
            enter = obj.nextLine();
        }
    }
}
