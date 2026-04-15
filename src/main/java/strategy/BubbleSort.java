package strategy;

/**
 * Code provided by GeeksforGeeks: https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
 */
public class BubbleSort implements AlgorithmStrategy {
    @Override
    public void sort(int[] array, int n) {
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;

            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
