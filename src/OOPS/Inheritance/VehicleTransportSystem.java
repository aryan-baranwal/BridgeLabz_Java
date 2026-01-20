/*
 This program demonstrates inheritance and polymorphism.
 Vehicle is the superclass, and Car, Truck, Motorcycle are subclasses.
*/

public class VehicleTransportSystem {

    // Superclass Vehicle
    static class Vehicle {
        int maxSpeed;
        String fuelType;

        // Constructor to initialize vehicle details
        Vehicle(int maxSpeed, String fuelType) {
            this.maxSpeed = maxSpeed;
            this.fuelType = fuelType;
        }

        // Method to display vehicle information
        void displayInfo() {
            System.out.println("Max Speed : " + maxSpeed + " km/h");
            System.out.println("Fuel Type : " + fuelType);
        }
    }

    // Car subclass
    static class Car extends Vehicle {
        int seatCapacity;

        // Constructor
        Car(int maxSpeed, String fuelType, int seatCapacity) {
            super(maxSpeed, fuelType);
            this.seatCapacity = seatCapacity;
        }

        // Overriding displayInfo()
        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Seat Capacity : " + seatCapacity);
        }
    }

    // Truck subclass
    static class Truck extends Vehicle {
        double loadCapacity; // in tons

        // Constructor
        Truck(int maxSpeed, String fuelType, double loadCapacity) {
            super(maxSpeed, fuelType);
            this.loadCapacity = loadCapacity;
        }

        // Overriding displayInfo()
        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Load Capacity : " + loadCapacity + " tons");
        }
    }

    // Motorcycle subclass
    static class Motorcycle extends Vehicle {
        boolean hasCarrier;

        // Constructor
        Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
            super(maxSpeed, fuelType);
            this.hasCarrier = hasCarrier;
        }

        // Overriding displayInfo()
        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Carrier Available : " + hasCarrier);
        }
    }

    public static void main(String[] args) {

        // Array of Vehicle type (polymorphism)
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        // Calling overridden methods dynamically
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
