/*
The program below is supposed to print if the inputted characters are uppercase letters, lowercase letters, or numbers.
The program also outputs the corresponding ASCII values of the inputted characters.
 */
import java.util.Scanner;

/*
The class below is the runner class.
 */
public class CharacterRunner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a letter :: ");
        char letter = keyboard.next().charAt(0);
        CharacterAnalyzer test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);

        System.out.print("Enter a letter :: ");
        letter = keyboard.next().charAt(0);
        test = new CharacterAnalyzer(letter);
        System.out.println(test);
    }
}

/*
The class below has all the methods needed to output if the inputted characters are uppercase letters, lowercase letters, or numbers, and output their
corresponding ASCII values.

 */
class CharacterAnalyzer {
    private char theChar;

    public CharacterAnalyzer(char c) {
        setChar(c);
    }

    public void setChar(char c) {
        theChar = c;
    }

    public char getChar() {
        return theChar;
    }

    public boolean isUpper() {
        if(Character.isUpperCase(theChar)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isLower() {
        if(Character.isLowerCase(theChar)) {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isNumber() {
        if(Character.isDigit(theChar)) {
            return true;
        }

        else {
            return false;
        }
    }

    public int getASCII() {
        int ascii = (int)theChar;
        return ascii;
    }

    public String toString() {
        if(isUpper()) {
            return ""+getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
        }

        else if(isLower()) {
            return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
        }

        else if(isNumber()) {
            return ""+getChar() + " is a number. ASCII == " + getASCII() + "\n";
        }
        return "";
    }
}