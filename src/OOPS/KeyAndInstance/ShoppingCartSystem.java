public class ShoppingCartSystem {

    // Product class
    static class Product {

        // Static variable shared by all products
        static double discount = 10.0; // discount percentage

        // Instance variables
        String productName;
        double price;
        int quantity;

        // Final variable (cannot be changed once assigned)
        final int productID;

        // Constructor using 'this' keyword
        Product(int productID, String productName, double price, int quantity) {
            this.productID = productID;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        // Method to display product details
        void displayProductDetails() {
            double totalPrice = price * quantity;
            double discountedPrice = totalPrice - (totalPrice * discount / 100);

            System.out.println("Product ID     : " + productID);
            System.out.println("Product Name   : " + productName);
            System.out.println("Price          : " + price);
            System.out.println("Quantity       : " + quantity);
            System.out.println("Discount (%)   : " + discount);
            System.out.println("Total Price    : " + discountedPrice);
        }

        // Static method to update discount
        static void updateDiscount(double newDiscount) {
            discount = newDiscount;
        }
    }

    public static void main(String[] args) {

        // Creating Product objects
        Product p1 = new Product(1001, "Laptop", 60000, 1);
        Product p2 = new Product(1002, "Headphones", 3000, 2);

        // Update discount using static method
        Product.updateDiscount(15.0);

        // Using instanceof to validate object type
        if (p1 instanceof Product) {
            System.out.println("Product 1 Details:");
            p1.displayProductDetails();
        }

        System.out.println();

        if (p2 instanceof Product) {
            System.out.println("Product 2 Details:");
            p2.displayProductDetails();
        }
    }
}
