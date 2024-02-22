/*
The program right below sorts the given arrays of strings in a new ArrayList
and returns that ArrayList. A selection sort algorithm and an insertion sort
algorithm is used to sort the given arrays of strings.
 */
import java.util.ArrayList;
import java.util.Arrays;

/*
The class right below is the runner class.
 */
public class StringStuffRunner {
    public static void main(String[] args) {
        System.out.println("Test with the selection sort algorithm:");
        StringStuff run = new StringStuff(new String[]{"7a7", "888", "9"});
        run.digitSortSelectionSort();
        System.out.println(run);

        run = new StringStuff(new String[]{"1one", "three22", "z", "a7"});
        run.digitSortSelectionSort();
        System.out.println(run);
        System.out.println("");

        System.out.println("Test with the insertion sort algorithm:");
        run = new StringStuff(new String[]{"7a7", "888", "9"});
        run.digitSortInsertionSort();
        System.out.println(run);

        run = new StringStuff(new String[]{"1one", "three22", "z", "a7"});
        run.digitSortInsertionSort();
        System.out.println(run);
    }
}

/*
The class right below has all the methods required for this program to work.
 */
class StringStuff {

    private ArrayList<String> words;

    public StringStuff(String[] words) {
        this.words = new ArrayList(Arrays.asList(words));
    }

    public int getDigCount(int position) {
        int count = 0;
        for (int i = 0; i < words.get(position).length(); i++) {
            if (Character.isDigit(words.get(position).charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public void digitSortSelectionSort() {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < words.size(); i++) {
            nums.add(getDigCount(i));
        }

        for (int i = 0; i < nums.size()-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.size(); j++) {
                if (nums.get(j) < nums.get(min)) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums.get(min);
                String str = words.get(min);

                nums.set(min, nums.get(i));
                words.set(min, words.get(i));

                nums.set(i, temp);
                words.set(i, str);
            }
        }
    }

    public void digitSortInsertionSort() {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < words.size(); i++) {
            nums.add(getDigCount(i));
        }

        for (int i = 1; i < words.size(); i++) {
            int val = nums.get(i);
            String str = words.get(i);
            int j = i;
            while (j>0 && val < nums.get(j-1)) {
                nums.set(j, nums.get(j-1));
                words.set(j, words.get(j-1));
                j--;
            }
            nums.set(j, val);
            words.set(j, str);
        }
    }

    public String toString() {
        return words.toString();
    }
}
