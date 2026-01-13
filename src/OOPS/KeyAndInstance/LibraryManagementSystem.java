public class LibraryManagementSystem {

    // Book class
    static class Book {

        // Static variable shared across all books
        static String libraryName = "Central Library";

        // Instance variables
        String title;
        String author;

        // Final variable (cannot be changed once assigned)
        final String isbn;

        // Constructor using 'this' keyword
        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        // Method to display book details
        void displayBookDetails() {
            System.out.println("Library Name : " + libraryName);
            System.out.println("Title        : " + title);
            System.out.println("Author       : " + author);
            System.out.println("ISBN         : " + isbn);
        }

        // Static method to display library name
        static void displayLibraryName() {
            System.out.println("Library Name : " + libraryName);
        }
    }

    public static void main(String[] args) {

        // Creating Book objects
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "978-0132350884");

        // Display library name using static method
        Book.displayLibraryName();
        System.out.println();

        // Using instanceof to verify object type before displaying details
        if (book1 instanceof Book) {
            System.out.println("Book 1 Details:");
            book1.displayBookDetails();
        }

        System.out.println();

        if (book2 instanceof Book) {
            System.out.println("Book 2 Details:");
            book2.displayBookDetails();
        }
    }
}
