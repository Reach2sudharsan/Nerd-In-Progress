import java.util.Currency;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        Car car1 = new Car("12345", "AA1234", new Date(), 100, Currency.getInstance("AUD"));
//
//        car1.SetRegistration("23456");
//        car1.SetDateOfRegistration(new Date());
//        car1.SetPurchasePrice(Currency.getInstance("USD"));
//        System.out.println(car1.GetVehicleID());
//        System.out.println(car1.GetRegistration());
//        System.out.println(car1.GetDateOfRegistration());
//        System.out.println(car1.GetEngineSize());
//        System.out.println(car1.GetPurchasePrice());

        Company company1 = new Company("AITech", "aitech@ai.com", new Date());
        company1.setDateOfLastContact(new Date());
        System.out.println(company1.getCompanyName());
        System.out.println(company1.getEmailAddress());
        System.out.println(company1.getDateOfLastContact());
    }
}

class Car {
    private String VehicleID;
    private String Registration;
    private Date DateOfRegistration;
    private int EngineSize;
    private Currency PurchasePrice;

    public Car(String VehicleID,String Registration,Date DateOfRegistration,
               int EngineSize,Currency PurchasePrice) {
        this.VehicleID = VehicleID;
        this.Registration = Registration;
        this.DateOfRegistration = DateOfRegistration;
        this.EngineSize = EngineSize;
        this.PurchasePrice = PurchasePrice;
    }

    public void SetPurchasePrice(Currency PurchasePrice) {
        this.PurchasePrice = PurchasePrice;
    }
    public void SetRegistration(String Registration) {
        this.Registration = Registration;
    }
    public void SetDateOfRegistration(Date DateOfRegistration) {
        this.DateOfRegistration = DateOfRegistration;
    }

    public String GetVehicleID() {
        return VehicleID;
    }

    public String GetRegistration() {
        return Registration;
    }

    public Date GetDateOfRegistration() {
        return DateOfRegistration;
    }

    public int GetEngineSize() {
        return EngineSize;
    }

    public Currency GetPurchasePrice() {
        return PurchasePrice;
    }

}

class Company {

    private final String companyName;
    private final String emailAddress;
    private Date dateOfLastContact;

    public Company(String companyName, String emailAddress, Date dateOfLastContact) {
        this.companyName = companyName;
        this.emailAddress = emailAddress;
        this.dateOfLastContact = dateOfLastContact;
    }

    public void setDateOfLastContact(Date dateOfLastContact) {
        this.dateOfLastContact = dateOfLastContact;
    }

    public String getCompanyName() {
        return companyName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public Date getDateOfLastContact() {
        return dateOfLastContact;
    }
}
