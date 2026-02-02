package javacollectionstreams.collections.listinterface;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseListBoth {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes user input
         * 2. Stores elements in both ArrayList and LinkedList
         * 3. Reverses both without using built-in methods
         */

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Taking size of the list from user
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Taking elements as input
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            arrayList.add(value);   // add to ArrayList
            linkedList.add(value);  // add to LinkedList
        }

        // Display original lists
        System.out.println("\nOriginal ArrayList: " + arrayList);
        System.out.println("Original LinkedList: " + linkedList);

        // Reverse ArrayList
        reverseArrayList(arrayList);

        // Reverse LinkedList
        reverseLinkedList(linkedList);

        // Display reversed lists
        System.out.println("\nReversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }

    // Method to reverse ArrayList
    public static void reverseArrayList(ArrayList<Integer> list) {

        /*
         * Reverses ArrayList using two-pointer technique
         */

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            // Swap elements
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    // Method to reverse LinkedList
    public static void reverseLinkedList(LinkedList<Integer> list) {

        /*
         * Reverses LinkedList using index-based swapping
         */

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            // Swap elements
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }
}

