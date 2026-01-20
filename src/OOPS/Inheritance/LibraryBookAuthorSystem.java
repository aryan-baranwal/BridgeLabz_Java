/*
 This program demonstrates single inheritance.
 Author extends Book and adds author-specific details.
*/

public class LibraryBookAuthorSystem {

    // Superclass Book
    static class Book {
        String title;
        int publicationYear;

        // Constructor to initialize book details
        Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        // Method to display book details
        void displayInfo() {
            System.out.println("Book Title        : " + title);
            System.out.println("Publication Year  : " + publicationYear);
        }
    }

    // Subclass Author (extends Book)
    static class Author extends Book {
        String name;
        String bio;

        // Constructor to initialize book and author details
        Author(String title, int publicationYear, String name, String bio) {
            super(title, publicationYear);
            this.name = name;
            this.bio = bio;
        }

        // Overriding displayInfo() to include author details
        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Author Name       : " + name);
            System.out.println("Author Bio        : " + bio);
        }
    }

    public static void main(String[] args) {

        // Creating Author object (which is also a Book)
        Book book = new Author(
                "Effective Java",
                2018,
                "Joshua Bloch",
                "Expert in Java and API design"
        );

        // Polymorphic method call
        book.displayInfo();
    }
}
