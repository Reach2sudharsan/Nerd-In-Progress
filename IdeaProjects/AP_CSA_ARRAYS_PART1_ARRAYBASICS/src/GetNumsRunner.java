/*
The program below prints arrays with 3 integers in each, which are the first
three numbers in each given array that are greater than eleven.
*/
import java.util.Arrays;

/*
The class below is the runner class.
*/
public class GetNumsRunner {

    public static void main(String[] args) {

        RayGetNums run = new RayGetNums(new int[]{-99,1,2,3,4,5,6,7,8,9,10,12345});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{10,9,8,7,6,5,4,3,2,1,-99});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{10,20,30,40,50,-11818,40,30,20,10});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{32767});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{255,255});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{9,10,-88,100,-555,1000});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{10,10,10,11,456});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{-111,1,2,3,9,11,20,30});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{9,8,7,6,5,4,3,2,0,-2,-989});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{12,15,18,21,23,1000});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{250,19,17,15,13,11,10,9,6,3,2,1,-455});
        System.out.println(run.go());

        run = new RayGetNums(new int[]{9,10,-8,10000,-5000,1000});
        System.out.println(run.go());
    }
}

/*
The class below has the method for printing an array of 3 integers, which are
the first three numbers in each given array that are greater than eleven.
*/
class RayGetNums {

    private int[] array;

    public RayGetNums(int[] array) {
        this.array = array;
    }

    public String go() {
        int[] nums = {0,0,0};
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 11) {
                nums[index] = array[i];
                index += 1;
            }

            if (index > 2) {
                break;
            }
        }

        return Arrays.toString(nums);
    }
}
