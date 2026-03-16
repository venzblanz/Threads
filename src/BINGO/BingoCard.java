package BINGO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class BingoCard {
    private BingoCell[][] nums;
    private static  int ID = 1;
    private int id;
    public BingoCell getCell(int r, int c){
        return nums[r][c];
    }
    public BingoCard(BingoGame game) {
        id = ID++;
        nums = new BingoCell[5][5];
        Random rand = new Random();
        for(int i = 0 ; i < 5; i++){
            int start = i * 15 + 1;
            int end = start + 14;
            boolean dupe = false;
            List<Integer> chosen = new ArrayList<>();
                for(int j = 0; j < 5; j++){
                    int ind;

                    do{
                        ind = rand.nextInt(start,end) + 1;
                    }while(chosen.contains(ind));

                    chosen.add(ind);

                    if(i == 2 && j ==2){
                        nums[2][2] = game.getCell(0);
                        continue;
                    }


                    nums[j][i] = game.getCell(ind);
                }

        }
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Card " + id + "\n");
        sb.append("B\tI\tN\tG\tO\n");
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                sb.append(nums[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BingoGame game = new BingoGame();
//        new Thread(game).start();
        System.out.println(new BingoCard(game));
    }
}
