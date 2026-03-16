package bingoTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BingoCard {
    private BingoCell[][] num;
    private static int ID = 1;
    private int id;

    public BingoCell getCell(int r, int c){
        return num[r][c];
    }

    public int getId() {
        return id;
    }

    public BingoCard(BingoGame game) {
        id = ID++;
        num = new BingoCell[5][5];
        for(int i = 0; i < 5; i++){
            int start = i * 15 + 1;
            int end = start + 14;
            int n;
            List<Integer> chosen = new ArrayList<>();
            Random rand = new Random();
            for(int j = 0; j < 5; j++){
                do{
                    n = rand.nextInt(end - start) + start;
                }while(chosen.contains(n));
                chosen.add(n);
                if(i == 2 && j ==2){
                    num[2][2] = game.getCell(0);
                }
                num[j][i] = game.getCell(n);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Card " + id + "\n");
        sb.append("B\tI\tN\tG\tO\n");
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                sb.append(num[i][j]).append("\t");
            }sb.append("\n");
        }
        return sb.toString();
    }
}
