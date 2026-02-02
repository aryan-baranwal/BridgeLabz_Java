package javacollectionstreams.collections.listinterface;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes a list of integers from the user
         * 2. Removes duplicate elements
         * 3. Preserves the original order
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

        // Display original list
        System.out.println("\nOriginal List: " + list);

        // Remove duplicates
        ArrayList<Integer> result = removeDuplicates(list);

        // Display result
        System.out.println("List after removing duplicates: " + result);
    }

    // Method to remove duplicates while preserving order
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {

        /*
         * Logic:
         * Create a new list.
         * Add element only if it is not already present.
         */

        ArrayList<Integer> uniqueList = new ArrayList<>();

        for (Integer item : list) {
            // Add only if not already present
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        return uniqueList;
    }
}
