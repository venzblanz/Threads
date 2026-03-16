package WordCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MultiWord {

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("bigtext.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("File not found or error reading file.");
        }

        int thr = 2; // Number of threads
        int n = lines.size();
        int div = n / thr;
        long begin = System.currentTimeMillis();

        WordWorker[] workers = new WordWorker[thr];

        for (int i = 0; i < thr; i++) {
            workers[i] = new WordWorker(div * i, i == thr - 1 ? n - 1 : (div * (i+1) - 1), lines);
        }

        Thread[] thread = new Thread[thr];

        // Wrapping the workers in actual Thread objects
        for (int i = 0; i < thr; i++) {
            thread[i] = new Thread(workers[i]);
        }

        for (int i = 0; i < thr; i++) {
            thread[i].start();
        }

        long finalCount = 0;

        try {
            for (int i = 0; i < thr; i++) {
                thread[i].join();
            }
            for (int i = 0; i < thr; i++) {
                finalCount += workers[i].getCount();
            }
        } catch (InterruptedException e) {
            System.out.println("A thread was interrupted!");
        }

        long end = System.currentTimeMillis();
        System.out.println("TIME = " + (end - begin));
        System.out.println("COUNT = " + finalCount);
    }
}