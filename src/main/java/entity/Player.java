package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);
        setDefaultValue();
    }

    public void setDefaultValue() {
        worldX = gamePanel.tileSize * 7;
        worldY = gamePanel.tileSize * 6;
        speed = 1;
    }
    public void update() {
        int newWorldX = worldX;
        int newWorldY = worldY;

        if (keyHandler.upPressed) {
            newWorldY -= gamePanel.tileSize;
        } else if (keyHandler.downPressed) {
            newWorldY += gamePanel.tileSize;
        } else if (keyHandler.leftPressed) {
            newWorldX -= gamePanel.tileSize;
        } else if (keyHandler.rightPressed) {
            newWorldX += gamePanel.tileSize;
        }

        if (newWorldX >= 0 && newWorldX + gamePanel.tileSize <= gamePanel.screenWidth &&
                newWorldY >= 0 && newWorldY + gamePanel.tileSize <= gamePanel.screenHeight) {

            // Check for collision with occupied tiles
            boolean collisionDetected = false;
            // Implement collision detection logic here
            if (!collisionDetected) {
                worldX = newWorldX;
                worldY = newWorldY;
            }
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.blue);
        g2.fillRect(worldX, worldY, gamePanel.tileSize, gamePanel.tileSize);
    }
}
