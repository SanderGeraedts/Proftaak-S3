package GameLogic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kasper
 */
public class Sprite {
    
    int width;
    int height;
    int rows;
    int columns;
    BufferedImage[] sprites;
    
    /**
     * 
     */
    public Sprite() {
        
    }
    
    public static Image LoadSprite(String path, int width, int height) {
        Image img = new Image(path, width, height, false, false);
        return img;
    }
    
    /**
     * 
     * @param w - width of the spritesheet
     * @param h - height of the spritesheet
     * @param r - amount of rows in the spritesheet
     * @param c - amount of columns in the spritesheet
     * @param buffImg - the loaded spritesheet
     * @return
     * @throws IOException 
     */
    public BufferedImage[] LoadSpriteSheet(int w, int h, int r, int c, BufferedImage buffImg) throws IOException {
        sprites = new BufferedImage[r * c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sprites[(i * c) + j] = buffImg.getSubimage(i * w, j * h, w, h);
            }
        }
        return sprites;
    }
}
