/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Paulina
 */
public class PlayerBar extends Item{
    /**
     * constructor to create the bar in starting x position
     * @param x
     * @param game
     */
    public PlayerBar(int x, Game game) {
        super(x, game.getHeight()-50, 200, 50, game);
    }

    /**
     * to get the perimeter of the bar
     * @return perimeter
     */
    public Rectangle getPerimeter() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    /**
     * to identify if the ball/breaker hits the top part of the bar
     */
    public Rectangle getTop() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight() / 4);
    }
    
    /**
     * to identify if the perimeter contains a certain point
     * @param x
     * @param y
     * @return boolean
     */
    public boolean contains(int x, int y) {
        return getPerimeter().contains(x, y);
    }
    
    @Override
    public void tick() {
        // to reset position
        if(getX() + getWidth() >= getGame().getWidth()) {
            setX(getGame().getWidth() - getWidth());
        }
        else if (getX() <= 0) {
            setX(0);
        }
        
        // to move the player sideways
        if(game.getKeyManager().left) {
            setX(getX() - 3);        
        }
        
        if(game.getKeyManager().right) {
            setX(getX() + 3);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerBar, getX(), getY(), getWidth(), getHeight(), null);
    }
    
}
