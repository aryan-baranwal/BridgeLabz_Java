/*
 This program implements a Doubly Linked List for a Movie Management System.
 It supports insertion, deletion, searching, updating, and traversal in both directions.
*/

public class MovieDoublyLinkedListSystem {

    // Node class representing a Movie
    static class Node {
        String title;
        String director;
        int year;
        double rating;
        Node prev;
        Node next;

        // Constructor to initialize movie details
        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.prev = null;
            this.next = null;
        }
    }

    // Doubly Linked List class
    static class MovieList {
        Node head;
        Node tail;

        // Add movie at beginning
        void addAtBeginning(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);

            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        // Add movie at end
        void addAtEnd(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);

            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        // Add movie at a specific position (1-based index)
        void addAtPosition(int position, String title, String director, int year, double rating) {
            if (position == 1) {
                addAtBeginning(title, director, year, rating);
                return;
            }

            Node temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null || temp.next == null) {
                addAtEnd(title, director, year, rating);
                return;
            }

            Node newNode = new Node(title, director, year, rating);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }

        // Remove movie by title
        void removeByTitle(String title) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;

            while (temp != null && !temp.title.equalsIgnoreCase(title)) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Movie not found");
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

            System.out.println("Movie removed successfully");
        }

        // Search movie by director
        void searchByDirector(String director) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.director.equalsIgnoreCase(director)) {
                    displayMovie(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("No movies found for director: " + director);
            }
        }

        // Search movie by rating
        void searchByRating(double rating) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.rating == rating) {
                    displayMovie(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("No movies found with rating: " + rating);
            }
        }

        // Update movie rating by title
        void updateRating(String title, double newRating) {
            Node temp = head;

            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {
                    temp.rating = newRating;
                    System.out.println("Rating updated successfully");
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Movie not found");
        }

        // Display movies in forward order
        void displayForward() {
            if (head == null) {
                System.out.println("No movies to display");
                return;
            }

            Node temp = head;
            while (temp != null) {
                displayMovie(temp);
                temp = temp.next;
            }
        }

        // Display movies in reverse order
        void displayReverse() {
            if (tail == null) {
                System.out.println("No movies to display");
                return;
            }

            Node temp = tail;
            while (temp != null) {
                displayMovie(temp);
                temp = temp.prev;
            }
        }

        // Helper method to display a movie
        void displayMovie(Node node) {
            System.out.println("Title    : " + node.title);
            System.out.println("Director : " + node.director);
            System.out.println("Year     : " + node.year);
            System.out.println("Rating   : " + node.rating);
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {

        MovieList list = new MovieList();

        // Adding movies
        list.addAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        list.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.8);
        list.addAtEnd("Avatar", "James Cameron", 2009, 8.0);
        list.addAtPosition(2, "Titanic", "James Cameron", 1997, 7.8);

        // Display movies forward
        System.out.println("Movies (Forward):");
        list.displayForward();

        // Display movies in reverse
        System.out.println("Movies (Reverse):");
        list.displayReverse();

        // Search operations
        list.searchByDirector("Christopher Nolan");
        list.searchByRating(8.0);

        // Update rating
        list.updateRating("Avatar", 8.5);

        // Remove a movie
        list.removeByTitle("Titanic");

        // Display updated list
        System.out.println("Updated Movie List:");
        list.displayForward();
    }
}
