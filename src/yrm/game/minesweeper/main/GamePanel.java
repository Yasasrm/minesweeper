package yrm.game.minesweeper.main;

import yrm.game.minesweeper.entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private final int originalTileSize = 16;
    private final int scale = 1;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 20;

    private final int tileSize = originalTileSize * scale;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    Thread gt;
    Player p1 = new Player(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void startGame() {
        gt = new Thread(this);
        gt.start();
    }

    public void update() {
        p1.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        p1.draw(g2d);
    }

    public int getTileSize() {
        return tileSize;
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/60; // nanosecond/FPS
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gt != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta > 1){
                update();
                repaint();
                delta--;
            }

        }
    }
}
