import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Main {

    public static int[][] treasure = {
        {34,21,32,41,25},
        {14,42,43,14,31},
        {54,45,52,42,23},
        {33,15,51,31,35},
        {21,52,33,13,23}
    };

    public static void main(String[] args) throws FileNotFoundException {
        problem1();
        //problem2();
        //problem3();
        //problem4();
        //problem5("src/IB CS HL Data Set 1.txt");

        //Problem 5, Part F
        //problem5("src/IB CS HL Data Set 2.txt");
    }

    public static void problem1() {
        String[][] treasure_str = {
                {"34","21","32","41","25"},
                {"14","42","43","14","31"},
                {"54","45","52","42","23"},
                {"33","15","51","31","35"},
                {"21","52","33","13","23"}
        };

        int row = 1;
        int col = 1;
        String number = treasure_str[row-1][col-1];

        while ((row) != Integer.parseInt(String.valueOf(number.charAt(0))) ||
                (col) != Integer.parseInt(String.valueOf(number.charAt(1)))){
            row = Integer.parseInt(String.valueOf(number.charAt(0)));
            col = Integer.parseInt(String.valueOf(number.charAt(1)));;
            System.out.println(row + ", " + col);
            number = treasure_str[row-1][col-1];
        }

        System.out.println("You have found the treasure to be at " + row + ", " + col+".");
    }

    public static void problem2() {
        int count = 0;

        for (int i = 0; i < treasure.length; i++) {
            for (int j = 0; j < treasure[i].length; j++) {
                int number = treasure[i][j];
                int max = treasure[i][0];
                int min = treasure[i][j];
                int x = 0;
                int y = 0;

                for (int k = 0; k < treasure[i].length; k++) {
                    if (treasure[i][k] > max) {
                        max = treasure[i][k];
                        x = i;
                        y = k;
                    }
                }

                for (int l = 0; l < treasure.length; l++) {
                    if (treasure[l][j] < min) {
                        min = treasure[l][j];
                    }
                }

                if (max == min) {
                    count++;
                    System.out.println(x + " " + y);
                }
            }
        }

        if (count == 0) {
            System.out.println("No saddle points");
        }
    }

    public static void problem3() {
        int[][] chessBoard = new int[8][8];
        chessBoard[0][3] = 1;
        chessBoard[7][0] = 2;
        for (int[] i: chessBoard) {
            for (int j: i) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }

        int[] queen1 = {0,0};
        int[] queen2 = {0,0};

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == 1) {
                    queen1[0] = i;
                    queen1[1] = j;
                }
                else if (chessBoard[i][j] == 2) {
                    queen2[0] = i;
                    queen2[1] = j;
                }
            }
        }

        System.out.println();

        int row_count = 0;
        int col_count = 0;
        while (!(queen1[0] == queen2[0]
                && queen1[1] == queen2[1]
                && Math.abs(queen2[0] - queen1[0]) == Math.abs(queen2[1] - queen1[1]))) {
            queen2[1]++;
            col_count++;

            if (queen1[0] == queen2[0]) {
                System.out.println("The queens are in a horizontal position to attack.");
                break;
            }

            else if (queen1[1] == queen2[1]) {
                System.out.println("The queens are in a vertical position to attack.");
                break;
            }

            else if (Math.abs(queen2[0] - queen1[0]) == Math.abs(queen2[1] - queen1[1])) {
                System.out.println("The queens are in a diagonal position to attack.");
                break;
            }
        }

        chessBoard[queen2[0]-row_count][queen2[1]-col_count] = 0;
        chessBoard[queen2[0]][queen2[1]] = 2;

        System.out.println();

        for (int[] i: chessBoard) {
            for (int j: i) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

    public static void problem4() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a sentence without spaces: ");
        String sentence = obj.nextLine(); // "Ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"

        if (sentence.length() > 81) {
            System.out.println("The sentence is greater than 81 characters.");
        }

        else {
            int sentence_length = Math.round(sentence.length());
            int row_length = 0;
            int col_length = 0;
            int index = 0;
            for (int i = 1; i < sentence_length; i++) {
                for (int j = 1; j < sentence_length; j++) {
                    if (i*j == sentence_length && Math.abs(i-j) < 10) {
                        row_length = i;
                        col_length = j;
                    }
                }
            }

            String[][] square = new String[row_length+3][col_length];

            for (int i = 0; i < square.length; i++) {
                for (int j = 0; j < square[i].length; j++) {
                    if (index < sentence.length()) {
                        square[i][j] = Character.toString(sentence.charAt(index));
                        index++;
                    }

                    else {
                        square[i][j] = "";
                    }
                }
            }

            String str = "";

            for (int col = 0; col < square[0].length; col++) {
                for (int row = 0; row < square.length; row++) {
                    str += square[row][col];
                }
                str += " ";
            }
            System.out.println(str);
        }
    }

    public static void problem5(String file) throws FileNotFoundException {
        //Part A
        try {
            File obj = new File(file);
            Scanner reader = new Scanner(obj);

            String[] lines = new String[6];
            int[][] candidates = new int[5][4];

            int a = 0;
            //String data = reader.nextLine();
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                lines[a] = data.substring(4);
                //System.out.println(data);
                a++;
            }
            reader.close();

            for (int index = 1; index < lines.length; index++) {
                String line = lines[index].strip();
                String num = "";
                int i = 0;
                int j = 0;
                while (i < line.length()) {
                    if (Character.isDigit(line.charAt(i))) {
                        num += Character.toString(line.charAt(i));
                        candidates[index-1][j] = Integer.parseInt(num);
                        i++;
                    }
                    else {
                        j++;
                        line = (line.substring(i)).trim();
                        i=0;
                        num = "";
                    }
                }
            }

            //Part B
            String[] candidate_list = {"A", "B", "C", "D"};
            System.out.print("Precinct ");
            for (String s : candidate_list) {
                System.out.print("Candidate_" + s + " ");
            }

            System.out.println();
            int total = 0;
            for (int row = 0; row < candidates.length; row++) {
                System.out.print("\t" + (row+1) + "\t\t");
                for (int col = 0; col < candidates[row].length; col++) {
                    System.out.print(candidates[row][col] + "\t\t\t");
                    total += candidates[row][col];
                }
                System.out.println();
            }
            System.out.println();

            //Part C
            double[] max_votes = new double[4];
            System.out.println("Candidates: ");
            System.out.println();
            for (int col = 0; col < candidates[0].length; col++) {
                System.out.println("Candidate_" + candidate_list[col] + ": ");
                int totalVotes = 0;
                for (int row = 0; row < candidates.length; row++) {
                    totalVotes += candidates[row][col];
                }
                double percent = Math.round(((double)totalVotes/total*100)*100)/100.0;
                max_votes[col] = percent;
                System.out.println("Total Votes: " + totalVotes);
                System.out.println("Percentage: " + percent + "%\n");
            }

            //Part D
            int count = 0;
            for (int i = 0; i < max_votes.length; i++) {
                if (max_votes[i] > 50) {
                    System.out.println("Candidate_" + candidate_list[i] + " got over 50 percent of the votes.");
                    count++;
                }
            }

            //Part E
            int max1_index = 0;
            int max2_index = 0;
            if (count == 0) {
                for (int i = 0; i < max_votes.length; i++) {
                    if (max_votes[i] > max_votes[max1_index]) {
                        max1_index = i;
                    }
                }

                for (int i = 0; i < max_votes.length; i++) {
                    if (max_votes[i] > max_votes[max1_index] && i != max1_index) {
                        max2_index = i;
                    }
                }
                System.out.println("The two top candidates are Candidate_" + candidate_list[max1_index]
                        + " and Candidate_" + candidate_list[max2_index]+".");
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
