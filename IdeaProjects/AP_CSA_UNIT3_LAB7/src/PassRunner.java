/*
The program below allows the user to type in the password. It will tell the
user if the inputted password is invalid or valid.
 */
import java.util.Scanner;

/*
The class below is the runner class.
 */
public class PassRunner {
    public static void main(String[] args) {
        PasswordCheck test = new PasswordCheck("mchammergohammer");
        test.check();
    }
}

/*
The class below has all the methods and string inputs the program requires
to check if the user's inputted passwords are invalid or valid.
 */
class PasswordCheck {

    private String password;

    public PasswordCheck(String s) {
        password = s;
    }

    public void check() {
        Scanner obj = new Scanner(System.in);

        System.out.print("Enter the password :: ");
        String input = obj.nextLine();

        if (!(input.equals(password))) {
            do {
                System.out.println("INVALID");
                System.out.print("Enter the password :: ");
                input = obj.nextLine();
            }
            while (!(input.equals(password)));
            System.out.println("VALID");
        }

        else {
            System.out.println("VALID");
        }
    }
}