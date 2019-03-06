/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.awt.image.BufferedImage;

/**
 *
 * @author Paulina
 */
public class Spreadsheet {
    private BufferedImage sheet;    // to store the sprite sheet
    
    /**
     * create a new sprite sheet
     * @param sheet the <code>image</code> with the sprites
     */
    public Spreadsheet(BufferedImage sheet) {
        this.sheet = sheet;
    }
    
    /**
     * crop a sprite from the sprite sheet
     * @param x an <code>int</code> value with the x coordinate
     * @param y an <code>int</code> value with the y coordinate
     * @param width an <code>int</code> value with the width of a sprite
     * @param height an <code>int</code> value with the height of a sprite
     * @return
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}