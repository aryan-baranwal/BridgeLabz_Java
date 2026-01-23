/*
 This program sorts employee IDs in ascending order using Insertion Sort.
 It inserts each element from the unsorted part into its correct position.
*/

public class insertionsortemployeeids {

    // Method to perform Insertion Sort
    static void insertionSort(int[] ids) {
        int n = ids.length;

        // Traverse from second element to end
        for (int i = 1; i < n; i++) {
            int key = ids[i];   // current element to be inserted
            int j = i - 1;

            // Shift elements greater than key to one position ahead
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }

            // Insert key at correct position
            ids[j + 1] = key;
        }
    }

    // Method to display employee IDs
    static void displayIds(int[] ids) {
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] employeeIds = {104, 101, 109, 102, 105};

        System.out.println("Employee IDs before sorting:");
        displayIds(employeeIds);

        // Sort using Insertion Sort
        insertionSort(employeeIds);

        System.out.println("Employee IDs after sorting (Ascending):");
        displayIds(employeeIds);
    }
}
