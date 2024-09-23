package hotel;

public class DeluxeRoom extends Room {
    // skapat en ny typ av Room, samma princip som tidigare men
    // andra egenskaper

    private boolean hasBalcony;

    public DeluxeRoom(String roomNumber, int capacity, boolean hasBalcony, double pricePerNight) {
        super(roomNumber, capacity, pricePerNight);  // Anropar basklassens konstruktor
        this.hasBalcony = hasBalcony;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Deluxe roome with capacity " + getCapacity() + " guests. Balcony: " + (hasBalcony ? "Yes" : "No"));
    }
}