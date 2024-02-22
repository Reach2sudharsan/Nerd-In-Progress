import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.println("Welcome to my Blackjack Program");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Choose a menu option: ");
            System.out.println("\tType 0 to quit the program");
            System.out.println("\tType 1 to deal a new hand");
            int choice = obj.nextInt();
            if (choice == 0) {
                keepGoing = false;
            }

            else if (choice == 1) {
                newHand();
            }

            else {
                System.out.println("Unexpected error has occurred.");
            }
        }
        System.out.println("Program closing");
    }

    public static int dealCard() {
        int cardNum = (int)(Math.random()*10)+2;
        return cardNum;
    }

    public static int sumCards(ArrayList<Integer> cards) {
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            sum += cards.get(i);
        }
        return sum;
    }

    public static void newHand() {
        Scanner obj = new Scanner(System.in);
        ArrayList<Integer> playerCards = new ArrayList<Integer>();
        ArrayList<Integer> dealerCards = new ArrayList<Integer>();

        playerCards.add(dealCard());
        dealerCards.add(dealCard());
        playerCards.add(dealCard());
        dealerCards.add(dealCard());

        System.out.println("You have a " + playerCards.get(0) + " and a " + playerCards.get(1));
        System.out.println("The dealer has a " + dealerCards.get(0) + " and a hidden card");

        boolean youLose = false;
        String choice = "hit";

        while (choice.compareToIgnoreCase("stick") != 0) {
            System.out.println("Would you like another card or hold?");
            System.out.println("Type 'hit' for a new card");
            System.out.println("or 'stick' to stop.");

            System.out.println("Choice: ");
            choice = obj.nextLine();

            if (choice.equals("hit")) {
                int newCard = dealCard();
                playerCards.add(newCard);
                System.out.println("Your new card is a " + newCard);
            }

            else if (choice.equals("stick")) {
                System.out.println("Error input not understood no card appended");
            }

            int total = sumCards(playerCards);
            if (total > 21) {
                System.out.println("Sorry you have a bust and lose");
                youLose = true;
                break;
            }

            else {
                System.out.println("Your current TOTAL is " + total);
            }
        }

        if (youLose == false) {
            System.out.println("The dealer reveals his hidden card it's a " + dealerCards.get(1));
            int dealerTotal = sumCards(dealerCards);
            while (dealerTotal < 18) {
                System.out.println("Dealer is twisting .....");
                int newCard = dealCard();
                System.out.println("New card is " + newCard);
                dealerCards.add(newCard);
                dealerTotal = sumCards(dealerCards);
                if (dealerTotal > 21) {
                    System.out.println("Dealer busts");
                    System.out.println("You win");
                    break;
                }
            }

            if (dealerTotal < 22) {
                System.out.println("The dealer sticks with a score of " + dealerTotal);
                if (dealerTotal >= sumCards(playerCards)) {
                    System.out.println("Dealer Wins");
                }

                else {
                    System.out.println("You win");
                }
            }
        }
    }
}
