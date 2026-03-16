package WordCounter;

import java.util.ArrayList;

public class WordWorker implements Runnable {
    private int start;
    private int end;
    private ArrayList<String> lines;
    private long count = 0;

    // Constructor matching the arguments from MultiWord
    public WordWorker(int start, int end, ArrayList<String> lines) {
        this.start = start;
        this.end = end;
        this.lines = lines;
    }

    @Override
    public void run() {
        // NOTE: We use <= end because your math calculated the exact final index!
        for (int i = start; i <= end; i++) {
            String line = lines.get(i);
            count += line.trim().split("\\s+").length;
        }
    }

    public long getCount() {
        return count;
    }
}