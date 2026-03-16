package bingoTesting;

import java.util.ArrayList;
import java.util.List;

public abstract class BingoPattern implements Runnable {
    protected List<Thread> threads;
    private BingoGame game;
    private BingoCard card;

    public BingoPattern(BingoGame game, BingoCard card) {
        this.game = game;
        this.card = card;
        threads = new ArrayList<Thread>();
    }

    @Override
    public void run() {
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                for(Thread t : threads){
                    t.interrupt();
                }
                return;
            }
        }
        if(game.setBingo()){
            System.out.println("Card " + card.getId() + " completes pattern");
            System.out.println(card);
        }
    }
}
