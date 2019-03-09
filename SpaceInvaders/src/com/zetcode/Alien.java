package com.zetcode;

import javax.swing.ImageIcon;

public class Alien extends Sprite {

    private Bomb bomb;
    private final String alienImg = "src/images/alien.png";

    public Alien(int x, int y) {

        initAlien(x, y);
    }
    
    public Alien(int x, int y,int bombx,int bomby){
        initAlien(x,y,bombx,bomby);
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    private void initAlien(int x, int y) {

        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);
        ImageIcon ii = new ImageIcon(alienImg);
        setImage(ii.getImage());
    }
    
    private void initAlien(int x, int y,int bombx,int bomby) {

        this.x = x;
        this.y = y;

        bomb = new Bomb(bombx, bomby);
        ImageIcon ii = new ImageIcon(alienImg);
        setImage(ii.getImage());
    }

    public void act(int direction) {
        
        this.x += direction;
    }

    public Bomb getBomb() {
        
        return bomb;
    }

    public class Bomb extends Sprite {

        private final String bombImg = "src/images/bomb.png";
        private boolean destroyed;

        public Bomb(int x, int y) {

            initBomb(x, y);
        }

        private void initBomb(int x, int y) {

            setDestroyed(true);
            this.x = x;
            this.y = y;
            ImageIcon ii = new ImageIcon(bombImg);
            setImage(ii.getImage());

        }
        public void setX(int x){
            this.x=x;
        }
        
        public void setY(int y){
            this.y=y;
        }
        public void setDestroyed(boolean destroyed) {
        
            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {
        
            return destroyed;
        }
    }
}