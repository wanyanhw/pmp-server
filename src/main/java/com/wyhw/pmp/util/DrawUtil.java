package com.wyhw.pmp.util;

import com.madgag.gif.fmsware.AnimatedGifEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wanyanhw
 * @date 2022/11/25 11:27
 */
public class DrawUtil {
    public static BufferedImage drawTaiJi(int x, int y, int r) {
        int rate = 5;
        BufferedImage image = new BufferedImage(2 * r, 2 * r, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(new Color(127, 127, 127));
        g.fillRect(x, y, 2 * r, 2 * r);

        g.setColor(Color.BLACK);
        g.fillRoundRect(x, y, 2 * r, 2 * r, 2 * r, 2 * r);

        g.setColor(Color.WHITE);
        g.fillArc(x, y, 2 * r, 2 * r, 90, 180);

        // 阴
        g.setColor(Color.BLACK);
        g.fillRoundRect((x + r) / 2, y, r, r, r, r);
        // 阴中阳
        g.setColor(Color.WHITE);
        g.fillRoundRect((int) (x + r * 0.9), (int) (y + r * 0.4), r / rate, r / rate, r / rate, r / rate);

        // 阳
        g.setColor(Color.WHITE);
        g.fillRoundRect((x + r) / 2, y + r, r, r, r, r);
        // 阳中阴
        g.setColor(Color.BLACK);
        g.fillRoundRect((int) (x + r * 0.9), (int) (y + r * 1.4), r / rate, r / rate, r / rate, r / rate);

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(new Color(127, 127, 127));
        graphics.fillRect(x, y, 2 * r, 2 * r);
        graphics.rotate(Math.PI / 8 * 8, image.getWidth() / 2, image.getTileHeight() / 2);
        graphics.drawImage(image, 0, 0, null);
        return bufferedImage;
    }

    public static void output(BufferedImage image) {
        try {
            ImageIO.write(image, "png", new FileOutputStream("C:\\Users\\wanyanhw\\Desktop\\wyhw9.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        BufferedImage image = drawTaiJi(0, 0, 200);
        output(image);
    }

    public static void main(String[] args) throws IOException {
        BufferedImage[] bufferedImages = new BufferedImage[16];
        for (int i = 0; i < 16; i++) {
            String path = "C:\\Users\\wanyanhw\\Desktop\\taiji\\wyhw" + (i + 1) + ".png";
            bufferedImages[i] = ImageIO.read(new File(path));
        }

        AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
        gifEncoder.setSize(400, 400);
        gifEncoder.start("C:\\Users\\wanyanhw\\Desktop\\taiji\\taiji.gif");
        gifEncoder.setDelay(50);
        gifEncoder.setRepeat(0);
        for (BufferedImage bufferedImage : bufferedImages) {
            gifEncoder.addFrame(bufferedImage);
        }
        gifEncoder.finish();
    }
}
