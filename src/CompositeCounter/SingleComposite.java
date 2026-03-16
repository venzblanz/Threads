package CompositeCounter;

public class SingleComposite {
    public static void main(String[] args) {
        int count = 0;
        int n = 500;
        long begin = System.currentTimeMillis();
        for(int i = 1; i <= n; i++) {
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    count++;
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("TIME = " + (end-begin));
        System.out.println("COUNT = " + count);
    }
}
