package BINGO;

public class BingoColumnChecker extends BingoChecker{
    int cols;
    public BingoColumnChecker(BingoCard card, int cols) {
        super(card);
        this.cols = cols;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            if(!(getCard().getCell(i,cols).isPicked())){
                try {
                    synchronized (getCard().getCell(i,cols)){
                        getCard().getCell(i,cols).wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Card " + getCard().getId() + "'s col loses while waiting for " + getCard().getCell(i,cols));
                    return;
                }
            }

        }
    }
}
