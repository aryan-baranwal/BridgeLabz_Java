public class CarRentalSystemDemo {

    // CarRental class
    static class CarRental {

        // Attributes of CarRental
        String customerName;
        String carModel;
        int rentalDays;
        double costPerDay;

        // Default constructor
        CarRental() {
            customerName = "Not Assigned";
            carModel = "Standard";
            rentalDays = 1;
            costPerDay = 1000.0;
        }

        // Parameterized constructor
        CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
            this.customerName = customerName;
            this.carModel = carModel;
            this.rentalDays = rentalDays;
            this.costPerDay = costPerDay;
        }

        // Method to calculate total rental cost
        double calculateTotalCost() {
            return rentalDays * costPerDay;
        }

        // Method to display rental details
        void displayRentalDetails() {
            System.out.println("Customer Name : " + customerName);
            System.out.println("Car Model     : " + carModel);
            System.out.println("Rental Days   : " + rentalDays);
            System.out.println("Cost per Day  : " + costPerDay);
            System.out.println("Total Cost   : " + calculateTotalCost());
        }
    }

    public static void main(String[] args) {

        // Using default constructor
        CarRental rental1 = new CarRental();
        System.out.println("Rental using Default Constructor:");
        rental1.displayRentalDetails();

        System.out.println();

        // Using parameterized constructor
        CarRental rental2 = new CarRental("Aryan", "Hyundai Creta", 5, 1800.0);
        System.out.println("Rental using Parameterized Constructor:");
        rental2.displayRentalDetails();
    }
}
