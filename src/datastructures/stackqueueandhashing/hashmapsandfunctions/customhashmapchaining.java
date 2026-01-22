package hashmapsandfunctions;

/*
 This program implements a custom Hash Map using Separate Chaining.
 It supports basic operations: put (insert), get (retrieve), and remove (delete).
*/

public class customhashmapchaining {

    // Node class for linked list (key-value pair)
    static class Node {
        int key;
        String value;
        Node next;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Custom HashMap class
    static class MyHashMap {
        private final int SIZE = 10;          // size of hash table
        private Node[] table;                 // array of linked lists

        // Constructor
        MyHashMap() {
            table = new Node[SIZE];
        }

        // Hash function
        private int hash(int key) {
            return key % SIZE;
        }

        // Insert or update key-value pair
        void put(int key, String value) {
            int index = hash(key);
            Node head = table[index];

            // Check if key already exists
            while (head != null) {
                if (head.key == key) {
                    head.value = value; // update value
                    return;
                }
                head = head.next;
            }

            // Insert new node at beginning
            Node newNode = new Node(key, value);
            newNode.next = table[index];
            table[index] = newNode;
        }

        // Get value by key
        String get(int key) {
            int index = hash(key);
            Node head = table[index];

            while (head != null) {
                if (head.key == key) {
                    return head.value;
                }
                head = head.next;
            }
            return null; // key not found
        }

        // Remove key-value pair
        void remove(int key) {
            int index = hash(key);
            Node head = table[index];
            Node prev = null;

            while (head != null) {
                if (head.key == key) {
                    if (prev == null) {
                        table[index] = head.next;
                    } else {
                        prev.next = head.next;
                    }
                    return;
                }
                prev = head;
                head = head.next;
            }
        }

        // Display entire hash map
        void display() {
            for (int i = 0; i < SIZE; i++) {
                System.out.print("Index " + i + ": ");
                Node temp = table[i];
                while (temp != null) {
                    System.out.print("[" + temp.key + ", " + temp.value + "] -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        // Insert key-value pairs
        map.put(1, "Apple");
        map.put(11, "Banana"); // collision with key 1
        map.put(21, "Orange");
        map.put(2, "Mango");

        // Display map
        System.out.println("Hash Map Contents:");
        map.display();

        // Retrieve values
        System.out.println("Value for key 11: " + map.get(11));
        System.out.println("Value for key 2: " + map.get(2));

        // Remove a key
        map.remove(11);
        System.out.println("After removing key 11:");
        map.display();
    }
}
