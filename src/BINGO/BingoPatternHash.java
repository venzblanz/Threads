package BINGO;

public class BingoPatternHash extends BingoPattern{

    public BingoPatternHash(BingoGame game, BingoCard card) {
        super(game, card);
        threads.add(new Thread(new BingoRowChecker(card,1)));
        threads.add(new Thread(new BingoRowChecker(card,3)));
        threads.add(new Thread(new BingoColumnChecker(card,1)));
        threads.add(new Thread(new BingoColumnChecker(card,3)));

    }
}
