package CompositeCounter;

public class CompositeWorker implements Runnable {
    private int start,end;
    public static ThreadSafeCounter count = new ThreadSafeCounter();
    public CompositeWorker(int start, int end) {
        this.start = start;
        this.end = end;
    }



    @Override
    public void run() {
        for(int i = start; i <= end; i++) {
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    count.increment();
                    break;
                }
            }
        }
    }
}
