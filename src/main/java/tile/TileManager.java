package tile;

import entity.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Player player;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grayTile.png")));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/whiteTile.png")));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/blueTail.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        int tileSize  = gp.tileSize;
        int rows = gp.maxWorldRow;
        int cols = gp.maxWorldCol;
        int offsetX = gp.getX();
        int offsetY = gp.getY();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * tileSize - offsetX;
                int y = row * tileSize - offsetY;
                Tile currentTile = (row + col) % 2 == 0 ? tile[0] : tile[1];
                g2.drawImage(currentTile.image, x, y, tileSize, tileSize, null);
            }
        }

    }
}
