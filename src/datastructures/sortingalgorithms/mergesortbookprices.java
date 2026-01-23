/*
 This program sorts an array of book prices in ascending order using Merge Sort.
 It divides the array recursively and merges sorted halves.
*/

public class mergesortbookprices {

    // Method to perform Merge Sort
    static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort first half
            mergeSort(prices, left, mid);

            // Sort second half
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to merge two sorted halves
    static void merge(double[] prices, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Merge the temp arrays back
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k] = leftArr[i];
                i++;
            } else {
                prices[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr
        while (i < n1) {
            prices[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr
        while (j < n2) {
            prices[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Method to display book prices
    static void displayPrices(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        double[] bookPrices = {499.50, 299.99, 899.00, 150.75, 650.40};

        System.out.println("Book prices before sorting:");
        displayPrices(bookPrices);

        // Sort using Merge Sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Book prices after sorting (Ascending):");
        displayPrices(bookPrices);
    }
}
