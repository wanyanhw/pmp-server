package com.wyhw.pmp.game;

/**
 * @author wanyanhw
 * @date 2022/6/6 14:56
 */
public class MineClearance {

    private int width = 15;

    private int height = 5;

    private static int mineTotal = 20;

    private int[][] t;

    public static final int MINE_FLAG = 9;

    public static void main(String[] args) {
        MineClearance mineClearance = new MineClearance();
        mineClearance.loadMine(mineTotal);
        mineClearance.show();
    }

    public void show() {
        for (int[] l : t) {
            for (int v : l) {
                System.out.print(v + "  ");
            }
            System.out.println();
        }
    }

    private void loadMine(int mineTotal) {
        if (width * height < mineTotal) {
            width = height = mineTotal;
            System.out.println(String.format("已自动生成 %d*%d", width, height));
        }
        t = new int[height][width];
        int[] indexArr = new int[mineTotal * 2];
        int i = 0;

        // 随机生成炸弹
        while (mineTotal > 0) {
            int x = (int) (Math.random() * height);
            int y = (int) (Math.random() * width);
            if (t[x][y] == MINE_FLAG) {
                continue;
            }
            t[x][y] = MINE_FLAG;
            indexArr[i] = x;
            indexArr[i + 1] = y;
            mineTotal--;
            i += 2;
        }

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

    private void increase(int indexX, int indexY) {
        if (t[indexX][indexY] == MINE_FLAG) {
            return;
        }
        t[indexX][indexY] ++;
    }
}
