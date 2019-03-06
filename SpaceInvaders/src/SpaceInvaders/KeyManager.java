/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Paulina
 */
public class KeyManager implements KeyListener {
    
    public boolean left;    // flag to move left the player
    public boolean right;   // flag to move right the player
    public boolean pause;
    public boolean start;
    public boolean space;
    public boolean load;
    public boolean file;
    
    public boolean clickedAlready;

    private boolean keys[];  // to store all the flags for every key
    
    public boolean getPause() {
        return pause;
    }
    
    public boolean getClickedAlready() {
        return clickedAlready;
    }
    
    public void setPause(boolean pause) {
        this.pause = pause;
    }
    
    public void setClickedAlready() {
        this.clickedAlready = clickedAlready;
    }
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        keys[e.getKeyCode()] = true;
        if(keys[e.getKeyCode()] == keys[KeyEvent.VK_P]) {
            // keys[e.getKeyCode()] = false;
            pause = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        keys[e.getKeyCode()] = false;
        /*
        if (e.getKeyCode() == KeyEvent.VK_P) {
            keys[e.getKeyCode()] = true;
        }
        */
    } 
    
    /**
     * to enable or disable moves on every tick
     */
    public void tick() {
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        pause = keys[KeyEvent.VK_P];
        start = keys[KeyEvent.VK_ENTER];
        space = keys[KeyEvent.VK_SPACE];
    }
}
