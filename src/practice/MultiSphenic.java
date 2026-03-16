package practice;

public class MultiSphenic {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SphenicWorker(1, 500));
        Thread t2 = new Thread(new SphenicWorker(501, 1000));
        Thread t3 = new Thread(new SphenicWorker(1001, 1500));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Sort and print

    }
}