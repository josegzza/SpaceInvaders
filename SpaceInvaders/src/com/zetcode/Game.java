/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode;

import java.util.LinkedList;

/**
 *
 * @author paulina
 */
public class Game {
    private KeyManager keyManager=new KeyManager();
    
    
    /**
     * accessing the keys the player presses/releases
     * @return keyManager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }
}
