package Strategy;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100000;
        Random rng = new Random();

        System.out.println("Array item randomizer bounds for each test: 0 to 100\n");

        System.out.println("Comparing sorting algorithms with small array:\n");

        Sorter sorter = new Sorter(new BubbleSort());

        benchmarkSort(sorter, rng, "BubbleSort", smallSize);
        sorter.setStrategy(new MergeSort());
        benchmarkSort(sorter, rng, "MergeSort", smallSize);
        sorter.setStrategy(new PigeonholeSort());
        benchmarkSort(sorter, rng, "PigeonholeSort", smallSize);

        System.out.println("Comparing sorting algorithms with large array:\n");

        sorter.setStrategy(new BubbleSort());
        benchmarkSort(sorter, rng, "BubbleSort", largeSize);
        sorter.setStrategy(new MergeSort());
        benchmarkSort(sorter, rng, "MergeSort", largeSize);
        sorter.setStrategy(new PigeonholeSort());
        benchmarkSort(sorter, rng, "PigeonholeSort", largeSize);
    }

    private static void benchmarkSort(Sorter sorter, Random rng, String algorithmName, int size) {
        int[] array = rng.ints(size, 0, 100).toArray();

        System.out.println("Sorting array (size: " + size + ") with " + algorithmName + "...");

        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();

        System.out.println(algorithmName + " took: " + (endTime - startTime) / 1_000_000.0 + " ms\n");
    }
}
