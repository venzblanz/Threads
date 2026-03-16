package bingoTesting;

import java.util.*;

public class BingoGame implements Runnable {
    private BingoCell[] result;
    private boolean bingo;
    List<Thread> threads = new ArrayList<>();
    public BingoGame() {
        this.result = new BingoCell[76];
        for(int i = 0; i < 76; i++){
            result[i] = new BingoCell(i);
        }
        result[0].setPicked();
    }
    public BingoCell getCell(int i) {
        return result[i];
    }
    public synchronized boolean setBingo() {
        if(!bingo){
            bingo = true;

            for(Thread t : threads){
                if(t.isAlive()){
                    t.interrupt();
                }
            }

            return true;
        }
        return false;
    }


    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many players: ");
        int n = sc.nextInt();
        BingoCard[] cards = new BingoCard[n];
        for(int i = 0; i < n; i++){
            cards[i] = new BingoCard(this);
            System.out.println(cards[i]);
        }
        System.out.print("Choose a pattern (+/#): ");
        sc.nextLine();
        char op = sc.nextLine().charAt(0);

        switch (op) {
            case '+':
                for(int i = 0 ; i<n; i++){
                    threads.add(new Thread(new BingoPatternPlus(this,cards[i])));
                }
                break;
            case '#':
                for(int i = 0 ; i<n; i++){
                    threads.add(new Thread(new BingoPatternHash(this,cards[i])));
                }
                break;
            default:
                break;

        }
        for(Thread t : threads){
            t.start();
        }
        List<Integer> pickedNum = new ArrayList<>();

        Random rand = new Random();
        while(!bingo){
            int num;
            do{
                num = rand.nextInt(75) + 1;
            }while (pickedNum.contains(num));
            pickedNum.add(num);
            System.out.println("Chosen Number: " + num);
            Collections.sort(pickedNum);
            System.out.println("LIST: ");
            for(int i : pickedNum){
                System.out.print(i + " ");
            }
            System.out.println();
            getCell(num).setPicked();
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
            }
        }
    }

    static void main(String[] args) {
        new Thread(new BingoGame()).start();
    }
}
