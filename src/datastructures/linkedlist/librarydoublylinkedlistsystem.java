/*
 This program implements a Doubly Linked List for a Library Management System.
 It supports insertion, deletion, searching, updating, counting, and bidirectional traversal.
*/

public class librarydoublylinkedlistsystem {

    // Node class representing a Book
    static class Node {
        int bookId;
        String title;
        String author;
        String genre;
        boolean isAvailable;
        Node prev;
        Node next;

        // Constructor to initialize book details
        Node(int bookId, String title, String author, String genre, boolean isAvailable) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.isAvailable = isAvailable;
            this.prev = null;
            this.next = null;
        }
    }

    // Doubly Linked List class
    static class LibraryList {
        Node head;
        Node tail;

        // Add book at beginning
        void addAtBeginning(int id, String title, String author, String genre, boolean available) {
            Node newNode = new Node(id, title, author, genre, available);

            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        // Add book at end
        void addAtEnd(int id, String title, String author, String genre, boolean available) {
            Node newNode = new Node(id, title, author, genre, available);

            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        // Add book at specific position (1-based)
        void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
            if (pos == 1) {
                addAtBeginning(id, title, author, genre, available);
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null || temp.next == null) {
                addAtEnd(id, title, author, genre, available);
                return;
            }

            Node newNode = new Node(id, title, author, genre, available);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }

        // Remove book by Book ID
        void removeByBookId(int id) {
            if (head == null) {
                System.out.println("Library is empty");
                return;
            }

            Node temp = head;

            while (temp != null && temp.bookId != id) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Book not found");
                return;
            }

            if (temp == head) {
                head = head.next;
                if (head != null) head.prev = null;
            } else if (temp == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }

            System.out.println("Book removed successfully");
        }

        // Search book by title
        void searchByTitle(String title) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {
                    displayBook(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Book not found");
            }
        }

        // Search book by author
        void searchByAuthor(String author) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.author.equalsIgnoreCase(author)) {
                    displayBook(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("No books found for author: " + author);
            }
        }

        // Update availability status by Book ID
        void updateAvailability(int id, boolean status) {
            Node temp = head;

            while (temp != null) {
                if (temp.bookId == id) {
                    temp.isAvailable = status;
                    System.out.println("Availability updated");
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Book not found");
        }

        // Display books in forward order
        void displayForward() {
            if (head == null) {
                System.out.println("No books to display");
                return;
            }

            Node temp = head;
            while (temp != null) {
                displayBook(temp);
                temp = temp.next;
            }
        }

        // Display books in reverse order
        void displayReverse() {
            if (tail == null) {
                System.out.println("No books to display");
                return;
            }

            Node temp = tail;
            while (temp != null) {
                displayBook(temp);
                temp = temp.prev;
            }
        }

        // Count total number of books
        int countBooks() {
            int count = 0;
            Node temp = head;

            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        // Helper method to display a single book
        void displayBook(Node node) {
            System.out.println("Book ID     : " + node.bookId);
            System.out.println("Title       : " + node.title);
            System.out.println("Author      : " + node.author);
            System.out.println("Genre       : " + node.genre);
            System.out.println("Available   : " + node.isAvailable);
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {

        LibraryList library = new LibraryList();

        // Adding books
        library.addAtBeginning(1, "Effective Java", "Joshua Bloch", "Programming", true);
        library.addAtEnd(2, "Clean Code", "Robert C. Martin", "Programming", true);
        library.addAtEnd(3, "The Hobbit", "J.R.R. Tolkien", "Fantasy", false);
        library.addAtPosition(2, 4, "1984", "George Orwell", "Dystopian", true);

        // Display forward
        System.out.println("Books (Forward):");
        library.displayForward();

        // Display reverse
        System.out.println("Books (Reverse):");
        library.displayReverse();

        // Search operations
        library.searchByTitle("1984");
        library.searchByAuthor("Joshua Bloch");

        // Update availability
        library.updateAvailability(3, true);

        // Remove a book
        library.removeByBookId(2);

        // Display updated list
        System.out.println("Updated Library:");
        library.displayForward();

        // Count books
        System.out.println("Total Books: " + library.countBooks());
    }
}
