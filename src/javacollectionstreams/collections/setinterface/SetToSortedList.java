package javacollectionstreams.collections.setinterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetToSortedList {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes a HashSet of integers from the user
         * 2. Converts it into a List
         * 3. Sorts the List in ascending order
         */

        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        // Taking number of elements
        System.out.print("Enter number of elements in the set: ");
        int n = sc.nextInt();

        // Taking elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        // Display original set
        System.out.println("\nOriginal Set: " + set);

        // Convert set to sorted list
        ArrayList<Integer> sortedList = convertToSortedList(set);

        // Display result
        System.out.println("Sorted List: " + sortedList);
    }

    // Method to convert Set to sorted List
    public static ArrayList<Integer> convertToSortedList(Set<Integer> set) {

        /*
         * Logic:
         * 1. Create a List from the Set
         * 2. Sort the List using Collections.sort()
         */

        ArrayList<Integer> list = new ArrayList<>();

        // Add all elements from set to list
        for (Integer item : set) {
            list.add(item);
        }

        // Sort the list in ascending order
        Collections.sort(list);

        return list;
    }
}

