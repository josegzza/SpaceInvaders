/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

/**
 *
 * @author Paulina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // to create a new game 
        Game g = new Game("Breaking Bad Brick Breaker", 800, 500);
        // to initialize the game
        g.start();
    }
    
}
