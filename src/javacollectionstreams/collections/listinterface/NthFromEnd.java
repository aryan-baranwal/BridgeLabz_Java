package javacollectionstreams.collections.listinterface;
import java.util.LinkedList;
import java.util.Scanner;

public class NthFromEnd {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes elements of a LinkedList from the user
         * 2. Takes N value
         * 3. Finds the Nth element from the end
         * 4. Without calculating the size of the list
         */

        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        // Taking number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Taking elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Taking N value
        System.out.print("Enter N (Nth element from end): ");
        int k = sc.nextInt();

        // Display original list
        System.out.println("\nLinkedList: " + list);

        // Find Nth element from end
        String result = findNthFromEnd(list, k);

        if (result != null) {
            System.out.println("Nth element from end: " + result);
        } else {
            System.out.println("Invalid N value!");
        }
    }

    // Method to find Nth element from the end
    public static String findNthFromEnd(LinkedList<String> list, int k) {

        /*
         * Two-pointer approach:
         * Move first pointer k steps ahead.
         * Then move both pointers one step at a time.
         * When first reaches end, second is at Nth from end.
         */

        if (k <= 0 || k > list.size()) {
            return null;
        }

        int first = 0;
        int second = 0;

        // Move first pointer k steps ahead
        for (int i = 0; i < k; i++) {
            first++;
        }

        // Move both pointers until first reaches end
        while (first < list.size()) {
            first++;
            second++;
        }

        // second pointer now points to Nth from end
        return list.get(second);
    }
}

