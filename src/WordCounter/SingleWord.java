package WordCounter;

import java.io.*;

public class SingleWord {
    static void main() throws FileNotFoundException {
        try{
            BufferedReader br = new BufferedReader(new FileReader("bigtext.txt"));
            int count = 0;
            long begin = System.currentTimeMillis();
            String line;
            while((line = br.readLine())!=null){
                count+=line.trim().split("\\s+").length;
            }
            long end = System.currentTimeMillis();
            System.out.println("TIME = " +  (end-begin));
            System.out.println("COUNT = " +  count);
        }catch(IOException e){
            System.out.println("Error Reading File");
        }
    }
}
