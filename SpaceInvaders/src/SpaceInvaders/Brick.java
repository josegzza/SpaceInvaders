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
public class Brick extends Item {
    private int damage;
    
    /**
     * constructor
     * @param x
     * @param y
     * @param game
     */
    public Brick(int x, int y, Game game, int damage) {
        super(x, y, 65, 65, game);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
       
    /**
     * to get the perimeter of the brick
     * @return a Rectangle object
     */
    public Rectangle getPerimeter() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Now, we need to identify whether the ball/breaker hits the brick on the
     * top, bottom, left, or right side.
     */
    public Rectangle getBottom() {
        return new Rectangle(getX(), getY() + getHeight() * 2 / 4, getWidth(), getHeight() / 4);
    }
    
    public Rectangle getTop() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight() / 4);
    }
    
    public Rectangle getLeft() {
        return new Rectangle(getX(), getY(), getWidth() / 4, getHeight());
    }
    
    public Rectangle getRight() {
        return new Rectangle(getX() + getWidth() * 2 / 4, getY(), getWidth() / 4, getHeight());
    }
    
    @Override
    public void tick() {     
    }

    @Override
    public void render(Graphics g) {
        if(damage == 2) {
            g.drawImage(Assets.brick, getX(), getY(), getWidth(), getHeight(), null);
        }
        else if (damage == 1) {
            g.drawImage(Assets.brick, getX(), getY(), getWidth(), getHeight(), null);
        }
        else {
            g.drawImage(Assets.brick, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}
