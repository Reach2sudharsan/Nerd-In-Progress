/*
This program outputs if an entered string meets three of the conditions below. The
conditions are if the string has an even length, has the same first and last letters,
and ends with a certain string used as an actual parameter for the "endsWith" method.
 */
import java.util.Scanner;

/*
The class below is the runner class. It uses the methods in the other class twice because
there are two string inputs.
 */
public class StringRunner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a word:: ");
        String word = keyboard.nextLine();
        StringStuff s = new StringStuff(word);
        System.out.println("has even length " + s.isEvenLength());
        System.out.println("has same first last letters " + s.sameFirstLastLetters());
        System.out.println("ends with cat " + s.endsWith("cat") + "\n");

        System.out.println("Enter a word:: ");
        word = keyboard.nextLine();
        s = new StringStuff(word);
        System.out.println("has even length " + s.isEvenLength());
        System.out.println("has same first last letters " + s.sameFirstLastLetters());
        System.out.println("ends with cat " + s.endsWith("it"));

    }
}

/*
The class below is the "StringStuff" class, which has all the methods required to
make the program output if the inputted strings meet with the three conditions.
 */
class StringStuff {

    private String word;

    public StringStuff(String s) {
        setString(s);
    }

    public void setString(String s) {
        word = s;
    }
    public boolean isEvenLength() {
        if(word.length() % 2 == 0) {
            return true;
        }

        else {
            return false;
        }

    }

    public boolean endsWith(String b) {
        if(word.substring(word.length() - b.length()).equals(b)) {
            return true;
        }

        else {
            return false;
        }

    }

    public boolean sameFirstLastLetters() {
        if(word.charAt(0) == word.charAt(word.length() - 1)) {
            return true;
        }

        else {
            return false;
        }

    }

    public String toString() {
        return "";
    }
}
