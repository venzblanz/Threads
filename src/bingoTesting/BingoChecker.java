package bingoTesting;

public abstract class BingoChecker implements Runnable {
    protected BingoCard card;
    public BingoChecker(BingoCard card) {
        this.card = card;
    }

    public BingoCard getCard() {
        return card;
    }
}
