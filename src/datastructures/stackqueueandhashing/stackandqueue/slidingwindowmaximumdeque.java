package stackandqueue;

/*
 This program finds the maximum element in each sliding window of size k.
 It uses a Deque to efficiently maintain potential maximum elements.
*/

import java.util.Deque;
import java.util.LinkedList;

public class slidingwindowmaximumdeque {

    // Method to find maximum in each sliding window
    static void findSlidingWindowMax(int[] arr, int k) {
        if (arr.length == 0 || k <= 0) {
            System.out.println("Invalid input");
            return;
        }

        Deque<Integer> deque = new LinkedList<>();

        // Process first k elements
        for (int i = 0; i < k; i++) {
            // Remove smaller elements from the back
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {

            // The front of deque is the maximum of previous window
            System.out.print(arr[deque.peekFirst()] + " ");

            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Print max of last window
        System.out.print(arr[deque.peekFirst()]);
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Sliding Window Maximums:");
        findSlidingWindowMax(arr, k);
    }
}
