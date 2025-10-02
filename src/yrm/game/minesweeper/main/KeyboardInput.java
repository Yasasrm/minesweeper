package yrm.game.minesweeper.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    private boolean upPressed, downPressed, rightPressed, leftPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: upPressed = true;
                break;
            case KeyEvent.VK_DOWN: downPressed = true;
                break;
            case KeyEvent.VK_LEFT: leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT: rightPressed = true;
                break;
            case KeyEvent.VK_W: upPressed = true;
                break;
            case KeyEvent.VK_S: downPressed = true;
                break;
            case KeyEvent.VK_A: leftPressed = true;
                break;
            case KeyEvent.VK_D: rightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: upPressed = false;
                break;
            case KeyEvent.VK_DOWN: downPressed = false;
                break;
            case KeyEvent.VK_LEFT: leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT: rightPressed = false;
                break;
            case KeyEvent.VK_W: upPressed = false;
                break;
            case KeyEvent.VK_S: downPressed = false;
                break;
            case KeyEvent.VK_A: leftPressed = false;
                break;
            case KeyEvent.VK_D: rightPressed = false;
                break;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }
}
