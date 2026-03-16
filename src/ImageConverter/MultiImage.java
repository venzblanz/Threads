package ImageConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MultiImage {
    static void main(String[] args) {
        try{
            BufferedImage img = ImageIO.read(new File("input.jpg"));
            int thr = 5;
            Thread[] threads = new Thread[thr];
            int y = img.getHeight();
            int div = y / thr;
            long start = System.currentTimeMillis();

            for(int i = 0; i < thr; i++){
                int startRow = i * div;
                int endRow = (i == thr - 1) ? (y - 1) : (i + 1) * div;
                threads[i] = new Thread(new ImageWorker(startRow, endRow, img));
                threads[i].start();
            }
            for(int i  = 0; i < thr; i++){
                threads[i].join();
            }
            long end = System.currentTimeMillis();
            ImageIO.write(img, "jpg", new File("output.png"));
            System.out.println("TIME = " + (end - start));
        } catch (IOException | InterruptedException e) {
        }
    }
}
