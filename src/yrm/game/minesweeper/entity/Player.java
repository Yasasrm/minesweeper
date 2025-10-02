package yrm.game.minesweeper.entity;

import yrm.game.minesweeper.main.Coordinates;
import yrm.game.minesweeper.main.GamePanel;
import yrm.game.minesweeper.main.KeyboardInput;
import yrm.game.minesweeper.main.MouseInput;

import java.awt.*;

public class Player {

    private int x, y;
    private int speed;
    private int clickedCount;
    private Color color;
    private GamePanel gp;
    private KeyboardInput ki;
    private MouseInput mi;

    public Player(GamePanel gp) {
        this.gp = gp;
        setDefaults();
    }

    public void setDefaults(){
        x = 100;
        y = 100;
        speed = 4;
        clickedCount = 0;
        color = Color.white;
        ki = new KeyboardInput();
        mi = new MouseInput();
        gp.addKeyListener(ki);
        gp.addMouseListener(mi);
    }

    public boolean isOnPlayer(Coordinates c){
        if (c.getX() >= x && c.getX() <= x + gp.getTileSize() && c.getY() >= y && c.getY() <= y + gp.getTileSize()) return true;
        return false;
    }

    public void update(){
        if(mi.isClicked() && isOnPlayer(mi.getCoordinates())){
                color = (color != Color.yellow) ? Color.yellow : Color.white;
                System.out.println("Player 1 Clicked");
                mi.clean();
        } else if(mi.isRightClicked() && isOnPlayer(mi.getCoordinates())){
                color = (color != Color.red) ? Color.red : Color.white;
                System.out.println("Player 1 Right Clicked");
                mi.clean();
        }
        if(ki.isUpPressed()){
            y -= speed;
        }
        if(ki.isDownPressed()){
            y += speed;
        }
        if(ki.isRightPressed()){
            x += speed;
        }
        if(ki.isLeftPressed()){
            x -= speed;
        }
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillRect(x, y, gp.getTileSize(), gp.getTileSize());
    }

}
