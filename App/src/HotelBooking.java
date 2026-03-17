/**
 * ==========================================================
 * MAIN CLASS – UseCase2HotelBookingApp
 * ==========================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * This program demonstrates object modeling using
 * abstraction and inheritance for different room types.
 *
 * @version 2.1
 */

public class HotelBooking {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       Book My Stay App");
        System.out.println("   Hotel Booking System v2.1");
        System.out.println("=================================\n");

        // Create room objects (Polymorphism)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        System.out.println("----- Single Room -----");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailability + "\n");

        System.out.println("----- Double Room -----");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailability + "\n");

        System.out.println("----- Suite Room -----");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailability + "\n");

        System.out.println("Application terminated.");
    }
}


/**
 * ==========================================================
 * ABSTRACT CLASS – Room
 * ==========================================================
 *
 * Represents a generic hotel room.
 */
abstract class Room {

    /** Number of beds in the room */
    protected int numberOfBeds;

    /** Room size in square feet */
    protected int squareFeet;

    /** Price per night */
    protected double pricePerNight;

    /**
     * Constructor to initialize room attributes
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /** Display room details */
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Room Size: " + squareFeet + " sq ft");
        System.out.println("Price Per Night: ₹" + pricePerNight);
    }
}


/**
 * ==========================================================
 * CLASS – SingleRoom
 * ==========================================================
 */
class SingleRoom extends Room {

    /** Constructor */
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}


/**
 * ==========================================================
 * CLASS – DoubleRoom
 * ==========================================================
 */
class DoubleRoom extends Room {

    /** Constructor */
    public DoubleRoom() {
        super(2, 350, 2500.0);
    }
}


/**
 * ==========================================================
 * CLASS – SuiteRoom
 * ==========================================================
 */
class SuiteRoom extends Room {

    /** Constructor */
    public SuiteRoom() {
        super(3, 600, 5000.0);
    }
}