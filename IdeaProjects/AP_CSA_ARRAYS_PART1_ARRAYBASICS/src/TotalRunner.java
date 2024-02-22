/*
The program below prints the sum of all the numbers in each given list.
 */

/*
The class below is the runner class.
 */
public class TotalRunner {

    public static void main(String[] args) {

        RayTotal run = new RayTotal(new int[]{-99, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12345});
        run.calcSum();

        run = new RayTotal(new int[]{10,9,8,7,6,5,4,3,2,1,-99});
        run.calcSum();

        run = new RayTotal(new int[]{10,20,30,40,50,-11818,40,30,20,10});
        run.calcSum();

        run = new RayTotal(new int[]{32767});
        run.calcSum();

        run = new RayTotal(new int[]{255,255});
        run.calcSum();

        run = new RayTotal(new int[]{9,10,-88,100,-555,1000});
        run.calcSum();

        run = new RayTotal(new int[]{10,10,10,11,456});
        run.calcSum();

        run = new RayTotal(new int[]{-111,1,2,3,9,11,20,30});
        run.calcSum();

        run = new RayTotal(new int[]{9,8,7,6,5,4,3,2,0,-2,-989});
        run.calcSum();

        run = new RayTotal(new int[]{12,15,18,21,23,1000});
        run.calcSum();

        run = new RayTotal(new int[]{250,19,17,15,13,11,10,9,6,3,2,1,-455});
        run.calcSum();

        run = new RayTotal(new int[]{9,10,-8,10000,-5000,1000});
        run.calcSum();
    }
}

/*
The class below has the method for printing the sum of all numbers in each given list.
 */
class RayTotal {

    private int[] array;

    public RayTotal(int[] array) {
        this.array = array;
    }

    public void calcSum() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }
}
