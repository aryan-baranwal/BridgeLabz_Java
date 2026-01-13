public class BookLibrarySystem {

    // Base class Book
    static class Book {

        // Access modifiers as required
        public String ISBN;        // public
        protected String title;    // protected
        private String author;     // private

        // Constructor to initialize book details
        Book(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }

        // Public getter method to access author
        public String getAuthor() {
            return author;
        }

        // Public setter method to modify author
        public void setAuthor(String author) {
            this.author = author;
        }

        // Method to display book details
        void displayBookDetails() {
            System.out.println("ISBN   : " + ISBN);
            System.out.println("Title  : " + title);
            System.out.println("Author : " + author);
        }
    }

    // Subclass EBook to demonstrate access modifiers
    static class EBook extends Book {

        String fileFormat;

        // Constructor
        EBook(String ISBN, String title, String author, String fileFormat) {
            super(ISBN, title, author);
            this.fileFormat = fileFormat;
        }

        // Method accessing public and protected members
        void displayEBookDetails() {
            System.out.println("E-Book ISBN  : " + ISBN);   // public access
            System.out.println("E-Book Title : " + title);  // protected access
            System.out.println("Format       : " + fileFormat);
            System.out.println("Author       : " + getAuthor()); // private accessed via getter
        }
    }

    public static void main(String[] args) {

        // Creating Book object
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        System.out.println("Book Details:");
        book.displayBookDetails();

        System.out.println();

        // Modifying author using setter
        book.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + book.getAuthor());

        System.out.println();

        // Creating EBook object
        EBook ebook = new EBook("978-1492056270", "Java Cookbook", "Ian Darwin", "PDF");

        // Display EBook details
        System.out.println("EBook Details:");
        ebook.displayEBookDetails();
    }
}
