/*
The program below allows the user to play a guessing game, where they will have
to guess a random number that is generated. Also, the program will print how
many guesses the user took to guess the random number. The user can also
choose to play again.
 */
import java.util.Scanner;

/*
The class below is the runner class.
 */
public class GuessRunner {
    public static void main(String[] args) {
        GuessingGame run = new GuessingGame();
        Scanner playGame = new Scanner(System.in);

        run.playGame();

        System.out.println("Do you want to play again?: ");
        String yesNo = playGame.nextLine();

        if (yesNo.equals("y")) {

            while (yesNo.equals("y")) {
                run.playGame();
                System.out.println("Do you want to play again?: ");
                yesNo = playGame.nextLine();

                if (yesNo == "n") {
                    break;
                }
            }
        }
    }
}

/*
The class below has all the methods required for the user to play a guessing game
or guessing games.
 */
class GuessingGame {

    public void playGame() {
        Scanner obj = new Scanner(System.in);

        System.out.println("Guessing Game - how many numbers?: ");
        int maxValue = obj.nextInt();

        double randomNum = (Math.random()*(maxValue - 1)) + 1;
        int randNum = (int)randomNum;

        System.out.println("Enter a number between 1 and " + maxValue + ": ");
        int enterValue = obj.nextInt();

        int guesses = 0;
        if (enterValue != randNum) {

            while (enterValue != randNum) {

                if (enterValue < 1 || enterValue > maxValue) {
                    System.out.println("Number out of range!");
                    System.out.println("Enter a number between 1 and " + maxValue + ": ");
                    enterValue = obj.nextInt();
                }

                else {
                    guesses += 1;
                    System.out.println("Enter a number between 1 and " + maxValue + ": ");
                    enterValue = obj.nextInt();
                }

                if (enterValue == randomNum) {
                    break;
                }
            }
            results(maxValue, randNum, guesses);
        }

        else {
            results(maxValue, randNum, guesses);
        }
    }


    public void results(double max, int randNum, int guesses) {
        System.out.println("It took " + guesses + " guesses to guess " + randNum + ".");
        double percentage = ((guesses)/max)*100;
        System.out.println("You guessed wrong " + Math.round(percentage) + " percent of the time.");
    }

}