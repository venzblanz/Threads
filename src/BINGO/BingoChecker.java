package BINGO;

public abstract class BingoChecker implements Runnable{
    private BingoCard card;

    public BingoCard getCard() {
        return card;
    }

    public BingoChecker(BingoCard card) {
        this.card = card;
    }

}
