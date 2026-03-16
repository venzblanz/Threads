package ImageConverter;

import java.awt.image.BufferedImage;

public class ImageWorker implements Runnable {
    private int start ,end;
    private BufferedImage img;

    public ImageWorker(int start, int end, BufferedImage img) {
        this.start = start;
        this.end = end;
        this.img = img;
    }

    @Override
    public void run() {
        for (int y = start; y < end; y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int rgb = img.getRGB(x, y);
                int a = (rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int gray = (r + g + b) / 3;
                int newRGB = (a << 24) | (gray << 16) | (gray << 8) | gray;
                img.setRGB(x, y, newRGB);
            }
        }
    }
}
