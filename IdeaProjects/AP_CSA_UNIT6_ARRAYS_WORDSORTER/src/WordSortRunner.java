/*
The program below turns the given data into separate strings inside a list and
sorts them.
*/
import java.util.Arrays;

/*
The class below is the runner class.
*/
public class WordSortRunner
{
    public static void main(String args[])
    {
        //add test cases
        WordSort run = new WordSort("abc ABC 12321 fred alexander");
        run.sort();
        run.printArray();
        System.out.println("\n\n");

        run = new WordSort("a zebra friendly acrobatics 435 TONER PRinTeR");
        run.sort();
        run.printArray();
        System.out.println("\n\n");

        run = new WordSort("b x 4 r s y $");
        run.sort();
        run.printArray();
        System.out.println("\n\n");

        run = new WordSort("123 ABC abc 034 dog cat sally sue bob 2a2");
        run.sort();
        run.printArray();
    }
}

/*
The class below has all the methods required for this program to work.
*/
class WordSort
{
    private String[] wordRay;

    public WordSort(String line)
    {
        setList(line);
    }

    public void setList(String line)
    {
        wordRay = line.split(" ");
    }

    public void sort()
    {
        Arrays.sort(wordRay);
    }

    public void printArray() {
        for (int i = 0; i < wordRay.length; i++) {
            System.out.println("word " + i + " :: " + wordRay[i]);
        }
    }

    public String toString( )
    {
        String output="";
        return output+"\n\n";
    }
}






