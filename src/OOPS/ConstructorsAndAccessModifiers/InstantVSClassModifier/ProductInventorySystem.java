public class ProductInventorySystem {

    // Product class
    static class Product {

        // Instance variables
        String productName;
        double price;

        // Class variable (shared among all objects)
        static int totalProducts = 0;

        // Constructor to initialize product details
        Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
            totalProducts++; // Increment count whenever a product is created
        }

        // Instance method to display product details
        void displayProductDetails() {
            System.out.println("Product Name : " + productName);
            System.out.println("Price        : " + price);
        }

        // Class method to display total products
        static void displayTotalProducts() {
            System.out.println("Total Products Created: " + totalProducts);
        }
    }

    public static void main(String[] args) {

        // Creating Product objects
        Product p1 = new Product("Laptop", 65000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1500);

        // Display product details
        System.out.println("Product 1 Details:");
        p1.displayProductDetails();

        System.out.println("\nProduct 2 Details:");
        p2.displayProductDetails();

        System.out.println("\nProduct 3 Details:");
        p3.displayProductDetails();

        System.out.println();

        // Display total number of products
        Product.displayTotalProducts();
    }
}
