/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

/**
 *
 * @author Paulina
 */
public class Game implements Runnable {
    private Thread thread;              // thread to create game
    private BufferStrategy bs;          // to have several buffers
    private Graphics g;                 // to paint objects in the game
    private String title;               // title of game window
    private int width;                  // width of game window
    private int height;                 // height of game window
    private boolean running;            // to set the game
    private Display display;            // to display
    private KeyManager keyManager;      // to control the keyboard
    private LinkedList<Brick> bricks;   // bricks
    private Breaker breaker;            // ball
    private PlayerBar playerBar;        // bar
    private boolean gameOver;           // to determine when to end game
    private boolean pause;              // to determine if the game is paused
    private boolean pausing;            // to determine if the player is pressing
    private boolean areWePaused;
    private int brickSpace;
    
    /**
     * Our constructor, to create title, width, and height
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        bricks = new LinkedList<Brick>();  
        gameOver = true;
        pause = true;
        pausing = false;
        areWePaused = false;
    }
    
    /**
     * accessing the title of the game
     * @return width
     */
    public String getTitle() {
        return title;
    }

    /**
     * accessing the width of the game
     * @return width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * accessing the height of the game
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * accessing the keys the player presses/releases
     * @return keyManager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    /**
     * accessing the bar and it's attributes for our Breaker class
     * @return PlayerBar
     */
    public PlayerBar getPlayerBar() {
        return playerBar;
    }     
    
    /**
     * accessing the ball/breaker and it's attributes 
     * @return PlayerBar
     */
    public Breaker getBreaker() {
        return breaker;
    }    
    
    public int getBrickSpace() {
        return brickSpace;
    }
    
    public void setBrickSpace(int brickSpace) {
        this.brickSpace = brickSpace;
    }

    private void init() {
        display = new Display(getTitle(), getWidth(), getHeight());
        Assets.init();
        playerBar = new PlayerBar(getWidth() / 2 - 100, this);
        breaker = new Breaker(this);
        // to determine how many bricks can we place
        setBrickSpace( getWidth() / 25);
        for(int i = 0; i < brickSpace; i++) {
            for(int j = 0; j < 3; j++) {
                bricks.add(new Brick(25 * i, 25 * j, this, 2));
            }
        }
        display.getJframe().addKeyListener(keyManager);
    }
    
    @Override
    public void run() {
        init();
        int fps = 50; 
        double timeTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timeTick;
            lastTime = now;
            if (gameOver) {
                // we need to display the game over screen
                tickGO();
                renderGO();
                // we need to display the "Press ENTER to start"
            } else {
                if (delta >= 1) {
                    tick();
                    render();
                    delta--;
                }
            }
        }
        stop();
    }
    
    /**
     * to set a thread for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    /**
     * to stop the thread for the game
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
  
    /**
     * to tick when the game is over
     */
    private void tickGO() {
        keyManager.tick();
        if (getKeyManager().start) {
            gameOver = false;
        }
    }
    
    
    private void tick() {
       keyManager.tick();
       // to pause the game, progress stops  
       if(!pausing && getKeyManager().getPause()) {
           pausing = true;
       } else if (!getKeyManager().getPause() && pausing) {
           // pausing = true;
           getKeyManager().setPause(true);
       }
       // if it is paused an need to unpause
       else if(pausing && getKeyManager().getPause()) {
           pausing = false;
       } else if (getKeyManager().getPause() && !pausing) {
           // pausing = false;
           getKeyManager().setPause(false);
       }
       
       /*
        if(!areWePaused && getKeyManager().getPause()) {
           areWePaused = true;
       } else if (!getKeyManager().getPause() && areWePaused) {
           areWePaused = true;
           getKeyManager().setPause(true);
       }
          
        if(areWePaused && getKeyManager().getPause()) {
           areWePaused = false;
           getKeyManager().setPause(false);
       } else if (!getKeyManager().getPause() && !areWePaused) {
           areWePaused = false;
           getKeyManager().setPause(false);
       }
        */
       // cuando el juego está corriendo
       if(!getKeyManager().getPause()) {
           // boolean hit = false; // verifying when the brick was hit
           playerBar.tick();
           breaker.tick();
           for(int i = 0; i < bricks.size(); i++) {
               Brick brick = bricks.get(i);
               brick.tick();
               // play sound and remove brick when hit by breaker
               if (getBreaker().intersectsX(brick)) {
                   // hit = true;
                   brick.setDamage(brick.getDamage() - 1);
                   if(brick.getDamage() != 0) {
                       // play un asset
                   }
                   if(brick.getDamage() == 0) {
                       bricks.remove(brick);
                       // play un asset
                   }
                   getBreaker().setVelX(getBreaker().getVelX() * - 1);
               }
                if (getBreaker().intersectsY(brick)) {
                   // hit = true;
                   brick.setDamage(brick.getDamage() - 1);
                   if(brick.getDamage() != 0) {
                       // play un asset
                   }
                   if(brick.getDamage() == 0) {
                       bricks.remove(brick);
                       // play un asset
                   }
                   bricks.remove(brick);
                   getBreaker().setVelY(getBreaker().getVelY() * - 1);
               }
           }
           if(bricks.isEmpty()) {
               gameOver = true;
           }  
           double middle = breaker.getX()+(breaker.getWidth()/2);
           double percentage;
           if(breaker.intersectsPlayerBar(playerBar)) {
               percentage = ((middle - playerBar.getX())-100);
               breaker.setVelX((int)(percentage/100 * 3));
               breaker.setVelY(breaker.getVelY() * -1);
               // play a sound
           }
       }
    }
  
    /**
     * game over render for viewing purposes
     */
    private void renderGO() {
        //get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.gameOver, 0, 0, width, height, null);
            g.setColor(Color.YELLOW);
            g.drawString("Press ENTER to start" , 350, getHeight() - 60);
            bs.show();
            g.dispose();
        }
            
     }
    private void render() {
        // to get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* If it's null, we define one with 3 buffers to display images of the
        game. If it's not null, then we display every image of the game but after
        clearing the Rectangle, getting the graphic object from the buffer
        strategy element. We show the graphics then dispose them.
        */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.background, 0, 0, width, height, null);
            playerBar.render(g);
            breaker.render(g);
            for(int i = 0; i < bricks.size(); i++) {
                Brick brick = bricks.get(i);
                brick.render(g);
            }
            bs.show();
            g.dispose();
        }
    }

    public LinkedList<Brick> getBricks() {
        return bricks;
    }
}