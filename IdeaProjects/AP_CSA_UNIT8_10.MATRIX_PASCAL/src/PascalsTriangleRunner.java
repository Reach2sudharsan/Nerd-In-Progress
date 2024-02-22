/*
The program right below creates Pascal triangles based on the given numbers.

Pascal triangles are triangular arrays made by adding
adjacent numbers in preceding rows.
e.g.
    1
   1 1
  1 2 1       1+1 = 2, so it is 1,2,1.
 1 3 3 1      1+2 = 3, 2+1 = 3, so it is 1,3,3,1.
 */

/*
The class right below is the runner class.
 */
public class PascalsTriangleRunner {
    public static void main(String[] args) {

        //tests
        PascalsTriangle run = new PascalsTriangle(3);
        run.setPascalTriangle();
        run.printPascalTriangle();
        System.out.println();

        run = new PascalsTriangle(6);
        run.setPascalTriangle();
        run.printPascalTriangle();
        System.out.println();

        run = new PascalsTriangle(7);
        run.setPascalTriangle();
        run.printPascalTriangle();
        System.out.println();

        run = new PascalsTriangle(2);
        run.setPascalTriangle();
        run.printPascalTriangle();
        System.out.println();

        run = new PascalsTriangle(4);
        run.setPascalTriangle();
        run.printPascalTriangle();
        System.out.println();

        run = new PascalsTriangle(5);
        run.setPascalTriangle();
        run.printPascalTriangle();
        System.out.println();
    }
}

/*
The class right below has the instance variable for the Pascal triangles
and methods to help make and print them.
 */
class PascalsTriangle {

    //2D array for displaying a Pascal triangle
    private int[][] pascal;

    //Constructor - takes in an int parameter which determines the size of the Pascal triangle
    public PascalsTriangle(int i) {
        this.pascal = new int[i][];
    }

    //method for making a Pascal triangle
    public void setPascalTriangle() {

        //Shapes the 2D array Pascal such that it is a triangle
        //The next row is one column greater than the previous row.
        for (int row = 0; row < pascal.length; row++) {
            pascal[row] = new int[row+1];
        }

        //The first/top value of a Pascal triangle is always one.
        pascal[0][0] = 1;

        //This for loop places the Pascal numbers into their correct positions.
        for (int row = 1; row < pascal.length; row++) {//iterates from the second row to the last row

            //The first and last value of each row after the first row is always one.
            pascal[row][0] = 1;
            pascal[row][pascal[row].length-1] = 1;

            /*
            nested for loop - uses the Pascal formula to add the rest of the Pascal numbers
            Pascal Formula:
            number = number from previous row and previous column +
            number from previous row and current column
            e.g.
            third row = 1 2 1,
            fourth row = 1 3 3 1 because 1+2 = 3 and 2+1 = 3
            */

            for (int col = 1; col < pascal[row].length-1; col++) {
                if (row > 1) {
                    pascal[row][col] = pascal[row-1][col-1]+pascal[row-1][col];// applies pascal formula
                }
            }
        }
    }

    //This method prints the Pascal triangle in a triangular format.
    public void printPascalTriangle() {

        for (int row = 0; row < pascal.length; row++) {

            //The index i is used for printing a certain number of spaces.
            for (int i = pascal[pascal.length-1-row].length; i >=0; i--) {

                //This adds many spaces, but the number of spaces decreases due to the condition above.
                System.out.print(" ");
            }

            /*
            This is a  condition that I had to add because
            the triangles used to look distorted after the fifth row.

             */
            if (row < 5) {
                System.out.print(" ");
            }

            for (int col = 0; col < pascal[row].length; col++) {
                System.out.print(pascal[row][col] + " ");//prints the Pascal values in order
            }
            System.out.println();
        }
    }
}
