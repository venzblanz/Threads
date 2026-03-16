package OddNumberCounter;

public class OddNumberC implements Runnable {
    private int start;
    private int last;
    public static int finalcount = 0;
    public OddNumberC(int start, int last) {
        this.start = start;
        this.last = last;
    }
    public void run() {
        int count = 0;
        for(int i = start; i <= last; i++) {
            if(i % 2 != 0) {
                count++;
            }
        }
        finalcount += count;
        System.out.println(start + " to " + last + " count = " + count);
    }
}
