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
                if (map[i][j] == MineClearance.MINE_FLAG) {
                    s = "*";
                }
                g.drawString(s, (j + 1) * PIX_WIDTH, (i + 1) * PIX_WIDTH);
                g.drawRect((j + 1) * PIX_WIDTH - PIX_WIDTH / 2, (i + 1) * PIX_WIDTH - PIX_WIDTH / 2, PIX_WIDTH, PIX_WIDTH);
            }
        }
    }

    public MapPanel addButton() {
        this.setLayout(new BorderLayout());
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
//                button.setLocation((i + 1) * PIX_WIDTH, (j + 1) * PIX_WIDTH);
//                button.setSize(PIX_WIDTH, PIX_WIDTH);
//                button.setVisible(true);
                this.add(new JButton(String.format("[%d][%d]", i, j)), FlowLayout.LEFT);
            }
        }
        return this;
    }
}
