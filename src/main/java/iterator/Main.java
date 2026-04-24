package iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence(10);

        // each iterator() call creates a fresh FibonacciIterator instance.
        // sequence does not hold iteration state so multiple iterators can be used independently
        sequence.iterator().forEachRemaining(System.out::println);
    }
}
