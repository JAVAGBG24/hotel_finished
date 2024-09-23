package hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // skapa ett objekt av Bookingservice så vi kan komma åt alla metoder
        BookingService bookingService = new BookingService();

        StandardRoom room1 = new StandardRoom("101", 2, true, 500.0);
        Suite suite1 = new Suite("201", 4, true, 1000.0);
        DeluxeRoom deluxeRoom = new DeluxeRoom("301", 3, true, 1500.00); // Deluxerum med balkong

        bookingService.addRoom(room1);
        bookingService.addRoom(suite1);
        bookingService.addRoom(deluxeRoom);

        // skapa kunder
        Customer customer1 = new Customer("John Doe", "0701234567");
        Customer customer2 = new Customer("Jane Smith", "0707654321");


        // skapa bokningsdatum för John Doe (mindre än 5 nätter, ingen rabatt)
        LocalDate checkInDate1 = LocalDate.of(2024, 10, 1);
        LocalDate checkOutDate1 = LocalDate.of(2024, 10, 5);

        System.out.println("---------------------");

        // Kontrollera om rum 101 är tillgängligt
        if (bookingService.isRoomAvailable(room1, checkInDate1, checkOutDate1)) {
            // Skapa en bokning för John Doe i rum 101
            Booking booking1 = new Booking(customer1, room1, checkInDate1, checkOutDate1);
            bookingService.addBooking(booking1);
            System.out.println("Booking created for " + customer1.getName() + " in room " + room1.getRoomNr());
        } else {
            System.out.println("Room " + room1.getRoomNr() + " is not available for those nights.");
        }

        System.out.println("---------------------");

        // skapa bokningsdatum för Jane Smith (fler än 5 nätter, rabatt tillämpas)
        LocalDate checkInDate2 = LocalDate.of(2024, 10, 10);
        LocalDate checkOutDate2 = LocalDate.of(2024, 10, 17);


        // Kontrollera om svit 201 är tillgänglig
        if (bookingService.isRoomAvailable(suite1, checkInDate2, checkOutDate2)) {
            // Skapa en bokning för Jane Smith i svit 201
            Booking booking2 = new Booking(customer2, suite1, checkInDate2, checkOutDate2);
            bookingService.addBooking(booking2);
            System.out.println("Booking created for " + customer2.getName() + " in room " + suite1.getRoomNr());
        }

        // visar alla bokningar
        System.out.println("\nAlla bokningar:");
        bookingService.displayAllBookings();

        /*System.out.println("Tillgängliga rum: ");
        bookingService.displayAvailableRooms();
        System.out.println("---------------------");*/

        // visa totalpris och genomför betalning för John Doe (ingen rabatt)
        System.out.println("\nTotal price and payment for :" + customer1.getName());
        Booking johnsBooking = bookingService.getBookings().get(0);  // hämta Johns bokning
        double totalPrice1 = johnsBooking.getTotalPrice();
        System.out.println("Total price for booking " + totalPrice1 + " SEK (no discount)");
        johnsBooking.makePayment();

        System.out.println("---------------------");

        System.out.println("\nTotal price and payment for " + customer2.getName());
        Booking janesBooking = bookingService.getBookings().get(1);  // hämta Janes bokning
        double totalPrice2 = janesBooking.getTotalPrice();
        System.out.println("Total price for booking: " + totalPrice2 + " SEK (including discount)");
        janesBooking.makePayment();

       /* System.out.println("Bokar rum 101:");
       bookingService.bookRoom("101");
        System.out.println("---------------------");*/

        /*System.out.println("Försöker boka rum 101 igen:");
        bookingService.bookRoom("101");
        System.out.println("---------------------");*/

        /*System.out.println("Avbokar rum 101");
        bookingService.cancelBooking("101");
        System.out.println("---------------------");

        System.out.println("Tillgängliga rum efter alla tester");
        bookingService.displayAvailableRooms();*/

    }
}













