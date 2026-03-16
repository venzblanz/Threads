package bingoTesting;

public class BingoColumnChecker extends BingoChecker {
    int col;

    public BingoColumnChecker (BingoCard card, int col) {
        super(card);
        this.col = col;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            if(!(getCard().getCell(i,col).isPicked())){
                try{
                    synchronized (getCard().getCell(i,col)) {
                        getCard().getCell(i,col).wait();
                    }
                }catch(InterruptedException e){
                    System.out.println("Card " + getCard().getId() + "'s col loses while waiting for " + getCard().getCell(i,col));
                    return;
                }
            }
        }
    }
}
