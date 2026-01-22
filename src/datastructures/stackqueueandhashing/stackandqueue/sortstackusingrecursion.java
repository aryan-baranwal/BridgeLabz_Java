package stackandqueue;/*
 This program sorts a stack in ascending order using recursion.
 No extra data structures are used except the implicit recursive stack.
*/

import java.util.Stack;

public class sortstackusingrecursion {

    // Sort the entire stack using recursion
    static void sortStack(Stack<Integer> stack) {
        // Base case: stack is empty
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Sort remaining stack
        sortStack(stack);

        // Insert the popped element at correct position
        insertInSortedOrder(stack, top);
    }

    // Insert an element into the stack in sorted order
    static void insertInSortedOrder(Stack<Integer> stack, int value) {
        // Base case: stack is empty or value is greater than top
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        // Remove top element
        int temp = stack.pop();

        // Recursive call
        insertInSortedOrder(stack, value);

        // Put the removed element back
        stack.push(temp);
    }

    // Display stack elements
    static void displayStack(Stack<Integer> stack) {
        System.out.println("Stack elements: " + stack);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // Pushing elements into stack
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack:");
        displayStack(stack);

        // Sort the stack
        sortStack(stack);

        System.out.println("Sorted Stack (Ascending):");
        displayStack(stack);
    }
}
