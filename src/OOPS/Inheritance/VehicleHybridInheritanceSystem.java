/*
 This program demonstrates hybrid inheritance.
 PetrolVehicle extends Vehicle and implements Refuelable, while ElectricVehicle extends Vehicle.
*/

public class VehicleHybridInheritanceSystem {

    // Interface for refueling behavior
    interface Refuelable {
        void refuel();
    }

    // Superclass Vehicle
    static class Vehicle {
        int maxSpeed;
        String model;

        // Constructor to initialize vehicle details
        Vehicle(int maxSpeed, String model) {
            this.maxSpeed = maxSpeed;
            this.model = model;
        }

        // Method to display common vehicle info
        void displayInfo() {
            System.out.println("Model     : " + model);
            System.out.println("Max Speed : " + maxSpeed + " km/h");
        }
    }

    // ElectricVehicle subclass
    static class ElectricVehicle extends Vehicle {

        // Constructor
        ElectricVehicle(int maxSpeed, String model) {
            super(maxSpeed, model);
        }

        // Method specific to electric vehicles
        void charge() {
            System.out.println("Charging the electric vehicle.");
        }
    }

    // PetrolVehicle subclass implementing Refuelable
    static class PetrolVehicle extends Vehicle implements Refuelable {

        // Constructor
        PetrolVehicle(int maxSpeed, String model) {
            super(maxSpeed, model);
        }

        // Implementing refuel behavior
        @Override
        public void refuel() {
            System.out.println("Refueling the petrol vehicle.");
        }
    }

    public static void main(String[] args) {

        // Creating ElectricVehicle object
        ElectricVehicle ev = new ElectricVehicle(160, "Tesla Model 3");
        ev.displayInfo();
        ev.charge();

        System.out.println();

        // Creating PetrolVehicle object
        PetrolVehicle pv = new PetrolVehicle(180, "Honda City");
        pv.displayInfo();
        pv.refuel();
    }
}
