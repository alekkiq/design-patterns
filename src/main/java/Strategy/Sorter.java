package Strategy;

public class Sorter {
    private AlgorithmStrategy strategy;

    public Sorter(AlgorithmStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AlgorithmStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array) {
        this.strategy.sort(array, array.length);
    }
}
