package com.wyhw.pmp.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 生成图片验证码
 * @author wanyanhw
 * @date 2020年4月12日
 */
public class VerifyCodeUtils {

    private final static String RANDOM_CODE_KEY = "RANDOM_CODE_KEY";
    /**
     * 随机字符
     */
    private final String randomChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 图片宽度
     */
    private final int imgWidth = 80;
    /**
     * 图片高度
     */
    private final int imgHeight = 35;
    /**
     * 字符数量
     */
    private final int charNum = 5;
    /**
     * 干扰线数量
     */
    private final int lineNum = 6;

    private Random random = new Random();

    /**
     * 获取验证码图片
     */
    public void getCodeImg(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, imgWidth, imgHeight);
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        // 字体颜色
        g.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= lineNum; i++) {
            drowLine(g);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= charNum; i++) {
            randomString = drowString(g, randomString, i);
        }
        //将生成的随机字符串保存到session中
        session.removeAttribute(RANDOM_CODE_KEY);
        session.setAttribute(RANDOM_CODE_KEY, randomString);
        //设置失效时间1分钟
        session.setMaxInactiveInterval(60);
        g.dispose();
        try {
            // 设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            // 设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获得颜色
     */
    private Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 绘制干扰线
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(imgWidth);
        int y = random.nextInt(imgHeight);
int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 绘制字符串
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
                .nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randomChars.length())));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    /**
     * 获得字体
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /**
     * 获取随机的字符
     */
    private String getRandomString(int num) {
        return String.valueOf(randomChars.charAt(num));
    }

}
