/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Paulina and José
 */
public class KeyManager implements KeyListener {
    
    public boolean left;    // flag to move left the player
    public boolean right;   // flag to move right the player
    public boolean pause;   // to pause
    public boolean start;   // enter
    public boolean space;   // space bar
    public boolean guardar; // g to save
    public boolean cargar;  // c to load

    private boolean keys[];  // to store all the flags for every key
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    public void setPause(boolean pause) {
        this.pause = pause;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        keys[e.getKeyCode()] = false;
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
        guardar = keys[KeyEvent.VK_G];
        cargar = keys[KeyEvent.VK_C];
    }
}
