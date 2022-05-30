public class IterationCounter {
    private int iterations;

    public IterationCounter() {
        iterations = 0;
    }

    public void increment() {
        iterations = iterations + 1;
    }

    public void reset() {
        iterations = 0;
    }

    public int getCounter() {
        return iterations;
    }
}
