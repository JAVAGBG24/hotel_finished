package hotel;

public class Customer {
    private String name;
    private String phoneNumber;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // endast getters, om vi nu måste ändra namn och telnummer
    // så skulle vi istället gjort en update funktion istället
    // för setters som kan ändra värdet egentligen när som helst

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // enkel metod för att visa infon om en Customer
    public void displayCustomerDetails() {
        System.out.println("Customer: " + name + ", Phone number: " + phoneNumber);
    }

}
