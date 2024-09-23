package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    // lista med alla rum
    private List<Room> rooms = new ArrayList<>();
    // vi behöver också en lista med alla Bookings
    private List<Booking> bookings = new ArrayList<>();

    // metod för att lägga till ett rum i listan
    public void addRoom(Room room) {
        rooms.add(room);
        // lagt till ett room i arrayList
        System.out.println("Room " + room.getRoomNr() + " has been added to the system.");
    }

    // ny metod
    public void addBooking(Booking booking) {
        bookings.add(booking);
        System.out.println("Booking created for " + booking.getRoomNumber());
    }

    // den här behöver vi inte just nu för att vi kallar på
    // room.book() inne i konstruktorn för Booking
    // alltså sker bokningen direkt vid skapandet av en Booking

    // metod för att boka ett rum baserat rumsnummer
    /*public void bookRoom(String roomNr) {
        Room room = findRoom(roomNr);
        if (room != null) {
            room.bookRoom();
        } else {
            System.out.println("Room with " + roomNr + " was not found.");
        }
    }*/

    // getter för att hämta alla bokningar
    public List<Booking> getBookings() {
        return bookings;
    }

    // metod för att avboka ett rum baserat på rumsnummer
    public void cancelBooking(String roomNr) {
        Room room = findRoom(roomNr);
        if (room != null) {
            room.cancelBooking();
        } else {
            System.out.println("Room with " + roomNr + " was not found.");
        }
    }

    // metod för att visa alla tillgängliga rum
    public void displayAvailableRooms() {
        for (Room room : rooms) {
            // för varje room av typen Room i vår ArraList rooms
            // gör följande:
            room.displayRoomDetails();
            System.out.println();
        }
    }

    public void displayAllBookings() {
        for (Booking booking : bookings) {
            booking.displayBookingDetails();
        }
    }

    // kontrollera tillgänglighet för ett rum baserat på datum
    public boolean isRoomAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        for (Booking booking : bookings) {
            if (booking.getRoomNumber().equals(room.getRoomNr())) {
                // kontrollera om datumen överlappar med redan existerande bokningar
                if (!room.isAvailable(checkInDate, checkOutDate, booking.getCheckInDate(), booking.getCheckOutDate())) {
                    // i så fall är rummet inte tillgängligt
                    return false;
                }
            }
        }
        // annars är det tillgängligt
        return true;
    }

    // hitta ett rum baserat på rumsnummer, metoden ska vara privat se det som en hjälpmetod för servicen
    private Room findRoom(String roomNr) {
        for (Room room : rooms) {
            if(room.getRoomNr().equals(roomNr)){
                return room;
            }
        }
        return null;
    }
}
























