package javacollectionstreams.collections.queueinterface;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes N from the user
         * 2. Generates first N binary numbers
         * 3. Uses a queue to generate them
         */

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        // Generate binary numbers
        generateBinary(n);
    }

    // Method to generate binary numbers
    public static void generateBinary(int n) {

        /*
         * Logic:
         * Start with "1" in queue.
         * For each number:
         *   Remove front element
         *   Print it
         *   Add element+"0" and element+"1" back to queue
         */

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.println("\nFirst " + n + " binary numbers:");

        for (int i = 0; i < n; i++) {

            // Remove front element
            String current = queue.remove();

            // Print current binary number
            System.out.print(current + " ");

            // Add next binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}
