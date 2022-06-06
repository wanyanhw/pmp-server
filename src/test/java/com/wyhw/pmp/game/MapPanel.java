package com.wyhw.pmp.game;

import javax.swing.*;
import java.awt.*;

/**
 * @author wanyanhw
 * @date 2022/6/6 20:04
 */
public class MapPanel extends JPanel {
    public static final int PIX_WIDTH = 40;
    private int[][] map;

    public MapPanel(int[][] map) {
        this.map = map;
    }
    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < map.length; i++) {
            g.setColor(Color.BLACK);
            for (int j = 0; j < map[i].length; j++) {
                String s = map[i][j] + "";
                if (map[i][j] == 9) {
                    s = "*";
                }
//                g.drawString(s, (i + 1) * PIX_WIDTH, (j + 1) * PIX_WIDTH);
                g.drawRect((i + 1) * PIX_WIDTH, (j + 1) * PIX_WIDTH, PIX_WIDTH, PIX_WIDTH);
            }
        }
    }
}
