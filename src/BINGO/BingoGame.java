package BINGO;

import java.beans.BeanInfo;
import java.lang.module.InvalidModuleDescriptorException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BingoGame implements Runnable{
    private boolean bingo;
    List<Thread> threads = new ArrayList<>();
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

    private BingoCell[] results;

    public BingoGame() {
        this.results = new BingoCell[76];
        for(int i = 0; i <= 75; i++){
            results[i] = new BingoCell(i);
        }
        results[0].setPicked();
    }
    public BingoCell getCell(int index){
        return results[index];
    }
    @Override
    public void run() {
        Scanner sc =  new Scanner(System.in);
        System.out.print("How many players: ");
        int n = sc.nextInt();
        BingoCard[] cards = new BingoCard[n];
        for(int i = 0; i < n; i++){
            cards[i] = new BingoCard(this);
            System.out.println(cards[i]);
        }
        System.out.print("Choose pattern(+/#): ");
        sc.nextLine();
        char op = sc.nextLine().charAt(0);

        switch (op){
            case '+':
                for(int i = 0 ; i < n; i++){
                    threads.add(new Thread(new BingoPatternPlus(this,cards[i])));
                }
                break;
            case '#':
                for (int i = 0; i < n; i++){
                    threads.add(new Thread(new BingoPatternHash(this,cards[i])));
                }
                break;

        }
        for(Thread t : threads){
            t.start();
        }
        List<Integer> chosen = new ArrayList<>();

        while(!bingo){
            int num;
            do{
                num = (int) (Math.random()*75+1);
            }while (chosen.contains(num));
            chosen.add(num);
            System.out.println("Chosen " + num);
            Collections.sort(chosen);
            System.out.print("LIST: ");
            for(int i : chosen){
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

    public static void main(String[] args) {

        new Thread(new BingoGame()).start();
    }
}
