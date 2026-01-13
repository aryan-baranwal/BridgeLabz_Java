public class VehicleRegistrationSystem {

    // Vehicle class
    static class Vehicle {

        // Instance variables
        String ownerName;
        String vehicleType;

        // Class variable (shared by all vehicles)
        static double registrationFee = 1500.0;

        // Constructor to initialize vehicle details
        Vehicle(String ownerName, String vehicleType) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }

        // Instance method to display vehicle details
        void displayVehicleDetails() {
            System.out.println("Owner Name        : " + ownerName);
            System.out.println("Vehicle Type      : " + vehicleType);
            System.out.println("Registration Fee  : " + registrationFee);
        }

        // Class method to update registration fee
        static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
        }
    }

    public static void main(String[] args) {

        // Creating Vehicle objects
        Vehicle v1 = new Vehicle("Aryan", "Car");
        Vehicle v2 = new Vehicle("Rahul", "Bike");

        // Display details before fee update
        System.out.println("Before Updating Registration Fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        // Update registration fee
        Vehicle.updateRegistrationFee(2000.0);

        System.out.println("\nAfter Updating Registration Fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
