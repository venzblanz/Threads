package OddNumberCounter;

import java.util.ArrayList;
import java.util.List;

public class OddMain {

    static void main() {
        List<Thread> threads = new ArrayList<Thread>();
        int start = 1;
        int last = 200;
        for(int i = 1; i <= 5; i++) {
            threads.add(new Thread(new OddNumberC(start,last)));
            start = last+1;
            last = last + 200;
        }
        for(Thread t : threads) {
            t.start();
            try {
                t.join();
            }catch(InterruptedException e){}
        }
        System.out.println("Final Count = " + OddNumberC.finalcount);
    }
}
