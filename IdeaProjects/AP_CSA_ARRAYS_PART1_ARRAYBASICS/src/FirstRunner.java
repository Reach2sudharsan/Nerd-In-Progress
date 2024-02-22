/*
The program below prints if each array has any repeats of its first number.
*/

/*
The class below is the runner class.
*/
public class FirstRunner {

    public static void main(String[] args) {
        RayFirst run = new RayFirst(new int[]{-99,1,2,3,4,5,6,7,8,9,10,12345});
        System.out.println(run.go());

        run = new RayFirst(new int[]{10,9,8,7,6,5,4,3,2,1,-99});
        System.out.println(run.go());

        run = new RayFirst(new int[]{10,20,30,40,50,-11818,40,30,20,10});
        System.out.println(run.go());

        run = new RayFirst(new int[]{32767});
        System.out.println(run.go());

        run = new RayFirst(new int[]{7,7,7,7});
        System.out.println(run.go());

        run = new RayFirst(new int[]{9,10,-88,100,-555,1000});
        System.out.println(run.go());

        run = new RayFirst(new int[]{10,10,10,11,456});
        System.out.println(run.go());

        run = new RayFirst(new int[]{-111,1,2,3,9,11,20,30});
        System.out.println(run.go());

        run = new RayFirst(new int[]{9,8,7,6,5,4,3,2,0,-2,9,9});
        System.out.println(run.go());

        run = new RayFirst(new int[]{12,15,18,21,23,1000});
        System.out.println(run.go());

        run = new RayFirst(new int[]{250,19,17,15,13,11,10,9,6,3,2,1,-455});
        System.out.println(run.go());

        run = new RayFirst(new int[]{});
        System.out.println(run.go());
    }
}

/*
The class below has the method for returning either true or false if
the first value in each array is repeated.
*/
class RayFirst {

    private int[] array;

    public RayFirst(int[] array) {
        this.array = array;
    }

    public boolean go() {

        int num = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[0]) {
                num += 1;
            }
        }

        if (num > 0) {
            return true;
        }
        return false;
    }
}
