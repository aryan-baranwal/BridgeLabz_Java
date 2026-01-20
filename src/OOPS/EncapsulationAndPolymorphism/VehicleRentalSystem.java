/*
 This program demonstrates abstraction, interfaces, encapsulation, and polymorphism.
 Different vehicles calculate rental and insurance costs differently in a rental system.
*/

import java.util.ArrayList;

public class VehicleRentalSystem {

    // Interface for insurance-related behavior
    interface Insurable {
        double calculateInsurance(int days);
        String getInsuranceDetails();
    }

    // Abstract class Vehicle
    static abstract class Vehicle {

        // Encapsulated fields
        private String vehicleNumber;
        private String type;
        private double rentalRate; // per day

        // Constructor to initialize vehicle details
        Vehicle(String vehicleNumber, String type, double rentalRate) {
            this.vehicleNumber = vehicleNumber;
            this.type = type;
            this.rentalRate = rentalRate;
        }

        // Getter methods (encapsulation)
        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public String getType() {
            return type;
        }

        public double getRentalRate() {
            return rentalRate;
        }

        // Abstract method to calculate rental cost
        abstract double calculateRentalCost(int days);
    }

    // Car subclass
    static class Car extends Vehicle implements Insurable {

        // Private insurance policy number (encapsulated)
        private String insurancePolicyNumber;

        Car(String vehicleNumber, double rentalRate, String policyNumber) {
            super(vehicleNumber, "Car", rentalRate);
            this.insurancePolicyNumber = policyNumber;
        }

        // Rental cost calculation for car
        @Override
        double calculateRentalCost(int days) {
            return getRentalRate() * days;
        }

        // Insurance calculation for car
        @Override
        public double calculateInsurance(int days) {
            return 300 * days;
        }

        @Override
        public String getInsuranceDetails() {
            return "Car Insurance | Policy No: " + insurancePolicyNumber;
        }
    }

    // Bike subclass
    static class Bike extends Vehicle implements Insurable {

        private String insurancePolicyNumber;

        Bike(String vehicleNumber, double rentalRate, String policyNumber) {
            super(vehicleNumber, "Bike", rentalRate);
            this.insurancePolicyNumber = policyNumber;
        }

        // Rental cost calculation for bike
        @Override
        double calculateRentalCost(int days) {
            return getRentalRate() * days;
        }

        // Insurance calculation for bike
        @Override
        public double calculateInsurance(int days) {
            return 100 * days;
        }

        @Override
        public String getInsuranceDetails() {
            return "Bike Insurance | Policy No: " + insurancePolicyNumber;
        }
    }

    // Truck subclass
    static class Truck extends Vehicle implements Insurable {

        private String insurancePolicyNumber;

        Truck(String vehicleNumber, double rentalRate, String policyNumber) {
            super(vehicleNumber, "Truck", rentalRate);
            this.insurancePolicyNumber = policyNumber;
        }

        // Rental cost calculation for truck
        @Override
        double calculateRentalCost(int days) {
            return getRentalRate() * days + 500; // extra service charge
        }

        // Insurance calculation for truck
        @Override
        public double calculateInsurance(int days) {
            return 500 * days;
        }

        @Override
        public String getInsuranceDetails() {
            return "Truck Insurance | Policy No: " + insurancePolicyNumber;
        }
    }

    public static void main(String[] args) {

        // Creating list of vehicles (polymorphism)
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("KA01AB1234", 2000, "CAR-INS-101"));
        vehicles.add(new Bike("KA02XY5678", 800, "BIKE-INS-202"));
        vehicles.add(new Truck("KA03TR9999", 4000, "TRUCK-INS-303"));

        int rentalDays = 3;

        // Iterating over vehicles polymorphically
        for (Vehicle v : vehicles) {

            System.out.println("Vehicle Type   : " + v.getType());
            System.out.println("Vehicle Number : " + v.getVehicleNumber());
            System.out.println("Rental Cost    : " + v.calculateRentalCost(rentalDays));

            // Insurance details using interface
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Cost : " + ins.calculateInsurance(rentalDays));
            }

            System.out.println();
        }
    }
}
