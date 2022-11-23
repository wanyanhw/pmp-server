package com.wyhw.pmp.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wanyanhw
 * @date 2022/6/6 20:04
 */
public class MapPanel extends JPanel {

    public static final int PIX_WIDTH = 50;
    private int[][] map;
    private JButton[][] buttons;

    public MapPanel(int[][] map) {
        this.map = map;
        buttons = new JButton[map.length][map[0].length];
        initButtonArea();
    }

    private MapPanel initButtonArea() {
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
                            button.setText("!");
                            return;
                        }
                        button.setText(map[x][y] + "");
                        if (map[x][y] == MineClearance.MINE_FLAG) {
                            showAllMine();
                        }
                        if (map[x][y] == MineClearance.NO_MINE_NEAR) {
                            showNear(x, y, map.length, map[0].length);
                        }
                    }
                });
//                button.addActionListener(e -> {
//                    int id = e.getID();
//                    System.out.println("事件：" + id);
//                    button.setText(map[x][y] + "");
//                    if (map[x][y] == MineClearance.MINE_FLAG) {
//                        showAllMine();
//                    }
//                    if (map[x][y] == MineClearance.NO_MINE_NEAR) {
//                        showNear(x, y, map.length, map[0].length);
//                    }
//                });
                button.setVisible(true);
                buttons[i][j] = button;
                this.add(button, BorderLayout.AFTER_LAST_LINE);
            }
        }
        Button startButton = new Button("start");
        startButton.addActionListener(e -> MineClearance.initMap());
        this.add(startButton, BorderLayout.AFTER_LAST_LINE);
        return this;
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
//                if (y + i > 0 && y + i - 1 <= maxY && x + j > 0 && x + j - 1 <= maxX) {
//                }
            }
        }
    }

    private void showAllMine() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == MineClearance.MINE_FLAG) {
                    buttons[i][j].setText(MineClearance.MINE_FLAG + "");
//                    ImageIcon imageIcon = new ImageIcon("E:\\space\\idea\\pmp-server\\src\\main\\resources\\static\\pic\\mine.jpg");
//                    JButton thisButton = buttons[i][j];
//                    Image image = imageIcon.getImage().getScaledInstance(thisButton.getWidth(), thisButton.getHeight(), imageIcon.getImage().SCALE_DEFAULT);
//                    ImageIcon icon = new ImageIcon(image);
//                    thisButton.setIcon(icon);
                }
            }
        }
    }
}
