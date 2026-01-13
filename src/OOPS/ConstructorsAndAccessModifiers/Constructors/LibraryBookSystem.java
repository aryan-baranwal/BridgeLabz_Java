public class LibraryBookSystem {

    // Book class
    static class Book {

        // Attributes of Book
        String title;
        String author;
        double price;
        boolean availability;

        // Constructor to initialize book details
        Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.availability = true; // book is available initially
        }

        // Method to borrow a book
        void borrowBook() {
            if (availability) {
                availability = false;
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book is not available for borrowing.");
            }
        }

        // Method to display book details
        void displayDetails() {
            System.out.println("Title        : " + title);
            System.out.println("Author       : " + author);
            System.out.println("Price        : " + price);
            System.out.println("Availability : " + (availability ? "Available" : "Not Available"));
        }
    }

    public static void main(String[] args) {

        // Creating a Book object
        Book book = new Book("Effective Java", "Joshua Bloch", 599.99);

        // Display book details before borrowing
        System.out.println("Before Borrowing:");
        book.displayDetails();

        System.out.println();

        // Borrow the book
        book.borrowBook();

        System.out.println();

        // Display book details after borrowing
        System.out.println("After Borrowing:");
        book.displayDetails();
    }
}
