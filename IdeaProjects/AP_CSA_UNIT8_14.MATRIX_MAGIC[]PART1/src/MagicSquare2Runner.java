public class MagicSquare2Runner {
    public static void main(String[] args) {
        MagicSquare2 run = new MagicSquare2(5);
        run.createMagicSquare();
        run.printMagicSquare();
        System.out.println();

        run = new MagicSquare2(1);
        run.createMagicSquare();
        run.printMagicSquare();
        System.out.println();

        run = new MagicSquare2(7);
        run.createMagicSquare();
        run.printMagicSquare();
        System.out.println();

        run = new MagicSquare2(3);
        run.createMagicSquare();
        run.printMagicSquare();
    }
}

class MagicSquare2 {
    private int[][] magicSquare;

    public MagicSquare2(int i) {
        this.magicSquare = new int[i][i];
    }

    public void createMagicSquare() {
        magicSquare[0][magicSquare.length/2] = 1;
        int length = magicSquare.length;
        int num1 = magicSquare[0][magicSquare.length/2];
        int row = 0;
        int col = magicSquare.length/2;
        int num2 = 0;
        num2 = num1;
        for (int i = 0; i < length*length-1; i++) { //length*length

            if (row == 0) {
                row = magicSquare.length-1;
            }

            else {
                row -= 1;
            }

            if (col == magicSquare.length-1) {
                col = 0;
            }

            else {
                col++;
            }

            num1++;
            if (magicSquare[row][col] == num2) {
                row += 2;
                if (row > magicSquare.length-1) {
                    row = row-magicSquare.length;
                }

                if (col == 0) {
                    col = magicSquare.length-1;
                }

                else {
                    col--;
                }
                num2 = num1;
            }
            magicSquare[row][col] = num1;
        }
    }

    public int checkHorizontal() {
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

    public int checkVertical() {
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
    }
}
