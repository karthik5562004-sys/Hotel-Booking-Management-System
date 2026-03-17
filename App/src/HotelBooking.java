import java.util.HashMap;
import java.util.Map;

// Room class (Domain Model)
class Room {
    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

// Centralized Inventory Manager
class RoomInventory {

    // Single source of truth
    private Map<String, Integer> availabilityMap;
    private Map<String, Room> roomDetails;

    // Constructor initializes inventory
    public RoomInventory() {
        availabilityMap = new HashMap<>();
        roomDetails = new HashMap<>();
    }

    // Register a room type with availability
    public void addRoom(Room room, int availableCount) {
        roomDetails.put(room.getType(), room);
        availabilityMap.put(room.getType(), availableCount);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return availabilityMap.getOrDefault(roomType, 0);
    }

    // Update availability (controlled update)
    public void updateAvailability(String roomType, int newCount) {
        if (availabilityMap.containsKey(roomType)) {
            availabilityMap.put(roomType, newCount);
        } else {
            System.out.println("Room type not found!");
        }
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("Hotel Room Inventory Status\n");

        for (String type : roomDetails.keySet()) {
            Room room = roomDetails.get(type);

            System.out.println(type + " Room:");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPrice());
            System.out.println("Available Rooms: " + getAvailability(type));
            System.out.println();
        }
    }
}

// Main Application
public class HotelBooking {

    public static void main(String[] args) {

        // Initialize Inventory
        RoomInventory inventory = new RoomInventory();

        // Create Room Types
        Room single = new Room("Single", 1, 250, 1500.0);
        Room doub = new Room("Double", 2, 400, 2500.0);
        Room suite = new Room("Suite", 3, 750, 5000.0);

        // Register Rooms with availability
        inventory.addRoom(single, 5);
        inventory.addRoom(doub, 3);
        inventory.addRoom(suite, 2);

        // Display current inventory
        inventory.displayInventory();
    }
}