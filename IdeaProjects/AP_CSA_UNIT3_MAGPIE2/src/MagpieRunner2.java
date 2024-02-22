/*
The program below is a magpie chat bot program that replies based
on whatever the user enters.
 */
import java.util.Scanner;

/*
The class below is the runner class.
 */
public class MagpieRunner2 {
    public static void main(String[] args) {
        Magpie2 maggie = new Magpie2();

        System.out.println(maggie.getGreeting());
        Scanner in = new Scanner(System.in);
        String statement = in.nextLine();

        while (!statement.equals("Bye")) {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
    }

}

/*
The class below has all the methods required for the chat bot
to work.
 */
class Magpie2  {

    public String getGreeting()  {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";

        if (statement.length() == 0) {
            response = "Say something, please.";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        }

        else if (statement.indexOf("dog") >= 0
                || statement.indexOf("cat") >= 0) {
            response = "Tell me more about your pets.";
        }

        else if (statement.indexOf("teacher") >= 0) {
            response = "Tell me more about your teacher.";
        }

        else if (statement.indexOf("food") >= 0) {
            response = "Tell me more about your food.";
        }

        else if (statement.indexOf("school") >= 0) {
            response = "Tell me more about your school.";
        }

        else if (statement.indexOf("friend") >= 0) {
            response = "Tell me more about your friend.";
        }

        else if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
        }

        else {
            response = getRandomResponse();
        }

        return response;

    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1) {
            response = "Hmmm.";
        }
        else if (whichResponse == 2) {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3) {
            response = "You don't say.";
        }

        else if (whichResponse == 4) {
            response = "That sounds amazing!";
        }

        else if (whichResponse == 5) {
            response = "I agree.";
        }

        return response;
    }
}
