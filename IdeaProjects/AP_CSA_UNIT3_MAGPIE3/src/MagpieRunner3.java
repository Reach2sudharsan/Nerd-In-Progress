/*
The program below is a magpie chat bot program that replies based
on whatever the user enters.
 */
import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */

/*
The class below is the runner class.
 */
public class MagpieRunner3
{

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        Magpie3 maggie = new Magpie3();

        System.out.println (maggie.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();

        while (!statement.equals("Bye"))
        {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
    }

}

/**
 * A program to carry on conversations with a human user.
 * This version:
 * <ul><li>
 *    Uses advanced search for keywords
 * </li></ul>
 *
 * @author Laurie White
 * @version April 2012
 */

/*
The class below has all the methods required for the chat bot
to work.
 */
class Magpie3
{
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }
        else if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sister") >= 0
                || findKeyword(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findKeyword(statement, "dog") >= 0
                || findKeyword(statement, "cat") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findKeyword(statement, "teacher") >= 0)
        {
            response = "Tell me more about your teacher.";
        }
        else if (findKeyword(statement, "food") >= 0)
        {
            response = "Tell me more about your food.";
        }
        else if (findKeyword(statement, "school") >= 0)
        {
            response = "Tell me more about your school.";
        }
        else if (findKeyword(statement, "friend") >= 0)
        {
            response = "Tell me more about your friend";
        }
        else if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        int pos = phrase.indexOf(goal, startPos);


        while (pos >= 0)
        {
            String before = " ", after = " ";
            if (pos > 0)
            {
                before = phrase.substring(pos - 1, pos);
            }

            if (pos + goal.length() < phrase.length() - 1)
            {
                after = phrase.substring(pos + goal.length(),
                        pos + goal.length() + 1);

            }

            if ((before.compareTo("a") < 0 || before.compareTo("z") > 0) &&
                    (after.compareTo("a")  < 0 ||  after.compareTo("z") > 0))
            {
                return pos;
            }

            pos = phrase.indexOf(goal, pos + 1);
        }
        return -1;
    }


    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }

}

/*
The class below has string samples for the chat bot.
 */
class StringExplorer
{

    public static void main(String[] args)
    {
        String sample = "The quick brown fox jumped over the lazy dog.";

        //  Demonstrate the indexOf method.
        int position = sample.indexOf("quick");
        System.out.println ("sample.indexOf(\"quick\") = " + position);
        int pos = sample.indexOf("slow");
        if(pos != -1) {
            System.out.println("slow is found at position " + pos);
        }
        else {
            System.out.println("slow is not found");
        }

        //  Demonstrate the toLowerCase method.
        String lowerCase = sample.toLowerCase();
        System.out.println ("sample.toLowerCase() = " + lowerCase);
        System.out.println ("After toLowerCase(), sample = " + sample);

        //  Try other methods here:
        int index = 0;
        int start = 0;
        int occurrences = 0;
        while ((lowerCase.indexOf("the", index) >= start) && (start != lowerCase.length() -1))
        {
            if (lowerCase.indexOf("the", index) == start)
            {
                occurrences += 1;
            }
            start += 1;
        }
    }
}
