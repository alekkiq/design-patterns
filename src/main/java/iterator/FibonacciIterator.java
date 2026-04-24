package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private final int limit;

    // The Fibonacci calculation state (previous/current values and position) is stored in the iterator,
    // not in FibonacciSequence. This ensures that each call to FibonacciSequence.iterator() returns an
    // independent iterator with its own progress. If the state were kept in FibonacciSequence, multiple
    // iterators created from the same sequence instance would either share state (unexpected) or would
    // require additional cloning/synchronization logic.
    private int generated = 0;
    private int previous = 1;
    private int current = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return this.limit < 0 || this.generated < this.limit;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) throw new NoSuchElementException();

        int result;

        if (this.generated == 0) {
            result = 1;
        } else if (this.generated == 1) {
            result = 1;
        } else {
            result = this.previous + this.current;
            this.previous = this.current;
            this.current = result;
        }

        this.generated++;

        return result;
    }
}
