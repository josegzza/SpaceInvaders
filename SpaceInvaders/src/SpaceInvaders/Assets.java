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
public class Assets {
    public static BufferedImage background;
    public static BufferedImage breaker;
    public static BufferedImage brick;
    public static BufferedImage sprites;
    public static BufferedImage ball[]; // pictures of the ball/breaker
    public static BufferedImage playerBar;
    public static BufferedImage gameOver;
    //public static SoundClip 
            
    public static void init() {
        background = ImageLoader.loadImage("/images/desert.jpg");
        brick = ImageLoader.loadImage("/images/meth.png");
        breaker = ImageLoader.loadImage("/images/breaker.png");
        sprites = ImageLoader.loadImage("/images/hank.png");
        playerBar = ImageLoader.loadImage("/images/bar.png");
        gameOver = ImageLoader.loadImage("/images/gameOver.png");
        
        Spreadsheet spritesheet = new Spreadsheet(sprites);
        ball = new BufferedImage[9];
        // cropping the pictures from the sheet into the array
        for(int i = 0; i < 9; i++) {
            ball[i] = spritesheet.crop(i * 64, 128, 64, 64);
        }
    }
}
