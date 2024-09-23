package hotel;

public class Suite extends Room{
    private boolean hasJacuzzi;

    // konstruktorn
    public Suite(String roomNr, int capacity, boolean hasJacuzzi, double pricePerNight) {
        super(roomNr, capacity, pricePerNight);
        this.hasJacuzzi = hasJacuzzi;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Suit with " + getRoomNr() + " nr and capacity of " + getCapacity() + " guests. Jacuzzi: " + (hasJacuzzi ? "Ja" : "Nej"));
    }
}
