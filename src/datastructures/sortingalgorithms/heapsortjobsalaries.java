/*
 This program sorts job applicants' expected salaries in ascending order using Heap Sort.
 It first builds a Max Heap and then repeatedly extracts the maximum element.
*/

public class heapsortjobsalaries {

    // Method to perform Heap Sort
    static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    static void heapify(int[] salaries, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Method to display salaries
    static void displaySalaries(int[] salaries) {
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] applicantSalaries = {55000, 72000, 48000, 90000, 61000, 83000};

        System.out.println("Salary demands before sorting:");
        displaySalaries(applicantSalaries);

        // Sort using Heap Sort
        heapSort(applicantSalaries);

        System.out.println("Salary demands after sorting (Ascending):");
        displaySalaries(applicantSalaries);
    }
}
