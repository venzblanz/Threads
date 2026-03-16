package threader;

import java.util.ArrayList;

public class Main {
    static void main() {
        System.out.println("All threads started");
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            threads.add(new Thread(new Threader("Vensy" + i, i)));
        }
        for(Thread thread : threads) {
            thread.start();
        }
        for(Thread thread : threads) {
            try{
                thread.join();
                if(thread.getState() == Thread.State.TERMINATED) {
                    System.out.println("TERMINATED " + thread.getName());
                }
//
            }catch(InterruptedException e){

            }
        }

        System.out.println("MAIN DIES");
    }
}
