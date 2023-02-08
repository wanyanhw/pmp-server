package com.wyhw.pmp.game;

import com.wyhw.pmp.LinkedList;

import javax.swing.*;
import java.awt.*;

/**
 * @author wanyanhw
 * @date 2022/11/29 15:40
 */
public class EatingSnakeGame {
    private final static Color CELL_COLOR = Color.GRAY;
    private final static Color WALL_COLOR = Color.BLACK;
    private final static Color FOOD_COLOR = Color.GREEN;
    private final static Color HEAD_COLOR = Color.YELLOW;
    private final static Color BODY_COLOR = Color.RED;
    private final static Color TAIL_COLOR = Color.PINK;

    private static CellArea food;
    private static CellArea head;
    private static java.util.List<CellArea> wall;
    private static LinkedList<CellArea> body;
    private static java.util.List<CellArea> emptyArea;

    public static void main(String[] args) {
        JFrame frame = initFrame("snake", 800, 600);

    }

    private static void drawHead(JFrame map) {

    }

    private static void drawBody(JFrame map) {

    }


    private static void drawFood(JFrame map) {
    }

    private static JFrame initFrame(String title, int width, int height) {
        JFrame jFrame = new JFrame(title);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocation(800, 200);
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
        jFrame.setLayout(new BorderLayout(0, 0));
        Button north = new Button("north");
        Button south = new Button("south");
        Button east = new Button("east");
        Button west = new Button("west");
        Button center = new Button("center");
        jFrame.add(north, BorderLayout.NORTH);
        jFrame.add(south, BorderLayout.SOUTH);
        jFrame.add(east, BorderLayout.EAST);
        jFrame.add(west, BorderLayout.WEST);
        jFrame.add(center, BorderLayout.CENTER);
        initSnake(jFrame);
        return jFrame;
    }

    private static void initSnake(JFrame jFrame) {
        drawHead(jFrame);
        drawBody(jFrame);
        drawFood(jFrame);
    }

    static class CellArea extends Label {
        private boolean wallFlag = false;
        private int locationX;
        private int locationY;

        public CellArea() {
            this(null);
        }

        public CellArea(String text) {
            super(text);
            this.setBackground(CELL_COLOR);
        }

        public boolean isWallFlag() {
            return wallFlag;
        }

        public void setWallFlag(boolean wallFlag) {
            this.wallFlag = wallFlag;
        }

        public int getLocationX() {
            return locationX;
        }

        public void setLocationX(int locationX) {
            this.locationX = locationX;
        }

        public int getLocationY() {
            return locationY;
        }

        public void setLocationY(int locationY) {
            this.locationY = locationY;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof CellArea) {
                CellArea cell = (CellArea) obj;
                return cell.locationX == this.locationX && cell.locationY == this.locationY;
            }
            return false;
        }
    }

}
