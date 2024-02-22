/*
The program right below returns the a list of the first three numbers from each
given list that are greater than eleven. If there are fewer than three numbers,
the it would return as many numbers that are greater than eleven. If there are no
numbers greater than eleven, the list that is returned will be empty.
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/*
The class right below is the runner class.
 */
public class GetNumsRunner {
    public static void main(String[] args) {
        ListGetNums run = new ListGetNums(new Integer[]{-99,1,2,3,4,5,6,7,8,9,10,12345});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{10,9,8,7,6,5,4,3,2,1,-99});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{10,20,30,40,50,-11818,40,30,20,10});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{32767});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{255,255});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{9,10,-88,100,-555,1000});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{10,10,10,11,456});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{-111,1,2,3,9,11,20,30});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{9,8,7,6,5,4,3,2,0,-2,-989});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{12,15,18,21,23,1000});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{250,19,17,15,13,11,10,9,6,3,2,1,-455});
        run.findNums();
        System.out.println(run.findNums());

        run = new ListGetNums(new Integer[]{9,10,-8,10000,-5000,1000});
        run.findNums();
        System.out.println(run.findNums());
    }
}

/*
The class right below has all the instance variables and a method for
this program to work.
 */
class ListGetNums {
    private List<Integer> nums;
    private List<Integer> newNums;

    public ListGetNums(Integer[] nums) {
        this.nums = Arrays.asList(nums);
    }

    public List<Integer> findNums() {
        newNums = new ArrayList<Integer>();
        int num = 0;
        int i = 0;
        while (num < 3 && i < nums.size()) {
            if (nums.get(i) > 11) {
                newNums.add(nums.get(i));
                num++;
            }
            i++;
        }
        return newNums;
    }

    public String toString() {
        return nums.toString();
    }


}
