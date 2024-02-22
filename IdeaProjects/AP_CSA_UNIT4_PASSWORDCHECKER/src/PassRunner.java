/*
The program below checks to see if the user's input is the same as the
given password or not.
 */
import java.util.Scanner;

/*
The class below is the runner class.
 */
public class PassRunner {
    public static void main(String[] args) {
        PasswordCheck run = new PasswordCheck();
        run.passwordCheck("mchammergohammer");
    }
}

/*
The class below has the method needed for the program to work.
 */
class PasswordCheck {
    public void passwordCheck(String password) {
        Scanner obj = new Scanner(System.in);

        System.out.print("Enter the password :: ");
        String s = obj.nextLine();
        if (!(s.equals(password))) {
            do {
                System.out.println("INVALID");
                System.out.print("Enter the password :: ");
                s = obj.nextLine();

                if (s.equals(password)) {
                    System.out.println("VALID");
                    break;
                }
            } while (!(s.equals(password)));
        }

        else {
            System.out.println("VALID");
        }
    }
}
