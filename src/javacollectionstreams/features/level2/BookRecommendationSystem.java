package javacollectionstreams.features.level2;
import java.util.*;
import java.util.stream.*;

/*
 Book Recommendation System
*/

public class BookRecommendationSystem {

    static class Book {
        String title, author, genre;
        double rating;

        public Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Reading book details
            System.out.print("Enter title, author, genre, rating: ");
            books.add(new Book(sc.next(), sc.next(), sc.next(), sc.nextDouble()));
        }

        /*
            1. Filter: Science Fiction & rating > 4
            2. Sort: rating descending
            3. Paginate: top 10
        */

        books.stream()
                .filter(b -> b.genre.equalsIgnoreCase("ScienceFiction") && b.rating > 4)
                .sorted((a, b) -> Double.compare(b.rating, a.rating))
                .limit(10)
                .forEach(b ->
                        System.out.println(b.title + " - " + b.rating));
    }
}

