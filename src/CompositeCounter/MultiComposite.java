package CompositeCounter;

import javax.script.Compilable;
import java.util.ArrayList;
import java.util.List;

public class MultiComposite {
    public static void main(String[] args) {
        int thr = 100;
        int n = 500_000;
        int div = n/thr;
        int totalcount = 0;
        long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<Thread>();
        for(int i=0;i<thr;i++) {
            Thread t = new Thread(new CompositeWorker(div*i+1,div*(i+1)));
            threads.add(t);
            t.start();
        }
        for(Thread thread : threads){
            try{
                thread.join();
            }catch (InterruptedException e){}
        }
        long end = System.currentTimeMillis();
        System.out.println("TIME = " + (end-start));
        System.out.printf("COUNT = " + CompositeWorker.count.getCount());
    }
}
