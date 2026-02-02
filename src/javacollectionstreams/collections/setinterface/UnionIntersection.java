package javacollectionstreams.collections.setinterface;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionIntersection {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes two sets from the user
         * 2. Computes their union
         * 3. Computes their intersection
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

        // Find union and intersection
        Set<Integer> union = findUnion(set1, set2);
        Set<Integer> intersection = findIntersection(set1, set2);

        // Display results
        System.out.println("\nUnion: " + union);
        System.out.println("Intersection: " + intersection);
    }

    // Method to find union of two sets
    public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {

        /*
         * Union contains all elements from both sets
         * without duplicates.
         */

        Set<Integer> unionSet = new HashSet<>();

        // Add all elements of set1
        for (Integer item : set1) {
            unionSet.add(item);
        }

        // Add all elements of set2
        for (Integer item : set2) {
            unionSet.add(item);
        }

        return unionSet;
    }

    // Method to find intersection of two sets
    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {

        /*
         * Intersection contains only common elements
         * present in both sets.
         */

        Set<Integer> intersectionSet = new HashSet<>();

        for (Integer item : set1) {
            if (set2.contains(item)) {
                intersectionSet.add(item);
            }
        }

        return intersectionSet;
    }
}
