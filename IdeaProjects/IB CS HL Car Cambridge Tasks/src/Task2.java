import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static ArrayList<LibraryItem> items = new ArrayList<LibraryItem>();

    public static void main(String[] args) {
//        Book i1 = new Book("Science", "Bob", 1234, true, new Date(), "Percy",
//                "Percy@java.com", 1467, true);
//        System.out.println(i1.GetTitle());
//        System.out.println(i1.GetAuthor_Artist());
//        System.out.println(i1.GetItemID());
//        System.out.println(i1.GetOnLoan());
//        System.out.println(i1.GetDueDate());
//        i1.Borrowing();
//        i1.Returning();
//        System.out.println(i1.GetIsRequested());
//        i1.SetIsRequested(true);
//        i1.PrintDetails();
//
//        System.out.println();
//
//        CD i2 = new CD("Electrons", "Bill", 5678, true, new Date(), "Henry",
//                "Henry@java.com", 2349, "Physics");
//        System.out.println(i2.GetTitle());
//        System.out.println(i2.GetAuthor_Artist());
//        System.out.println(i2.GetItemID());
//        System.out.println(i2.GetOnLoan());
//        System.out.println(i2.GetDueDate());
//        i2.Borrowing();
//        i2.Returning();
//        System.out.println(i2.GetGenre());
//        i2.SetGenre("Chemistry");
//        i2.PrintDetails();
        menu();
    }

    public static void menu() {
        Scanner obj = new Scanner(System.in);

        System.out.println("1 - Add a new borrower");
        System.out.println("2 - Add a new book");
        System.out.println("3 - Add a new CD");
        System.out.println("4 - Borrow a book");
        System.out.println("5 - Return a book");
        System.out.println("6 - Borrow a CD");
        System.out.println("7 - Return a CD");
        System.out.println("8 - Request book");
        System.out.println("9 - Print all details");
        System.out.println("99 - Exit program");

        System.out.println("Enter your menu choice");
        int choice = obj.nextInt();

        if (choice == 1) {
            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            System.out.println("Enter Borrower name: ");
            String BorrowerName = obj.next();

            System.out.println("Enter Email address: ");
            String EmailAddress = obj.next();

            System.out.println("Enter Borrower ID: ");
            int BorrowerID = obj.nextInt();

            boolean itemFound = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass().getName().equals("Book") && items.get(i).GetItemID() == ItemID) {
                    items.get(i).br = new Borrower(BorrowerName, EmailAddress, BorrowerID);
                    itemFound = true;
                }
            }
        }

        else if (choice == 2) {
            System.out.println("Enter Title: ");
            String Title = obj.next();

            System.out.println("Enter Author_Artist: ");
            String Author_Artist = obj.next();

            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            System.out.println("Enter if on loan (true/false): ");
            boolean OnLoan = obj.nextBoolean();

            System.out.println("Enter Borrower name: ");
            String BorrowerName = obj.next();

            System.out.println("Enter Email address: ");
            String EmailAddress = obj.next();

            System.out.println("Enter Borrower ID: ");
            int BorrowerID = obj.nextInt();

            System.out.println("Enter if item is requested (true/false): ");
            boolean IsRequested = obj.nextBoolean();

            items.add(new Book(Title, Author_Artist, ItemID, OnLoan, new Date(), BorrowerName, EmailAddress, BorrowerID, IsRequested));
        }

        else if (choice == 3) {
            System.out.println("Enter Title: ");
            String Title = obj.next();

            System.out.println("Enter Author_Artist: ");
            String Author_Artist = obj.next();

            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            System.out.println("Enter if on loan (true/false): ");
            boolean OnLoan = obj.nextBoolean();

            System.out.println("Enter Borrower name: ");
            String BorrowerName = obj.next();

            System.out.println("Enter Email address: ");
            String EmailAddress = obj.next();

            System.out.println("Enter Borrower ID: ");
            int BorrowerID = obj.nextInt();

            System.out.println("Enter Genre: ");
            String Genre = obj.next();

            items.add(new CD(Title, Author_Artist, ItemID, OnLoan, new Date(), BorrowerName, EmailAddress, BorrowerID, Genre));
        }

        else if (choice == 4) {
            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            boolean itemFound = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass().getName().equals("Book") && items.get(i).GetItemID() == ItemID) {
                    items.get(i).Borrowing();
                    itemFound = true;
                }
            }

            if (!(itemFound)) {
                System.out.println("Book not found.");
            }
        }

        else if (choice == 5) {
            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            boolean itemFound = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass().getName().equals("Book") && items.get(i).GetItemID() == ItemID) {
                    items.get(i).Returning();
                    itemFound = true;
                }
            }

            if (!(itemFound)) {
                System.out.println("Book not found.");
            }
        }

        else if (choice == 6) {
            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            boolean itemFound = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass().getName().equals("CD") && items.get(i).GetItemID() == ItemID) {
                    items.get(i).Borrowing();
                    itemFound = true;
                }
            }

            if (!(itemFound)) {
                System.out.println("CD not found.");
            }
        }

        else if (choice == 7) {
            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            boolean itemFound = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass().getName().equals("CD") && items.get(i).GetItemID() == ItemID) {
                    items.get(i).Returning();
                    itemFound = true;
                }
            }

            if (!(itemFound)) {
                System.out.println("CD not found.");
            }
        }

        else if (choice == 8) {
            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            boolean itemFound = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass().getName().equals("Book") && items.get(i).GetItemID() == ItemID) {
                    ((Book)items.get(i)).RequestBook(((Book)items.get(i)).GetRequestedBy());
                    itemFound = true;
                }
            }

            if (!(itemFound)) {
                System.out.println("Book not found.");
            }
        }

        else if (choice == 9) {
            System.out.println("Enter item ID: ");
            int ItemID = obj.nextInt();

            boolean itemFound = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass().getName().equals("Book") && items.get(i).GetItemID() == ItemID) {
                    items.get(i).PrintDetails();
                    itemFound = true;
                }
            }

            if (!(itemFound)) {
                System.out.println("Book not found.");
            }
        }

        else if (choice == 99) {
            System.out.println("You have exited the program. See you later!");
        }
    }
}

class LibraryItem {
    protected String Title;
    protected String Author_Artist;
    protected int ItemID;
    protected boolean OnLoan;
    protected Date DueDate;
    protected int BorrowerID;
    protected Borrower br;

    public LibraryItem(String Title, String Author_Artist, int ItemID, boolean OnLoan,
                       Date DueDate, String BorrowerName, String EmailAddress, int BorrowerID) {
        this.Title = Title;
        this.Author_Artist = Author_Artist;
        this.ItemID = ItemID;
        this.OnLoan = OnLoan;
        this.DueDate = DueDate;
        this.BorrowerID = BorrowerID;
        this.br = new Borrower(BorrowerName, EmailAddress, BorrowerID);
    }

    public String GetTitle() {
        return Title;
    }

    public String GetAuthor_Artist() {
        return Author_Artist;
    }

    public int GetItemID() {
        return ItemID;
    }

    public boolean GetOnLoan() {
        return OnLoan;
    }

    public Date GetDueDate() {
        return DueDate;
    }

    public void Borrowing() {
        long time = DueDate.getTime()+21;
        OnLoan = true;
        BorrowerID = br.GetBorrowerID();
        br.UpdateItemsOnLoan(1);
        DueDate = new Date(time);
    }

    public void Returning() {
        OnLoan = false;
        BorrowerID = 0;
        br.UpdateItemsOnLoan(-1);
    }

    public void PrintDetails() {
        System.out.println(Title + " " + Author_Artist);
        System.out.println(ItemID + " " + OnLoan + " " + DueDate);
        br.PrintDetails();
    }
}

class Book extends LibraryItem {
    private boolean IsRequested;
    private String RequestedBy;

    public Book(String Title, String Author_Artist, int ItemID, boolean OnLoan,
                Date DueDate,  String BorrowerName, String EmailAddress, int BorrowerID, boolean IsRequested) {
        super(Title, Author_Artist,ItemID, OnLoan, DueDate, BorrowerName, EmailAddress, BorrowerID);
        this.IsRequested = IsRequested;
        this.RequestedBy = BorrowerName;
    }

    public boolean GetIsRequested() {
        return IsRequested;
    }

    public String GetRequestedBy() {
        return RequestedBy;
    }

    public void SetIsRequested(boolean isRequested) {
        this.IsRequested = isRequested;
    }

    public void RequestBook(String RequestedBy) {
        this.RequestedBy = RequestedBy;
        SetIsRequested(true);
    }

    public void PrintDetails() {
        System.out.println(Title + " " + Author_Artist);
        System.out.println(ItemID + " " + OnLoan + " " + DueDate);
        System.out.println(IsRequested);
        br.PrintDetails();
        System.out.println(RequestedBy);
    }
}

class CD extends LibraryItem {
    private String Genre;

    public CD(String Title, String Author_Artist, int ItemID, boolean OnLoan,
                Date DueDate, String BorrowerName, String EmailAddress, int BorrowerID, String Genre) {
        super(Title, Author_Artist,ItemID, OnLoan, DueDate, BorrowerName, EmailAddress, BorrowerID);
        this.Genre = Genre;
    }

    public String GetGenre() {
        return Genre;
    }

    public void SetGenre(String Genre) {
        this.Genre = Genre;
    }

    public void PrintDetails() {
        System.out.println(Title + " " + Author_Artist);
        System.out.println(ItemID + " " + OnLoan + " " + DueDate);
        br.PrintDetails();
        System.out.println(Genre);
    }
}
