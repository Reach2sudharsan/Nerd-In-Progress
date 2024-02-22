/*
The program right below is the Parallel Array Dojo exercise. It uses arrays
for three snakes, their lengths, and their ages and prints all of that
information.
 */

/*
The class right below is the runner class.
 */
public class Main {
    public static void main(String[] args) {
        String[] snakeName = {"Springy", "Bitey", "Cuddly"};
        int[] length = {100, 200, 500};
        int[] age = {10, 25, 100};

        for (int i = 0; i < snakeName.length; i++) {
            System.out.println("Snake name: " + snakeName[i]);
            System.out.println("Length: " + length[i] + " cm");
            System.out.println("Age: " + age[i] + " years");
            System.out.println("");
        }
    }
}
