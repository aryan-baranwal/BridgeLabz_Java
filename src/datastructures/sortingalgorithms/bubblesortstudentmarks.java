/*
 This program sorts student marks in ascending order using Bubble Sort.
 It repeatedly compares adjacent elements and swaps them if needed.
*/

public class bubblesortstudentmarks {

    // Method to perform Bubble Sort
    static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse through all elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Method to display marks
    static void displayMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] studentMarks = {78, 45, 89, 62, 90, 55};

        System.out.println("Marks before sorting:");
        displayMarks(studentMarks);

        // Sort marks using Bubble Sort
        bubbleSort(studentMarks);

        System.out.println("Marks after sorting (Ascending):");
        displayMarks(studentMarks);
    }
}
