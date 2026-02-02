package javacollectionstreams.collections.setinterface;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompareSets {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes two sets from the user
         * 2. Compares them
         * 3. Checks if both sets contain same elements
         *    irrespective of order
         */

        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Input for first set
        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Input for second set
        System.out.print("\nEnter number of elements in Set 2: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Display both sets
        System.out.println("\nSet 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Compare sets
        boolean isEqual = areSetsEqual(set1, set2);

        // Display result
        System.out.println("Are both sets equal? " + isEqual);
    }

    // Method to compare two sets
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {

        /*
         * Two sets are equal if:
         * 1. Both have same size
         * 2. Every element of set1 exists in set2
         */

        if (set1.size() != set2.size()) {
            return false;
        }

        for (Integer element : set1) {
            if (!set2.contains(element)) {
                return false;
            }
        }

        return true;
    }
}
