package Strategy;

import java.util.Arrays;

/**
 * Code provided by GeeksforGeeks: https://www.geeksforgeeks.org/dsa/pigeonhole-sort/
 */
public class PigeonholeSort implements AlgorithmStrategy {
    @Override
    public void sort(int[] array, int n) {
        int min = array[0];
        int max = array[0];
        int range, i, j, idx;

        for (int a = 0; a < n; a++) {
            if (array[a] > max) max = array[a];
            if (array[a] < min) min = array[a];
        }

        range = max - min + 1;
        int[] pigeonhole = new int[range];
        Arrays.fill(pigeonhole, 0);

        for (i = 0; i < n; i++) {
            pigeonhole[array[i] - min]++;
        }

        idx = 0;

        for (j = 0; j < range; j++) {
            while (pigeonhole[j]-- > 0) {
                array[idx++] = j + min;
            }
        }
    }
}
