public class Task3 {
    public static void main(String[] args) {
        Borrower br = new Borrower("Bob", "Bob@java.com", 1234);
        System.out.println(br.GetBorrowerName());
        System.out.println(br.GetEmailAddress());
        System.out.println(br.GetBorrowerID());
        System.out.println(br.GetItemsOnLoan());
        br.UpdateItemsOnLoan(20);
        br.PrintDetails();
    }
}

class Borrower {
    private String BorrowerName;
    private String EmailAddress;
    private int BorrowerID;
    private int ItemsOnLoan;

    public Borrower(String BorrowerName, String EmailAddress, int BorrowerID) {
        this.BorrowerName = BorrowerName;
        this.EmailAddress = EmailAddress;
        this.BorrowerID = BorrowerID;
        this.ItemsOnLoan = 0;
    }

    public String GetBorrowerName() {
        return BorrowerName;
    }

    public String GetEmailAddress() {
        return EmailAddress;
    }

    public int GetBorrowerID() {
        return BorrowerID;
    }

    public int GetItemsOnLoan() {
        return ItemsOnLoan;
    }

    public void UpdateItemsOnLoan(int num) {
        ItemsOnLoan += num;
    }

    public void PrintDetails() {
        System.out.println("Borrower Name: " + BorrowerName);
        System.out.println("Email Address: " + EmailAddress);
        System.out.println("Borrower ID: " + BorrowerID);
        System.out.println("Items On Loan: " + ItemsOnLoan);
    }
}

