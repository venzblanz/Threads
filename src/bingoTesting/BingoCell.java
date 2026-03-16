package bingoTesting;

public class BingoCell {
    private int num;
    private boolean isPicked = false;

    public BingoCell(int num) {
        this.num = num;
    }

    public boolean isPicked() {
        return isPicked;
    }
    public void setPicked() {
        isPicked = true;
        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public String toString() {
        return num + "";
    }
}
