public class InventoryTracker {

    // Item class
    static class Item {

        // Attributes of Item
        int itemCode;
        String itemName;
        double price;

        // Constructor to initialize item details
        Item(int itemCode, String itemName, double price) {
            this.itemCode = itemCode;
            this.itemName = itemName;
            this.price = price;
        }

        // Method to calculate total cost for given quantity
        double calculateTotalCost(int quantity) {
            return price * quantity;
        }

        // Method to display item details
        void displayDetails(int quantity) {
            System.out.println("Item Code   : " + itemCode);
            System.out.println("Item Name   : " + itemName);
            System.out.println("Price       : " + price);
            System.out.println("Quantity    : " + quantity);
            System.out.println("Total Cost  : " + calculateTotalCost(quantity));
        }
    }

    public static void main(String[] args) {

        // Creating an Item object
        Item item = new Item(1001, "Pen", 10.5);

        // Quantity of item
        int quantity = 20;

        // Display item details and total cost
        item.displayDetails(quantity);
    }
}
