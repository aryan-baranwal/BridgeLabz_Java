/*
 This program sorts students' exam scores in ascending order using Selection Sort.
 It repeatedly selects the minimum element and places it at the correct position.
*/

public class selectionsortexamscores {

    // Method to perform Selection Sort
    static void selectionSort(int[] scores) {
        int n = scores.length;

        // Traverse through all elements
        for (int i = 0; i < n - 1; i++) {

            // Assume current index has minimum value
            int minIndex = i;

            // Find the minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Method to display exam scores
    static void displayScores(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] examScores = {72, 88, 45, 90, 67, 81};

        System.out.println("Exam scores before sorting:");
        displayScores(examScores);

        // Sort using Selection Sort
        selectionSort(examScores);

        System.out.println("Exam scores after sorting (Ascending):");
        displayScores(examScores);
    }
}
