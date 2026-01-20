/*
 This program demonstrates Aggregation.
 A Library contains Book objects, but Books can exist independently.
*/

import java.util.ArrayList;

public class LibraryAggregation {

    // Book class (independent entity)
    static class Book {
        String title;
        String author;

        // Constructor to initialize book details
        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    // Library class (aggregates Book objects)
    static class Library {
        String name;
        ArrayList<Book> books = new ArrayList<>();

        // Constructor to initialize library name
        Library(String name) {
            this.name = name;
        }

        // Method to add a book to the library
        void addBook(Book book) {
            books.add(book);
        }

        // Method to display all books in the library
        void displayBooks() {
            System.out.println("\nLibrary: " + name);

            for (Book b : books) {
                System.out.println("Title: " + b.title + ", Author: " + b.author);
            }
        }
    }

    public static void main(String[] args) {

        // Creating independent Book objects
        Book b1 = new Book("Effective Java", "Joshua Bloch");
        Book b2 = new Book("Clean Code", "Robert C. Martin");

        // Creating Library objects
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("City Library");

        // Adding books to libraries (aggregation)
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // Same book added to another library

        // Displaying books in libraries
        lib1.displayBooks();
        lib2.displayBooks();
    }
}
