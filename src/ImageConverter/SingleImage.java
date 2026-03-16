package ImageConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class SingleImage {
    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File("input.jpg"));
            long begin = System.currentTimeMillis();
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    int rgb = img.getRGB(x, y);
                    int r = (rgb >> 16) & 0xff;
                    int g = (rgb >> 8) & 0xff;
                    int b = rgb & 0xff;
                    int gray = (r + g + b) / 3;
                    int newRGB = (gray << 16) | (gray << 8) | gray;
                    img.setRGB(x, y, newRGB);
                }
            }
            long end = System.currentTimeMillis();
            ImageIO.write(img, "jpg", new File("output.png"));
            System.out.println("TIME = " + (end - begin));
            System.out.println("DONE");
        }catch (IOException e) {

        }
    }
}
