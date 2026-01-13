public class VehicleRegistrationManagementSystem {

    // Vehicle class
    static class Vehicle {

        // Static variable shared by all vehicles
        static double registrationFee = 2500.0;

        // Instance variables
        String ownerName;
        String vehicleType;

        // Final variable (cannot be changed once assigned)
        final String registrationNumber;

        // Constructor using 'this' keyword
        Vehicle(String ownerName, String vehicleType, String registrationNumber) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
            this.registrationNumber = registrationNumber;
        }

        // Method to display vehicle details
        void displayVehicleDetails() {
            System.out.println("Owner Name           : " + ownerName);
            System.out.println("Vehicle Type         : " + vehicleType);
            System.out.println("Registration Number  : " + registrationNumber);
            System.out.println("Registration Fee     : " + registrationFee);
        }

        // Static method to update registration fee
        static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
        }
    }

    public static void main(String[] args) {

        // Creating Vehicle objects
        Vehicle v1 = new Vehicle("Aryan", "Car", "KA01AB1234");
        Vehicle v2 = new Vehicle("Rahul", "Bike", "MH12XY5678");

        // Update registration fee using static method
        Vehicle.updateRegistrationFee(3000.0);

        // Using instanceof before displaying details
        if (v1 instanceof Vehicle) {
            System.out.println("Vehicle 1 Details:");
            v1.displayVehicleDetails();
        }

        System.out.println();

        if (v2 instanceof Vehicle) {
            System.out.println("Vehicle 2 Details:");
            v2.displayVehicleDetails();
        }
    }
}
