/*
 This program demonstrates abstraction, interfaces, encapsulation, and polymorphism.
 Different vehicle types calculate ride fares differently in a ride-hailing application.
*/

import java.util.ArrayList;

public class RideHailingApplicationSystem {

    // Interface for GPS-related behavior
    interface GPS {
        String getCurrentLocation();
        void updateLocation(String newLocation);
    }

    // Abstract class Vehicle
    static abstract class Vehicle {

        // Encapsulated fields
        private String vehicleId;
        private String driverName;
        private double ratePerKm;

        // Constructor to initialize vehicle details
        Vehicle(String vehicleId, String driverName, double ratePerKm) {
            this.vehicleId = vehicleId;
            this.driverName = driverName;
            this.ratePerKm = ratePerKm;
        }

        // Getter methods (encapsulation)
        public String getVehicleId() {
            return vehicleId;
        }

        public String getDriverName() {
            return driverName;
        }

        public double getRatePerKm() {
            return ratePerKm;
        }

        // Abstract method to calculate fare
        abstract double calculateFare(double distance);

        // Concrete method to display vehicle details
        void getVehicleDetails() {
            System.out.println("Vehicle ID : " + vehicleId);
            System.out.println("Driver     : " + driverName);
            System.out.println("Rate/Km    : " + ratePerKm);
        }
    }

    // Car subclass
    static class Car extends Vehicle implements GPS {

        private String location;

        Car(String id, String driver, double rate, String location) {
            super(id, driver, rate);
            this.location = location;
        }

        // Fare calculation for car
        @Override
        double calculateFare(double distance) {
            return getRatePerKm() * distance + 50; // base charge
        }

        // GPS methods
        @Override
        public String getCurrentLocation() {
            return location;
        }

        @Override
        public void updateLocation(String newLocation) {
            this.location = newLocation;
        }
    }

    // Bike subclass
    static class Bike extends Vehicle implements GPS {

        private String location;

        Bike(String id, String driver, double rate, String location) {
            super(id, driver, rate);
            this.location = location;
        }

        // Fare calculation for bike
        @Override
        double calculateFare(double distance) {
            return getRatePerKm() * distance;
        }

        // GPS methods
        @Override
        public String getCurrentLocation() {
            return location;
        }

        @Override
        public void updateLocation(String newLocation) {
            this.location = newLocation;
        }
    }

    // Auto subclass
    static class Auto extends Vehicle implements GPS {

        private String location;

        Auto(String id, String driver, double rate, String location) {
            super(id, driver, rate);
            this.location = location;
        }

        // Fare calculation for auto
        @Override
        double calculateFare(double distance) {
            return (getRatePerKm() * distance) + 20; // service charge
        }

        // GPS methods
        @Override
        public String getCurrentLocation() {
            return location;
        }

        @Override
        public void updateLocation(String newLocation) {
            this.location = newLocation;
        }
    }

    // Polymorphic method to process rides
    static void calculateRideFare(ArrayList<Vehicle> vehicles, double distance) {

        for (Vehicle v : vehicles) {

            v.getVehicleDetails();
            System.out.println("Distance   : " + distance + " km");
            System.out.println("Fare       : " + v.calculateFare(distance));

            // GPS access using interface
            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                System.out.println("Location   : " + gps.getCurrentLocation());
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Creating vehicles list (polymorphism)
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", "Amit", 15, "MG Road"));
        vehicles.add(new Bike("BIKE202", "Rahul", 8, "BTM Layout"));
        vehicles.add(new Auto("AUTO303", "Suresh", 10, "Indiranagar"));

        // Calculating fares dynamically
        calculateRideFare(vehicles, 12.5);
    }
}
