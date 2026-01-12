public class MobilePhoneDetailsHandler {

    // MobilePhone class
    static class MobilePhone {

        // Attributes of MobilePhone
        String brand;
        String model;
        double price;

        // Constructor to initialize mobile phone details
        MobilePhone(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        // Method to display mobile phone details
        void displayDetails() {
            System.out.println("Mobile Brand : " + brand);
            System.out.println("Mobile Model : " + model);
            System.out.println("Price        : " + price);
        }
    }

    public static void main(String[] args) {

        // Creating a MobilePhone object
        MobilePhone phone = new MobilePhone("Samsung", "Galaxy S23", 74999);

        // Displaying mobile phone details
        phone.displayDetails();
    }
}
