package javacollectionstreams.features.level2;
import java.util.*;
import java.util.stream.*;

/*
 Product Sales Analysis System
*/

public class ProductSalesAnalysis {

    static class Sale {
        int productId, quantity;
        double price;

        public Sale(int productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();

        System.out.print("Enter number of sales: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Input sale data
            System.out.print("Enter productId, quantity, price: ");
            sales.add(new Sale(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
        }

        /*
            1. Filter: quantity > 10
            2. Transform: revenue = quantity * price
            3. Sort: revenue descending
            4. Top 5 products
        */

        sales.stream()
                .filter(s -> s.quantity > 10)
                .map(s -> new AbstractMap.SimpleEntry<>(s.productId, s.quantity * s.price))
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(5)
                .forEach(s ->
                        System.out.println("Product: " + s.getKey() +
                                " Revenue: " + s.getValue()));
    }
}
