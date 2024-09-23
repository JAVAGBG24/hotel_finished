package hotel;

import java.time.LocalDate;

public class Booking {
    // ny klass som vi introducerat som ska representera en bokning
    // en bokning har en Customer (den som bokar), ett rum (som blir bokat)
    // ett datum för in check och ett för utcheck samt en boolean som kollar
    // om bokningen är betald.

    private Customer customer;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isPaid;


    public Booking(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        // rummet är inte fullt betalt vid bokning
        this.isPaid = false;
        // själva bokningen sker direkt vid skapandet av en Booking
        // så att ingen annan ska kunna boka samma rum
        // eftersom vi har ett fält med private Room room kommer vi åt
        // alla metoder som finns i Room även i den här klassen
        this.room.bookRoom();
    }

   // här är vi intresserade av specifikt roomNr på ett rum
   // vi hämtar det genom Room, för det är Room som har
    // egenskapen roomNr
    public String getRoomNumber() {
       return room.getRoomNr();
   }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    // getter för antalet nätter
    public int getNights() {
        return checkOutDate.getDayOfYear() - checkInDate.getDayOfYear();
    }

    // räkna ut totala priset för bokningen
    // här hanteras också rabatter vilket kan vara helt ok om
    // vi bara en typ av rabatt... växer det och vi skulle vilja ha
    // flera olika rabtter då är det inte så bra att utöka den här metoden
    // utan då är det bättre att bryta ut i kanske en klass som hanterar
    // enbart olika rabatter
    public double getTotalPrice() {
        double totalPrice = room.calculatePricePerNight(getNights());
        // ge rabatt om bokningen överstiger 5 nätter
        if (getNights() > 5) {
            totalPrice *= 0.9; // 10% rabatt
        }
        return totalPrice;
    }

    // det går även att override toString(), det kan ni göra genom
    // högerklick => generate => toString() blir dock inte lika "snygg" utskrift
    // men går såklart att göra om
    public void displayBookingDetails() {
        System.out.println("Room: " + room.getRoomNr() +
                ", Customer: " + customer.getName() +
                ", Check in: " + checkInDate +
                ", Check out: " + checkOutDate);
    }

    // genomför en betalning för bokningen
    // isPaid ändras till true från false om isPaid var failse från början
    public void makePayment() {
        if (!isPaid) {
            isPaid = true;
            System.out.println("Successful payment made for room " + room.getRoomNr());
        } else {
            System.out.println("Payment is already done.");
        }
    }
}
