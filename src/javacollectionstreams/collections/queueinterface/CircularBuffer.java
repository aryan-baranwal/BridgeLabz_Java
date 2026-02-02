package javacollectionstreams.collections.queueinterface;
import java.util.Scanner;

public class CircularBuffer {

    static class CircularQueue {
        int[] buffer;
        int size;
        int front;
        int rear;
        int count;

        // Constructor
        public CircularQueue(int size) {
            this.size = size;
            buffer = new int[size];
            front = 0;
            rear = -1;
            count = 0;
        }

        // Insert element
        public void enqueue(int value) {
            // Move rear to next position
            rear = (rear + 1) % size;
            buffer[rear] = value;

            if (count < size) {
                count++;
            } else {
                // If full, move front to next to overwrite oldest
                front = (front + 1) % size;
            }
        }

        // Display buffer in order
        public void display() {
            System.out.print("Buffer: [");
            for (int i = 0; i < count; i++) {
                int index = (front + i) % size;
                System.out.print(buffer[index]);
                if (i < count - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        /*
         * This program simulates a circular buffer (fixed-size queue)
         * 1. Insert elements
         * 2. Overwrite oldest when full
         * 3. Display buffer after each insertion
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter buffer size: ");
        int bufferSize = sc.nextInt();

        CircularQueue cb = new CircularQueue(bufferSize);

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter elements to insert:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            cb.enqueue(val);
            cb.display();
        }
    }
}
