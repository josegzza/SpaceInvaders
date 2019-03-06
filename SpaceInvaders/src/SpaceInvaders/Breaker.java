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
public class Breaker extends Item {
    private int velX;
    private int velY;
    private Animation animation;
    private boolean started;
    
    /**
     * constructor that creates ball/breaker
     * @param game 
     */
    public Breaker(Game game) {
        // creates the ball/breaker in the middle of our bar when the game starts
        // playerBar was constructed by x, y, width, height, game
        super(game.getPlayerBar().getX()-18 + (game.getPlayerBar().getWidth() / 2), game.getPlayerBar().getY() - 60, 36, 36, game);
        this.game = game;
        velX = 0;
        velY = 0;
        started = false;
        this.animation = new Animation(Assets.ball, 40);
    }
    
    /**
     * similar to the constructor, we need to reset the ball/breaker
     */
    public void reset() {
        setX(getGame().getPlayerBar().getX() + 75);
        setY(getGame().getPlayerBar().getY() - 50);
        velX = 0;
        velY = 0;
        started = false;
    }
    
    /**
     * to get the horizontal velocity in x
     * @return velX
     */  
    public int getVelX() {
        return velX;
    }

    /**
     * to get the vertical velocity in y
     * @return velY
     */      
    public int getVelY() {
        return velY;
    }

    /**
     * To determine if it has started to move
     * @return started
     */
    public boolean isStarted() {
        return started;
    }

    /**
     * to set the horizontal velocity in x
     * @param velX 
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * to set the vertical velocity in y
     * @param velY 
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

    /**
     * to change if it has started or not
     * @param started 
     */
    public void setStarted(boolean started) {
        this.started = started;
    }

    // we need to determine the dimensions of our object to know when it intersects
    // or collides with another object
    public Rectangle getPerimeter() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    /**
     * verifying if ball/breaker intersects in top or bottom
     * @param obj
     * @return boolean value
     */
    public boolean intersectsX(Object obj) {
        return (obj instanceof Brick && (this.getPerimeter().intersects(((Brick) obj).getLeft())) || (this.getPerimeter().intersects(((Brick) obj).getRight())));
    }
    
    /**
     * verifying if ball/breaker intersects sideways
     * @param obj
     * @return boolean value
     */
    public boolean intersectsY(Object obj) {
        return (obj instanceof Brick && (this.getPerimeter().intersects(((Brick) obj).getBottom())) || (this.getPerimeter().intersects(((Brick) obj).getTop())));
    }
    
    // the following 2 methods are to verify if the ball/breaker hits the playerBar
    public Rectangle getBottom() {
        return new Rectangle(getX(), getY() + getHeight() * 2 / 4, getWidth(), getHeight() / 4);
    }
    
    public boolean intersectsPlayerBar(Object obj) {
        return(obj instanceof PlayerBar && (this.getBottom().intersects(((PlayerBar) obj).getTop())));        
    }
    
    @Override
    public void tick() {
        if(!started) {
            // checar getGame() o game
            setX(getGame().getPlayerBar().getX() - (getWidth()/2) + (getGame().getPlayerBar().getWidth()/2) );
            setY(getGame().getPlayerBar().getY() - getHeight());
        }
        if(getGame().getKeyManager().space) {
            if(!started) {
                // mover velocidad después, -3 para probar juego
                setVelY(-3);
                setY(getY() + getVelY());
            }
            started = true;
        }
        if(started) {
            setX(getX() + getVelX());
            setY(getY() + getVelY());
        }
        
        // to restart when it misses the bar
        if(getY() + getHeight() >= getGame().getHeight()) {
            reset();
        }
        else if(getY() <= 0) {
            setY(0);
            setVelY(getVelY() * - 1);
        }
        
        // to bounce with sides of the window
        if(getX() + getWidth() >= getGame().getWidth()) {
            setX(getGame().getWidth() - getWidth());
            setVelX(getVelX() * - 1);
        }
        else if(getX() <= 0) {
            setX(0);
            setVelX(getVelX() * - 1);
        }
        
        // updating animation
        this.animation.tick();
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        //g.drawImage(Assets.breaker, getX(), getY(), getWidth(), getHeight(), null);
    }
}
