package yrm.game.minesweeper.main;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class MouseInput implements MouseInputListener {

    private boolean clicked, rightClicked;
    private Coordinates c;

    public MouseInput() {
        c = new Coordinates();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        c.setX(e.getX());
        c.setY(e.getY());
        if(SwingUtilities.isRightMouseButton(e)){
            rightClicked = true;
        } else {
            clicked = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public boolean isClicked() {
        return clicked;
    }

    public boolean isRightClicked() {
        return rightClicked;
    }

    public Coordinates getCoordinates() {
        return c;
    }

    public void clean() {
        c.setX(-1);
        c.setY(-1);
        clicked = false;
        rightClicked = false;
    }
}
