package stackandqueue;/*
 This program implements a Queue using two Stacks.
 Enqueue happens in one stack, and dequeue uses another stack for FIFO behavior.
*/

import java.util.Stack;

public class queueusingtwostacksystem {

    static class QueueUsingStacks {
        Stack<Integer> stack1 = new Stack<>(); // for enqueue
        Stack<Integer> stack2 = new Stack<>(); // for dequeue

        // Enqueue operation
        void enqueue(int data) {
            stack1.push(data);
            System.out.println("Enqueued: " + data);
        }

        // Dequeue operation
        void dequeue() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            // Transfer elements if stack2 is empty
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            System.out.println("Dequeued: " + stack2.pop());
        }

        // Display queue elements
        void displayQueue() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            System.out.print("Queue elements: ");

            // Elements in stack2 (top to bottom)
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }

            // Elements in stack1 (bottom to top)
            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i) + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display queue
        queue.displayQueue();

        // Dequeue operations
        queue.dequeue();
        queue.displayQueue();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // empty case
    }
}
