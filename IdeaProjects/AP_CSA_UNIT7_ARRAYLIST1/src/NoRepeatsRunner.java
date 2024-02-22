/*
The program right below goes through each given list to see if any
of the numbers in each list repeat. If none of the numbers repeat
inside a list, the program would return true for that list. If one
or more numbers in a list repeat, the program would return false
for that list.
 */
import java.util.Arrays;
import java.util.List;

/*
The class right below is the runner class.
 */
public class NoRepeatsRunner {
    public static void main(String[] args) {

        ListNoRepeats run = new ListNoRepeats(new Integer[]{-99,1,2,3,4,5,6,6,6,6,6,7,8,9,10,12345,5,5,5,5});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{10,9,8,7,6,5,4,3,2,1,-99});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{10,20,30,40,50,10,10,40,30,20,10});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{32767});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{255,255});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{9,10,-88,100,-555,1000});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{10,10,10,11,456,10,10,2,2,2,2,2,2,2});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{-111,1,2,3,9,11,20,30});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{9,8,7,6,5,4,3,2,0,-2,-989});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{12,12,15,18,21,23,1000});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{250,19,17,15,13,13,13,13,11,10,9,6,3,2,1,1});
        System.out.println(run.noRepeats());

        run = new ListNoRepeats(new Integer[]{9,10,-8,10000,-5000,1000});
        System.out.println(run.noRepeats());
    }
}

/*
The class right below has an instance variable and a method for this
program to work.
 */
class ListNoRepeats {
    private List<Integer> nums;

    public ListNoRepeats(Integer[] nums) {
        this.nums = Arrays.asList(nums);
    }

    public boolean noRepeats() {

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(i).equals(nums.get(j)) && i != j) {
                    return false;
                }
            }
        }
        return true;
    }
}
