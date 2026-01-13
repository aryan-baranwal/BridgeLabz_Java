public class HotelBookingConstructorDemo {

    // HotelBooking class
    static class HotelBooking {

        // Attributes of HotelBooking
        String guestName;
        String roomType;
        int nights;

        // Default constructor
        HotelBooking() {
            guestName = "Not Assigned";
            roomType = "Standard";
            nights = 1;
        }

        // Parameterized constructor
        HotelBooking(String guestName, String roomType, int nights) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
        }

        // Copy constructor
        HotelBooking(HotelBooking other) {
            this.guestName = other.guestName;
            this.roomType = other.roomType;
            this.nights = other.nights;
        }

        // Method to display booking details
        void displayBookingDetails() {
            System.out.println("Guest Name : " + guestName);
            System.out.println("Room Type  : " + roomType);
            System.out.println("Nights     : " + nights);
        }
    }

    public static void main(String[] args) {

        // Booking using default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Booking using Default Constructor:");
        booking1.displayBookingDetails();

        System.out.println();

        // Booking using parameterized constructor
        HotelBooking booking2 = new HotelBooking("Aryan", "Deluxe", 3);
        System.out.println("Booking using Parameterized Constructor:");
        booking2.displayBookingDetails();

        System.out.println();

        // Booking using copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Booking using Copy Constructor:");
        booking3.displayBookingDetails();
    }
}
