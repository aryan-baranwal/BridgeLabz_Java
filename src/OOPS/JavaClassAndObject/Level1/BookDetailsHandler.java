public class BookDetailsHandler {

    // Book class
    static class Book {

        // Attributes of Book
        String title;
        String author;
        double price;

        // Constructor to initialize book details
        Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Method to display book details
        void displayDetails() {
            System.out.println("Book Title : " + title);
            System.out.println("Author     : " + author);
            System.out.println("Price      : " + price);
        }
    }

    public static void main(String[] args) {

        // Creating a Book object
        Book book = new Book("Clean Code", "Robert C. Martin", 499.99);

        // Displaying book details
        book.displayDetails();
    }
}
