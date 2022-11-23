package com.wyhw.pmp.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wanyanhw
 * @date 2022/6/6 14:56
 */
public class MineClearance {

    private int width = 10;

    private int height = 10;

    private final int mineNum = 15;

    private int mineTotal = mineNum;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setMineTotal(int mineTotal) {
        this.mineTotal = mineTotal;
    }

    private int[][] map;

    private static final MineClearance mineClearanceInstance = new MineClearance();

    private static final JFrame jFrame = new JFrame();

    private static final int MINE_FLAG = -1;

    private static final int NO_MINE_NEAR = 0;

    public static void main(String[] args) {
        initMap();
    }

    private static void initMap() {
        mineClearanceInstance.loadMineMapData();
        mineClearanceInstance.showFrame();
    }

    private void showFrame() {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize((width + 2) * MapPanel.PIX_WIDTH, (height + 3) * MapPanel.PIX_WIDTH);
        jFrame.setLocation(800, 200);
        jFrame.add(new MapPanel(map), 0);
        jFrame.setVisible(true);
    }

    private void loadMineMapData() {
        if (width * height < mineTotal) {
            width = height = mineTotal;
            System.out.println(String.format("已自动生成 %d*%d", width, height));
        }
        map = new int[height][width];
        int[] indexArr = new int[mineTotal * 2];
        int i = 0;

        // 随机生成炸弹
        while (mineTotal > 0) {
            int x = (int) (Math.random() * height);
            int y = (int) (Math.random() * width);
            if (map[x][y] == MINE_FLAG) {
                continue;
            }
            map[x][y] = MINE_FLAG;
            indexArr[i] = x;
            indexArr[i + 1] = y;
            mineTotal--;
            i += 2;
        }
        resetMineTotal();

        // 生成炸弹周围提示信息
        for (int i1 = 0; i1 < indexArr.length; i1+=2) {
            int indexX = indexArr[i1];
            int indexY = indexArr[i1 + 1];

            int lx = indexX - 1;
            int rx = indexX + 1;

            int ly = indexY - 1;
            int ry = indexY + 1;

            if (lx >= 0) {
                increase(lx, indexY);
                if (ly >= 0) {
                    increase(lx, ly);
                }
                if (ry < width) {
                    increase(lx, ry);
                }
            }

            if (ly >= 0) {
                increase(indexX, ly);
            }
            if (ry < width) {
                increase(indexX, ry);
            }

            if (rx < height) {
                increase(rx, indexY);
                if (ly >= 0) {
                    increase(rx, ly);
                }
                if (ry < width) {
                    increase(rx, ry);
                }
            }
        }
    }

    private void resetMineTotal() {
        this.mineTotal = mineNum;
    }

    private void increase(int indexX, int indexY) {
        if (map[indexX][indexY] == MINE_FLAG) {
            return;
        }
        map[indexX][indexY] ++;
    }

    private static class MapPanel extends JPanel {

        public static final int PIX_WIDTH = 50;
        private int[][] map;
        private JButton[][] buttons;

        MapPanel(int[][] map) {
            this.map = map;
            buttons = new JButton[map.length][map[0].length];
            initButtonArea();
        }

        private void initButtonArea() {
            this.setLayout(new BorderLayout());
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    final int x = i, y = j;
                    JButton button = new JButton();
                    button.setBounds((j + 1) * PIX_WIDTH, (i + 1) * PIX_WIDTH, PIX_WIDTH, PIX_WIDTH);
                    button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int btn = e.getButton();
                            if (btn == MouseEvent.BUTTON3) {
                                // 鼠标右键点击
                                if (button.getText().equals("L")) {
                                    resetButton(button);
                                    return;
                                }
                                button.setText("L");
                                button.setBackground(Color.RED);
                                return;
                            }
                            if (button.getText().equals("L")) {
                                resetButton(button);
                            }
                            button.setText(map[x][y] + "");
                            if (map[x][y] == MINE_FLAG) {
                                showAllMine();
                            }
                            if (map[x][y] == NO_MINE_NEAR) {
                                showNear(x, y, map.length, map[0].length);
                            }
                        }
                    });
                    button.setVisible(true);
                    buttons[i][j] = button;
                    this.add(button, BorderLayout.AFTER_LAST_LINE);
                }
            }
            Button startButton = new Button("start");
            startButton.addActionListener(e -> initMap());
            this.add(startButton, BorderLayout.AFTER_LAST_LINE);
        }

        private void resetButton(JButton button) {
            button.setText("");
            button.setBackground(MapPanel.super.getParent().getBackground());
        }

        private void showNear(int x, int y, int maxX, int maxY) {
            for (int i = 0; i <= 2; i ++) {
                for (int j = 0; j <= 2; j++) {
                    int indexX = x + j - 1;
                    int indexY = y + i - 1;
                    if (indexX < 0 || indexY < 0 || indexX >= maxX || indexY >= maxY) {
                        continue;
                    }
                    buttons[indexX][indexY].setText(map[indexX][indexY] + "");
                }
            }
        }

        private void showAllMine() {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == MINE_FLAG) {
                        JButton thisButton = buttons[i][j];
                        thisButton.setText(MINE_FLAG + "");
                    }
                }
            }
        }
    }
}
