package BINGO;

public class BingoCell {
    private int num;
    private boolean picked = false;


    public BingoCell(int num) {
        this.num = num;
    }
    public void setPicked() {
        this.picked = true;
        synchronized (this){
            notifyAll();
        }
    }
    public boolean isPicked(){
        return picked;
    }
    public String toString(){
        return num + "";
    }
}
