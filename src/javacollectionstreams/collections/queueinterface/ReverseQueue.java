package javacollectionstreams.collections.queueinterface;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseQueue {

    public static void main(String[] args) {

        /*
         * This program:
         * 1. Takes elements of a queue from the user
         * 2. Reverses the queue
         * 3. Uses only queue operations (add, remove, isEmpty)
         */

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        // Taking number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Taking elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        // Display original queue
        System.out.println("\nOriginal Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Display reversed queue
        System.out.println("Reversed Queue: " + queue);
    }

    // Method to reverse queue
    public static void reverseQueue(Queue<Integer> queue) {

        /*
         * Logic:
         * 1. Remove elements from queue and push into stack
         * 2. Pop elements from stack and add back to queue
         */

        Stack<Integer> stack = new Stack<>();

        // Move all elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Move elements back from stack to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
