/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode;

import SpaceInvaders.ImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author Paulina and José
 */
public class Assets {
    public static BufferedImage background;
    public static BufferedImage player;
    public static BufferedImage shot;
    public static BufferedImage alien;
    
    public static void init() {
        background = ImageLoader.loadImage("/images/background.jpg");
        player = ImageLoader.loadImage("/images/player.jpg");
        alien = ImageLoader.loadImage("/images/alien.jpg");
    } 
}
//Example