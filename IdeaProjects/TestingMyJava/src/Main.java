//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner run = new Scanner(System.in);

        Bank ac1 = new Bank();

        ac1.deposit(100);
        System.out.println(ac1.getBalance());

        ac1.withdraw(32.45);
        System.out.println(ac1.getBalance());

    }
}

class Bank {

    private double balance;

    public Bank() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;

    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

}




