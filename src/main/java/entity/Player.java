package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValue();
    }

    public void setDefaultValue() {
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
        } else if (keyHandler.downPressed) {
            y += speed;
        } else if (keyHandler.leftPressed) {
            x -= speed;
        } else if (keyHandler.rightPressed) {
            x += speed;
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
}
