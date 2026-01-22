package stackandqueue;

/*
 This program solves the Stock Span Problem using a Stack.
 For each day, it calculates how many consecutive previous days
 had a stock price less than or equal to the current day's price.
*/

import java.util.Stack;

public class stockspanproblemstack {

    // Method to calculate stock span
    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        // Stack to store indices of days
        Stack<Integer> stack = new Stack<>();

        // First day span is always 1
        span[0] = 1;
        stack.push(0);

        // Calculate span for remaining days
        for (int i = 1; i < n; i++) {

            // Pop indices while price is higher or equal
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, span is i + 1
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
        }

        return span;
    }

    // Display prices and spans
    static void displayResult(int[] prices, int[] span) {
        System.out.println("Day\tPrice\tSpan");
        for (int i = 0; i < prices.length; i++) {
            System.out.println((i + 1) + "\t" + prices[i] + "\t" + span[i]);
        }
    }

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Calculate stock span
        int[] span = calculateSpan(prices);

        // Display result
        displayResult(prices, span);
    }
}

