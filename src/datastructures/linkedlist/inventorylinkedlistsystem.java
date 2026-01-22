/*
 This program implements a Singly Linked List for an Inventory Management System.
 It supports insert, delete, search, update, sorting, and total inventory value calculation.
*/

public class inventorylinkedlistsystem {

    // Node class representing an inventory item
    static class Node {
        int itemId;
        String itemName;
        int quantity;
        double price;
        Node next;

        // Constructor to initialize item details
        Node(int itemId, String itemName, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    // Singly Linked List for Inventory
    static class InventoryList {
        Node head;

        // Add item at beginning
        void addAtBeginning(int id, String name, int qty, double price) {
            Node newNode = new Node(id, name, qty, price);
            newNode.next = head;
            head = newNode;
        }

        // Add item at end
        void addAtEnd(int id, String name, int qty, double price) {
            Node newNode = new Node(id, name, qty, price);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Add item at specific position (1-based)
        void addAtPosition(int pos, int id, String name, int qty, double price) {
            if (pos == 1) {
                addAtBeginning(id, name, qty, price);
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }

            Node newNode = new Node(id, name, qty, price);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Remove item by Item ID
        void removeById(int id) {
            if (head == null) {
                System.out.println("Inventory is empty");
                return;
            }

            if (head.itemId == id) {
                head = head.next;
                System.out.println("Item removed");
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.itemId != id) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Item not found");
            } else {
                temp.next = temp.next.next;
                System.out.println("Item removed");
            }
        }

        // Update quantity by Item ID
        void updateQuantity(int id, int newQty) {
            Node temp = head;

            while (temp != null) {
                if (temp.itemId == id) {
                    temp.quantity = newQty;
                    System.out.println("Quantity updated");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Item not found");
        }

        // Search item by ID
        void searchById(int id) {
            Node temp = head;

            while (temp != null) {
                if (temp.itemId == id) {
                    displayItem(temp);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Item not found");
        }

        // Search item by Name
        void searchByName(String name) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.itemName.equalsIgnoreCase(name)) {
                    displayItem(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Item not found");
            }
        }

        // Calculate total inventory value
        void calculateTotalValue() {
            Node temp = head;
            double total = 0;

            while (temp != null) {
                total += temp.price * temp.quantity;
                temp = temp.next;
            }

            System.out.println("Total Inventory Value: " + total);
        }

        // Sort inventory by item name (ascending)
        void sortByName() {
            head = mergeSortByName(head);
        }

        // Sort inventory by price (ascending)
        void sortByPrice() {
            head = mergeSortByPrice(head);
        }

        // Merge sort by name
        Node mergeSortByName(Node node) {
            if (node == null || node.next == null)
                return node;

            Node mid = getMiddle(node);
            Node nextMid = mid.next;
            mid.next = null;

            Node left = mergeSortByName(node);
            Node right = mergeSortByName(nextMid);

            return mergeByName(left, right);
        }

        // Merge sort by price
        Node mergeSortByPrice(Node node) {
            if (node == null || node.next == null)
                return node;

            Node mid = getMiddle(node);
            Node nextMid = mid.next;
            mid.next = null;

            Node left = mergeSortByPrice(node);
            Node right = mergeSortByPrice(nextMid);

            return mergeByPrice(left, right);
        }

        // Merge by name
        Node mergeByName(Node a, Node b) {
            if (a == null) return b;
            if (b == null) return a;

            if (a.itemName.compareToIgnoreCase(b.itemName) <= 0) {
                a.next = mergeByName(a.next, b);
                return a;
            } else {
                b.next = mergeByName(a, b.next);
                return b;
            }
        }

        // Merge by price
        Node mergeByPrice(Node a, Node b) {
            if (a == null) return b;
            if (b == null) return a;

            if (a.price <= b.price) {
                a.next = mergeByPrice(a.next, b);
                return a;
            } else {
                b.next = mergeByPrice(a, b.next);
                return b;
            }
        }

        // Get middle of linked list
        Node getMiddle(Node node) {
            if (node == null) return node;

            Node slow = node, fast = node.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // Display all inventory items
        void displayAll() {
            if (head == null) {
                System.out.println("Inventory is empty");
                return;
            }

            Node temp = head;
            while (temp != null) {
                displayItem(temp);
                temp = temp.next;
            }
        }

        // Helper method to display single item
        void displayItem(Node node) {
            System.out.println("Item ID   : " + node.itemId);
            System.out.println("Item Name : " + node.itemName);
            System.out.println("Quantity  : " + node.quantity);
            System.out.println("Price     : " + node.price);
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {

        InventoryList inventory = new InventoryList();

        // Adding items
        inventory.addAtBeginning(1, "Laptop", 5, 60000);
        inventory.addAtEnd(2, "Mouse", 20, 800);
        inventory.addAtEnd(3, "Keyboard", 15, 1500);
        inventory.addAtPosition(2, 4, "Monitor", 7, 12000);

        // Display inventory
        inventory.displayAll();

        // Search operations
        inventory.searchById(2);
        inventory.searchByName("Keyboard");

        // Update quantity
        inventory.updateQuantity(1, 8);

        // Calculate total value
        inventory.calculateTotalValue();

        // Sort by name
        inventory.sortByName();
        System.out.println("Sorted by Item Name:");
        inventory.displayAll();

        // Sort by price
        inventory.sortByPrice();
        System.out.println("Sorted by Price:");
        inventory.displayAll();
    }
}
