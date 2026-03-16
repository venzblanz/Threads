package CompositeCounter;

public class ThreadSafeCounter {
    private int count = 0;

    synchronized public void increment() {
        count++;
    }

    synchronized public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return count + "";
    }
}
