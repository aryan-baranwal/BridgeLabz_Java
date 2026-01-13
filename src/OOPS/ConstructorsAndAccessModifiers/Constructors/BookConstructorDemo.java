public class BookConstructorDemo {

    // Book class
    static class Book {

        // Attributes of Book
        String title;
        String author;
        double price;

        // Default constructor
        Book() {
            title = "Not Assigned";
            author = "Unknown";
            price = 0.0;
        }

        // Parameterized constructor
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

        // Using default constructor
        Book book1 = new Book();
        System.out.println("Book created using default constructor:");
        book1.displayDetails();

        System.out.println();

        // Using parameterized constructor
        Book book2 = new Book("Clean Code", "Robert C. Martin", 499.99);
        System.out.println("Book created using parameterized constructor:");
        book2.displayDetails();
    }
}
