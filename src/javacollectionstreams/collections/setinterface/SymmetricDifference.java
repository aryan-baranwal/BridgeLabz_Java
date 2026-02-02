package javacollectionstreams.collections.setinterface;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes two sets from the user
         * 2. Finds the symmetric difference
         * 3. Symmetric difference = elements present in either set
         *    but not in both
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

        // Display original sets
        System.out.println("\nSet 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Find symmetric difference
        Set<Integer> symmetricDiff = findSymmetricDifference(set1, set2);

        // Display result
        System.out.println("\nSymmetric Difference: " + symmetricDiff);
    }

    // Method to find symmetric difference
    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {

        /*
         * Logic:
         * Add elements that are in set1 but not in set2
         * Add elements that are in set2 but not in set1
         */

        Set<Integer> result = new HashSet<>();

        // Elements in set1 but not in set2
        for (Integer item : set1) {
            if (!set2.contains(item)) {
                result.add(item);
            }
        }

        // Elements in set2 but not in set1
        for (Integer item : set2) {
            if (!set1.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
}

