/*
The program right below prints the given matrix and count how many times
a number occurs in the matrix.
 */

/*
The class right below is the runner class.
 */
public class MatrixCount1Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0},
                {6, 7, 1, 2, 5},
                {6, 7, 8, 9, 0},
                {5, 4, 3, 2, 1}
        };

        MatrixCount1 run = new MatrixCount1(matrix);
        run.printMatrix();

        System.out.println();

        System.out.println("The 7 count is :: " + run.countNum(7));
        System.out.println("The 8 count is :: " + run.countNum(8));
        System.out.println("The 6 count is :: " + run.countNum(6));
        System.out.println("The 21 count is :: " + run.countNum(21));
    }
}

/*
The class right below has all the methods required for this program to work.
 */
class MatrixCount1 {
    private int[][] matrix;

    public MatrixCount1(int[][] matrix) {
        this.matrix = matrix;
    }

    public void printMatrix() {
        System.out.println("Matrix values");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public int countNum(int num) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == num) {
                    count++;
                }
            }
        }
        return count;
    }
}
