package practice;

import java.util.List;

public class SphenicWorker implements Runnable {
    private int start, end;

    public SphenicWorker(int start, int end) {
        this.start = start;
        this.end = end;
    }
    private boolean isSphenic(int num) {
        int count = 0;
        for(int i = start; i * i <= end; i++){
            if(num% i == 0){
                count++;
                if(num%i == 0) return false;
            }
        }
        if(num > 1) count++;
        return count == 3;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isSphenic(i)) {
                System.out.println(i);
            }
        }
    }
}