package BINGO;

public class BingoRowChecker extends BingoChecker{
    int row;
    public BingoRowChecker(BingoCard card, int row) {
        super(card);
        this.row = row;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            if(!(getCard().getCell(row,i).isPicked())){
                try {
                    synchronized (getCard().getCell(row,i)){
                        getCard().getCell(row,i).wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Card " + getCard().getId() + "'s row loses while waiting for " + getCard().getCell(row,i));
                    return;
                }
            }

        }
    }
}
