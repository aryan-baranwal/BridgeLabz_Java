public class ShoppingCartSimulator {

    // CartItem class
    static class CartItem {

        // Attributes of CartItem
        String itemName;
        double price;
        int quantity;

        // Constructor to initialize cart item
        CartItem(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = 0;
        }

        // Method to add item to the cart
        void addItem(int qty) {
            if (qty > 0) {
                quantity += qty;
                System.out.println(qty + " item(s) added to cart.");
            } else {
                System.out.println("Invalid quantity.");
            }
        }

        // Method to remove item from the cart
        void removeItem(int qty) {
            if (qty > 0 && qty <= quantity) {
                quantity -= qty;
                System.out.println(qty + " item(s) removed from cart.");
            } else {
                System.out.println("Invalid quantity or not enough items.");
            }
        }

        // Method to display total cost
        void displayTotalCost() {
            double totalCost = price * quantity;
            System.out.println("Item Name : " + itemName);
            System.out.println("Price     : " + price);
            System.out.println("Quantity  : " + quantity);
            System.out.println("Total Cost: " + totalCost);
        }
    }

    public static void main(String[] args) {

        // Creating a CartItem object
        CartItem cartItem = new CartItem("Notebook", 50.0);

        // Adding items to cart
        cartItem.addItem(3);

        // Removing items from cart
        cartItem.removeItem(1);

        // Display total cost
        cartItem.displayTotalCost();
    }
}
