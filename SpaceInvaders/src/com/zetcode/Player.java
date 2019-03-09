package com.zetcode;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends Sprite implements Commons {

    private final int START_Y = 280;
    private final int START_X = 270;
    private boolean pause;

    private final String playerImg = "src/images/player.png";
    private int width;

    public Player() {

        initPlayer();
    }
    
    public void setPause(boolean pause){
        this.pause=pause;
    }
    
    private void initPlayer() {
        
        ImageIcon ii = new ImageIcon(playerImg);

        width = ii.getImage().getWidth(null);

        setImage(ii.getImage());
        setX(START_X);
        setY(START_Y);
    }
    
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public void act() {
        
        x += dx;
        
        if (x <= 2) {
            x = 2;
        }
        
        if (x >= BOARD_WIDTH - 2 * width) {
            x = BOARD_WIDTH - 2 * width;
        }
        
       
    }

    public void keyPressed(KeyEvent e) {
        if(!pause){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
        
            dx = 0;
        }
    }
}