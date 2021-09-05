/*
The program right below intends to simulate a real life grocery store purchase experience
via membership accounts where, as either a regular or special member, you can buy many products
for a limited amount of credit. The products that are available are produce, dairy, frozen foods,
and snacks. Regular membership has a maximum credit of $500.00 and special membership has a maximum
credit of $800.00.
 */
import java.util.ArrayList;
import java.util.Scanner;

/*
The class right below is the runner class.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the grocery store. Here, you can make a membership account and start buying grocery products!");
        System.out.println("You can apply for regular membership(maximum credit: $500.00) or special membership(maximum credit: $800.00).");
        System.out.println("Before you start buying goods, you have to either login to your account or create one if you do not have an account.");
        groceryAccounts grocery1 = new groceryAccounts();
        grocery1.setUp();
    }
}

/*
The class right below has a private ArrayList variable that stores objects of the Member
class and the SpecialMember class. This has the methods for setting up and logging into
accounts and getting ready to buy products. It also has methods for the user to modify
their account details or delete their account.
 */
class groceryAccounts {

    // 2. Encapsulation
    private final ArrayList<Member> accounts;// 7. ArrayList
    private final Scanner obj1 = new Scanner(System.in);
    private final Scanner obj2 = new Scanner(System.in);

    public groceryAccounts() {
        accounts = new ArrayList<Member>();
    }

    public int lookForAccount(String username, String password) {

        // 11. For Loops
        for (int i = 0; i < accounts.size(); i++) {

            // 9. If statements
            if (accounts.get(i).getUsername().equals(username) &&
                    accounts.get(i).getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isThere(String str, String[] strings) {

        // 12. Enhanced For Loops
        for (String s: strings) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setUp() {
        System.out.println("\nDo you want to login to or create a membership account for the grocery store?(login, create, or neither): ");
        String answer1 = obj1.nextLine();

        // 10. While Loops
        while (!(answer1.equals("neither"))) {

            while (!(answer1.equals("login") || answer1.equals("create") || answer1.equals("neither"))) {
                System.out.println("\nInvalid input!");
                System.out.println("Re enter if you want to login to or create a membership account for the grocery store(login, create, or neither): ");
                answer1 = obj1.nextLine();
            }

            if (answer1.equals("login")) {
                if (accounts.size() == 0) {
                    System.out.println("\nThere are currently no accounts.");
                    System.out.println("Do you want to login to or create a membership account for the grocery store?(login, create, or neither): ");
                    answer1 = obj1.nextLine();
                }

                else {
                    login();
                    return;
                }
            }

            else if (answer1.equals("create")) {
                System.out.println("\nEnter your first name: ");
                String firstName = obj1.nextLine();

                System.out.println("Enter your last name: ");
                String lastName = obj1.nextLine();

                System.out.println("Enter your age: ");
                int age = obj2.nextInt();

                System.out.println("Create a username: ");
                String username = obj1.nextLine();

                System.out.println("Create a password: ");
                String password = obj1.nextLine();

                System.out.println("Enter the status of your membership application(r if regular or s if special): ");
                String status = obj1.nextLine();

                while (!(status.equals("s") || status.equals("r"))) {
                    System.out.println("\nInvalid input!");
                    System.out.println("Re enter the status of your membership application(r if regular or s if special): ");
                    status = obj1.nextLine();
                }

                if (status.equals("r")) {
                    accounts.add(new Member(firstName, lastName, age, username, password));
                }

                else {
                    accounts.add(new SpecialMember(firstName, lastName, age, username, password));
                }
                System.out.println("\nYou have successfully created an account!");
                System.out.println("Do you want to login to or create a membership account for the grocery store?(login, create, or neither): ");
                answer1 = obj1.nextLine();
            }
        }
        System.out.println("\nSee you next time!");
    }

    public void login() {
        int index = -1;
        while(index == -1) {
            System.out.println("\nEnter your username: ");
            String username = obj1.nextLine();

            System.out.println("Enter your password: ");
            String password = obj1.nextLine();

            index = lookForAccount(username, password);

            if (index == -1) {
                System.out.println("\nThis account does not exist. Enter again.");
            }
        }
        System.out.println("\nSuccessfully Logged in");

        System.out.println("Do you want to buy anything, modify your account details, or delete your account?(buy, modify, delete, or none): ");
        String products = obj1.nextLine();

        while (!(products.equals("buy") || products.equals("modify") || products.equals("delete") || products.equals("none"))) {
            System.out.println("\nInvalid input!");
        }

        if (products.equals("buy")) {
            buyProducts(index);
        }

        else if (products.equals("modify")) {
            changeInformation(index);
        }

        else if (products.equals("delete")) {
            deleteAccount(index);
        }

        else {
            System.out.println(accounts.get(index));
            accounts.get(index).printPurchaseHistory();
            System.out.println("\nThank you. See you soon.");
            setUp();
        }
    }

    public void buyProducts(int index) {
        System.out.println("\nThe available products and their costs are: ");
        String[] t = accounts.get(index).getTypes();
        double[] p = accounts.get(index).getPrices();
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i] + ": $" + p[i]);
        }

        System.out.println("Which section would you like to buy from?: ");
        String section = obj1.nextLine();

        while (!(isThere(section, t))) {
            System.out.println("\nThat section does not exist. Please enter a valid section.");
            System.out.println("Which section would you like to buy from?: ");
            section = obj1.nextLine();
        }

        System.out.println("How many items would you like to buy from the " + section + " section?: ");
        int num = obj2.nextInt();

        accounts.get(index).buyTypeProduct(section, num);

        System.out.println("Would you like to buy anymore products(yes or no)?: ");
        String answer = obj1.nextLine();

        while (!(answer.equals("yes") || answer.equals("no"))) {
            System.out.println("\nInvalid input!");
            System.out.println("Re enter if would you like to buy anymore products(yes or no)?: ");
            answer = obj1.nextLine();
        }

        if (answer.equals("yes")) {
            buyProducts(index);
        }

        else {
            System.out.println(accounts.get(index));
            accounts.get(index).printPurchaseHistory();
            System.out.println("\nThank you. See you soon.");
            setUp();
        }
    }

    public void changeInformation(int index) {
        System.out.println("\nThe following things you can change are: ");
        System.out.println("First name(firstName), Last name(lastName), Age(age), Username(username), Password(password), None(none)");
        System.out.println("\nWhat would you like to change?: ");
        String change = obj1.nextLine();

        while (!(change.equals("firstName") || change.equals("lastName") || change.equals("age")
                || change.equals("username") || change.equals("password") || change.equals("none"))) {
            System.out.println("\nInvalid Input!");
            System.out.println("\nThe following things you can change are: ");
            System.out.println("First name(firstName), Last name(lastName), Age(age), Username(username), Password(password), None(none)");
            System.out.println("\nRe enter what you would like to change: ");
            change = obj1.nextLine();
        }

        while (!(change.equals("none"))) {
            if (change.equals("firstName")) {
                System.out.println("Enter your new first name: ");
                accounts.get(index).changeFirstName(obj1.nextLine());
            }

            else if (change.equals("lastName")) {
                System.out.println("Enter your new last name: ");
                accounts.get(index).changeLastName(obj1.nextLine());
            }

            else if (change.equals("age")) {
                System.out.println("Enter your new age: ");
                accounts.get(index).changeAge(obj2.nextInt());
            }

            else if (change.equals("username")) {
                System.out.println("Enter your new username: ");
                accounts.get(index).changeUsername(obj1.nextLine());
            }

            else if (change.equals("password")) {
                System.out.println("Enter your new password: ");
                accounts.get(index).changePassword(obj1.nextLine());
            }

            System.out.println("\nHere are your current account details. Double check if everything looks right.");
            System.out.println(accounts.get(index));

            System.out.println("\nThe following things you can change are: ");
            System.out.println("First name(firstName), Last name(lastName), Age(age), Username(username), Password(password), None(none)");
            System.out.println("\nWhat would you like to change?: ");
            change = obj1.nextLine();
        }
        setUp();
    }

    public void deleteAccount(int index) {
        accounts.remove(index);
        System.out.println("\nYou have deleted your account.");
        setUp();
    }
}

/*
The class right below has many details(instance variables) that an account
would typically have. This class is for each member of the grocery store.
 */
class Member {

    public String[] types  = {"produce", "dairy", "frozen foods", "snacks"};
    public double[] prices = {1.09, 1.99, 1.99, 0.99};
    private String firstName;
    private String lastName;
    private int age;
    protected String status;
    private String username;
    private String password;
    private double spentMoney;
    protected double credit;
    private final String[][] purchaseHistory = new String[2][4];// 6. 2D Arrays

    public Member(String firstName, String lastName, int age, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = "Regular Membership";
        this.username = username;
        this.password = password;
        this.spentMoney = 0;
        this.credit = 500.00;
        purchaseHistory[0] = new String[]{"produce", "dairy", "frozen foods", "snacks"};
        purchaseHistory[1] = new String[]{"0", "0", "0", "0"};
    }

    public int getIndex(String str, String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void buyTypeProduct(String type, int num) {
        for (int i = 0; i < types.length; i++) {
            if (types[i].equals(type)) {
                if (credit < num * prices[i]) {
                    System.out.println("\nYou do not have enough credit to purchase " + num + " items in the "
                    + type + " section.");
                }

                else {
                    purchaseHistory[1][getIndex(type, types)] = Integer.toString(Integer.parseInt(purchaseHistory[1][getIndex(type, types)])+num);
                    spentMoney += num * prices[i];
                    credit -= num * prices[i];
                }
            }
        }
    }

    // 4. Accessors
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getTypes() {
        return types;
    }

    public double[] getPrices() {
        return prices;
    }

    // 5. Mutators
    public void changeFirstName(String firstName) {// 8. String manipulation
        this.firstName = firstName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }

    public void changeAge(int age) {
        this.age = age;
    }

    public void changeUsername(String username) {
        this.username = username;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void printPurchaseHistory() {
        for (int i = 0; i < purchaseHistory[0].length; i++) {
            if (Integer.parseInt(purchaseHistory[1][i]) == 1) {
                System.out.println(purchaseHistory[0][i] + ": " + purchaseHistory[1][i] + " item purchased");
            }

            else {
                System.out.println(purchaseHistory[0][i] + ": " + purchaseHistory[1][i] + " items purchased");
            }
        }
    }
    
    public String toString() {
        return "Account details: " + "\nFirst name: " + firstName + "\nLast name: " +
                lastName + "\nAge: " + age + "\nUsername: " + username + "\nPassword: " +
                password + "\nStatus: "+ status + "\nSpent money: $" + Math.floor(spentMoney*100)/100 +
                "\nCredit left: $" + Math.floor(credit*100)/100;
    }
}

/*
The class right below extends the Member class. It changes the statuses of the users' memberships
and the maximum credit anyone can have from $500.00 to $800.00.
 */
class SpecialMember extends Member {// 1. Inheritance
    public SpecialMember(String firstName, String lastName, int age, String username, String password) {
        super(firstName, lastName, age, username, password);

        // 3. Polymorphism
        status = "Special Membership";
        credit = 800.00;
    }
}
