/*
 This program sorts product prices in ascending order using Quick Sort.
 It partitions the array around a pivot and recursively sorts subarrays.
*/

public class quicksortproductprices {

    // Method to perform Quick Sort
    static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Find partition index
            int pi = partition(prices, low, high);

            // Sort left and right partitions
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // Partition method using last element as pivot
    static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // pivot element
        int i = low - 1;

        // Rearrange elements based on pivot
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;

                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Place pivot at correct position
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Method to display product prices
    static void displayPrices(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        double[] productPrices = {999.99, 499.50, 1299.00, 299.99, 750.75};

        System.out.println("Product prices before sorting:");
        displayPrices(productPrices);

        // Sort using Quick Sort
        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Product prices after sorting (Ascending):");
        displayPrices(productPrices);
    }
}
