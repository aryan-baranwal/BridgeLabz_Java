package javacollectionstreams.collections.setinterface;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckSubset {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes two sets from the user
         * 2. Checks if Set1 is a subset of Set2
         * 3. Subset means all elements of Set1
         *    are present in Set2
         */

        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Input for Set 1
        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Input for Set 2
        System.out.print("\nEnter number of elements in Set 2: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Display both sets
        System.out.println("\nSet 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Check subset
        boolean isSubset = checkSubset(set1, set2);

        // Display result
        if (isSubset) {
            System.out.println("Set 1 is a subset of Set 2");
        } else {
            System.out.println("Set 1 is NOT a subset of Set 2");
        }
    }

    // Method to check subset
    public static boolean checkSubset(Set<Integer> set1, Set<Integer> set2) {

        /*
         * Logic:
         * For every element in set1,
         * check if it exists in set2.
         */

        for (Integer item : set1) {
            if (!set2.contains(item)) {
                return false;
            }
        }

        return true;
    }
}
