/*
 This program sorts student ages (range 10 to 18) using Counting Sort.
 It counts frequencies of each age and places them in sorted order.
*/

public class countingsortstudentages {

    // Method to perform Counting Sort
    static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;

        // Count array for age frequencies
        int[] count = new int[maxAge - minAge + 1];

        // Store frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Rebuild the sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index] = i + minAge;
                index++;
                count[i]--;
            }
        }
    }

    // Method to display ages
    static void displayAges(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] studentAges = {15, 12, 17, 10, 14, 18, 13, 16, 12};

        System.out.println("Student ages before sorting:");
        displayAges(studentAges);

        // Sort using Counting Sort
        countingSort(studentAges);

        System.out.println("Student ages after sorting:");
        displayAges(studentAges);
    }
}
