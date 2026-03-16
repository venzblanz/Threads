package bingoTesting;

public class BingoPatternPlus extends BingoPattern {
    public BingoPatternPlus(BingoGame game, BingoCard card) {
        super(game, card);
        threads.add(new Thread(new BingoRowChecker(card,2)));
        threads.add(new Thread(new BingoColumnChecker(card,2)));
    }
}
