package javacollectionstreams.collections.listinterface;
import java.util.ArrayList;
import java.util.Scanner;

public class RotateList {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes a list of integers from the user
         * 2. Takes number of positions to rotate
         * 3. Rotates the list to the left
         * 4. Does not use any built-in rotate methods
         */

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        // Taking number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Taking elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Taking rotation value
        System.out.print("Enter number of positions to rotate: ");
        int k = sc.nextInt();

        // Display original list
        System.out.println("\nOriginal List: " + list);

        // Rotate the list
        rotateLeft(list, k);

        // Display rotated list
        System.out.println("Rotated List: " + list);
    }

    // Method to rotate list to the left
    public static void rotateLeft(ArrayList<Integer> list, int k) {

        /*
         * Left rotation logic:
         * Move first k elements to the end of the list.
         */

        int n = list.size();

        // Handle cases where k > n
        k = k % n;

        for (int i = 0; i < k; i++) {
            // Remove first element
            int first = list.remove(0);

            // Add it at the end
            list.add(first);
        }
    }
}
