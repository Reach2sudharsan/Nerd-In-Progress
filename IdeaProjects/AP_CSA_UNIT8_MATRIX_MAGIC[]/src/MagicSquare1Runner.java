/*
The program right below prints magic squares with the given lengths of its rows
and columns as well as its given values. A magic square must have all its rows, columns,
and diagonals add up to the same value. Based on that, the program also prints if
each square is actually a magic square or not.
 */

/*
The class right below is the runner class.
 */
public class MagicSquare1Runner {
    public static void main(String[] args) {
        MagicSquare1 run = new MagicSquare1(3);
        run.setMagicSquare("8 1 6 3 5 7 4 9 2");
        run.printMagicSquare();
        System.out.println("\n");

        run = new MagicSquare1(3);
        run.setMagicSquare("6 1 8 7 5 3 2 9 4");
        run.printMagicSquare();
        System.out.println("\n");

        run = new MagicSquare1(3);
        run.setMagicSquare("8 3 1 3 5 7 9 4 2");
        run.printMagicSquare();
        System.out.println("\n");

        run = new MagicSquare1(4);
        run.setMagicSquare("7 12 1 14 2 13 8 11 16 3 10 5 9 6 15 4");
        run.printMagicSquare();
        System.out.println("\n");

        run = new MagicSquare1(5);
        run.setMagicSquare("17 24 1 8 15 23 5 7 14 16 4 6 13 20 22 10 12 19 21 3 11 18 25 2 9");
        run.printMagicSquare();
        System.out.println("\n");

        run = new MagicSquare1(5);
        run.setMagicSquare("17 24 1 8 5 23 5 7 14 6 4 6 13 20 2 10 12 19 21 3 11 18 25 2 9");
        run.printMagicSquare();
    }
}

/*
The class right below has the instance variable and methods for this
program to work.
 */
class MagicSquare1 {
    private int[][] magicSquare;

    public MagicSquare1(int i) {
        this.magicSquare = new int[i][i];
    }

    public void setMagicSquare(String nums) {
        nums += "  ";
        for (int row = 0; row < magicSquare.length; row++) {
            for (int col = 0; col < magicSquare[row].length; col++) {
                int i = 0;
                String str = "";
                while (Character.isDigit(nums.charAt(0))) {
                    str += nums.charAt(0);
                    i++;
                    nums = nums.substring(i);
                    i--;
                }
                nums = nums.substring(i+1);

                int num = Integer.parseInt(str);
                magicSquare[row][col] = num;
            }
        }
    }


    public int checkRow() {
        int[] sums = new int[magicSquare.length];

        for (int row = 0; row < magicSquare.length; row++) {
            for (int col = 0; col < magicSquare[row].length; col++) {
                sums[row] += magicSquare[row][col];
            }
        }

        int sum = 0;
        for (int i = 0; i < sums.length; i++) {
            sum += sums[i];
        }

        if (sum/sums.length == sums[0]) {
            return sums[0];
        }
        return -1;
    }

    public int checkColumn() {
        int[] sums = new int[magicSquare.length];

        for (int col = 0; col < magicSquare.length; col++) {
            for (int row = 0; row < magicSquare[col].length; row++) {
                sums[row] += magicSquare[row][col];
            }
        }

        int sum = 0;
        for (int i = 0; i < sums.length; i++) {
            sum += sums[i];
        }

        if (sum/sums.length == sums[0]) {
            return sums[0];
        }
        return -1;
    }

    public int checkDiagonal() {
        int sum1 = 0;
        for (int row = 0; row < magicSquare.length; row++) {
            sum1 += magicSquare[row][row];
        }

        int sum2 = 0;
        for (int row = magicSquare.length-1; row >= 0; row--) {
            sum2 += magicSquare[row][row];
        }

        if (sum1 == sum2) {
            return sum1;
        }
        return -1;
    }

    public void printMagicSquare() {
        for (int row = 0; row < magicSquare.length; row++) {
            for (int col = 0; col < magicSquare[row].length; col++) {
                System.out.print(magicSquare[row][col] + " ");
            }
            System.out.println();
        }

        if (checkRow() == checkColumn() &&
                checkRow() == checkDiagonal() &&
                checkRow() != -1) {
            System.out.println("MAGIC SQUARE");
        }

        else {
            System.out.println("NOT A MAGIC SQUARE");
        }
    }
}
