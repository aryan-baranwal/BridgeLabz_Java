/*
 This program demonstrates abstraction, interfaces, encapsulation, and polymorphism.
 Different library items have different loan durations and reservation behavior.
*/

import java.util.ArrayList;

public class LibraryManagementSystemNew {

    // Interface for reservable items
    interface Reservable {
        void reserveItem(String borrowerName);
        boolean checkAvailability();
    }

    // Abstract class LibraryItem
    static abstract class LibraryItem {

        // Encapsulated fields
        private int itemId;
        private String title;
        private String author;
        private boolean isAvailable = true;
        private String borrower; // secured personal data

        // Constructor to initialize common item details
        LibraryItem(int itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
        }

        // Getter methods (encapsulation)
        public int getItemId() {
            return itemId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        // Abstract method for loan duration
        abstract int getLoanDuration();

        // Concrete method to display item details
        void getItemDetails() {
            System.out.println("Item ID   : " + itemId);
            System.out.println("Title     : " + title);
            System.out.println("Author    : " + author);
            System.out.println("Available : " + isAvailable);
            System.out.println("Loan Days : " + getLoanDuration());
        }

        // Protected methods to manage reservation safely
        protected void reserve(String borrowerName) {
            this.borrower = borrowerName;
            this.isAvailable = false;
        }

        protected boolean availabilityStatus() {
            return isAvailable;
        }
    }

    // Book subclass
    static class Book extends LibraryItem implements Reservable {

        Book(int id, String title, String author) {
            super(id, title, author);
        }

        // Loan duration for books
        @Override
        int getLoanDuration() {
            return 14;
        }

        // Reservation logic
        @Override
        public void reserveItem(String borrowerName) {
            if (checkAvailability()) {
                reserve(borrowerName);
            }
        }

        @Override
        public boolean checkAvailability() {
            return availabilityStatus();
        }
    }

    // Magazine subclass
    static class Magazine extends LibraryItem implements Reservable {

        Magazine(int id, String title, String author) {
            super(id, title, author);
        }

        // Loan duration for magazines
        @Override
        int getLoanDuration() {
            return 7;
        }

        @Override
        public void reserveItem(String borrowerName) {
            if (checkAvailability()) {
                reserve(borrowerName);
            }
        }

        @Override
        public boolean checkAvailability() {
            return availabilityStatus();
        }
    }

    // DVD subclass
    static class DVD extends LibraryItem implements Reservable {

        DVD(int id, String title, String author) {
            super(id, title, author);
        }

        // Loan duration for DVDs
        @Override
        int getLoanDuration() {
            return 3;
        }

        @Override
        public void reserveItem(String borrowerName) {
            if (checkAvailability()) {
                reserve(borrowerName);
            }
        }

        @Override
        public boolean checkAvailability() {
            return availabilityStatus();
        }
    }

    public static void main(String[] args) {

        // Creating list of library items (polymorphism)
        ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book(1, "Effective Java", "Joshua Bloch"));
        items.add(new Magazine(2, "Time", "Time Editors"));
        items.add(new DVD(3, "Inception", "Christopher Nolan"));

        // Reserving some items
        ((Reservable) items.get(0)).reserveItem("Aryan");
        ((Reservable) items.get(2)).reserveItem("Rahul");

        // Managing items using LibraryItem reference
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println();
        }
    }
}
