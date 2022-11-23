package com.wyhw.pmp.game;

import javax.swing.*;

import static com.wyhw.pmp.game.MapPanel.PIX_WIDTH;

/**
 * @author wanyanhw
 * @date 2022/6/6 14:56
 */
public class MineClearance {

    private int width = 10;

    private int height = 10;

    private int mineTotal = 15;

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

    public static final int MINE_FLAG = -1;

    public static final int NO_MINE_NEAR = 0;

    public static void main(String[] args) {
        initMap();
    }

    public static void initMap() {
        mineClearanceInstance.loadMineMapData();
        mineClearanceInstance.showFrame();
    }

    private void showFrame() {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize((width + 2) * PIX_WIDTH, (height + 3) * PIX_WIDTH);
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
        this.mineTotal = 15;
    }

    private void increase(int indexX, int indexY) {
        if (map[indexX][indexY] == MINE_FLAG) {
            return;
        }
        map[indexX][indexY] ++;
    }
}
