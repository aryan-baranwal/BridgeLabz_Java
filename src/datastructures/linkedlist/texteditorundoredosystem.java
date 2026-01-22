/*
 This program implements Undo/Redo functionality for a text editor using a Doubly Linked List.
 Each node stores a text state, allowing navigation backward (undo) and forward (redo).
*/

public class texteditorundoredosystem {

    // Node class representing a text state
    static class Node {
        String content;
        Node prev;
        Node next;

        // Constructor to initialize text state
        Node(String content) {
            this.content = content;
            this.prev = null;
            this.next = null;
        }
    }

    // Doubly Linked List for Undo/Redo management
    static class TextEditor {
        Node head;
        Node tail;
        Node current;
        int size = 0;
        final int MAX_HISTORY = 10;

        // Add a new text state at the end
        void addState(String text) {
            Node newNode = new Node(text);

            // If list is empty
            if (head == null) {
                head = tail = current = newNode;
                size = 1;
                return;
            }

            // Remove forward history after undo
            if (current.next != null) {
                current.next.prev = null;
                current.next = null;
                tail = current;
            }

            // Add new state
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
            size++;

            // Limit history size
            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }

        // Undo operation
        void undo() {
            if (current != null && current.prev != null) {
                current = current.prev;
            } else {
                System.out.println("No more undo available");
            }
        }

        // Redo operation
        void redo() {
            if (current != null && current.next != null) {
                current = current.next;
            } else {
                System.out.println("No more redo available");
            }
        }

        // Display current text state
        void displayCurrentState() {
            if (current != null) {
                System.out.println("Current Text: " + current.content);
            } else {
                System.out.println("Editor is empty");
            }
        }
    }

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        // Adding text states
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");

        editor.displayCurrentState();

        // Undo operations
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // Redo operation
        editor.redo();
        editor.displayCurrentState();

        // Adding new state after undo clears redo history
        editor.addState("Hello Java");
        editor.displayCurrentState();

        // Attempt redo (should fail)
        editor.redo();
    }
}
